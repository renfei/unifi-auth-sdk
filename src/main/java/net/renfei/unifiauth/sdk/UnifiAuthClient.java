package net.renfei.unifiauth.sdk;

import net.renfei.unifiauth.sdk.entity.AccessTokenDataObject;
import net.renfei.unifiauth.sdk.entity.CallbackDataObject;
import net.renfei.unifiauth.sdk.service.UserService;
import net.renfei.unifiauth.sdk.utils.HttpClientUtils;
import net.renfei.unifiauth.sdk.utils.JSONUtils;
import org.apache.commons.lang3.StringUtils;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 统一认证客户端
 *
 * @author renfei
 */
public final class UnifiAuthClient {
    public final static String URI_SEPARATOR = "/";
    public final static String RESPONSE_TYPE = "?response_type=code";
    public final String UNIFI_AUTH_SERVER_URI;
    public final String CLIENT_ID;
    public final String CLIENT_SECRET;
    public final String REDIRECT_URI;

    private UnifiAuthClient() {
        throw new RuntimeException("Prohibit direct instantiation.");
    }

    public UnifiAuthClient(String unifiAuthServerUri, String clientId, String clientSecret, String redirectUri) {
        UNIFI_AUTH_SERVER_URI = unifiAuthServerUri;
        CLIENT_ID = clientId;
        CLIENT_SECRET = clientSecret;
        REDIRECT_URI = redirectUri;
    }

    /**
     * 生成授权请求地址
     *
     * @param scopes 请求的权限范围
     * @param state  可选，任意内容，授权成功后将在回调地址中附加上state
     * @return 授权请求地址
     */
    public String generateAuthorizeRequestUrl(Set<String> scopes, String state) {
        StringBuilder url = new StringBuilder(UNIFI_AUTH_SERVER_URI);
        if (!UNIFI_AUTH_SERVER_URI.endsWith(URI_SEPARATOR)) {
            url.append(URI_SEPARATOR);
        }
        url.append("oauth2/authorize" + RESPONSE_TYPE + "&client_id=").append(CLIENT_ID).append("&redirect_uri=").append(REDIRECT_URI);
        if (scopes != null && !scopes.isEmpty()) {
            url.append("&scope=");
            for (String scope : scopes
            ) {
                url.append(scope).append(" ");
            }
            url.delete(url.length() - 1, url.length());
        }
        if (state != null && state.length() > 0) {
            url.append("&state=").append(state);
        }
        return url.toString();
    }

    /**
     * 从回调请求中转换为 Java 对象
     *
     * @param request
     * @return
     */
    public CallbackDataObject handlingCallback(javax.servlet.http.HttpServletRequest request) {
        return convertCallbackDataObject(request.getParameterMap());
    }

    /**
     * 将回调请求参数 Map 转换为 Java 对象
     *
     * @param params
     * @return
     */
    public CallbackDataObject convertCallbackDataObject(Map<String, String[]> params) {
        CallbackDataObject callbackDataObject = new CallbackDataObject();
        callbackDataObject.setSuccess(false);
        for (Map.Entry<String, String[]> param : params.entrySet()) {
            switch (param.getKey()) {
                case "code":
                    callbackDataObject.setCode(StringUtils.join(param.getValue()));
                    callbackDataObject.setSuccess(true);
                    break;
                case "state":
                    callbackDataObject.setState(StringUtils.join(param.getValue()));
                    break;
                case "error":
                    callbackDataObject.setError(StringUtils.join(param.getValue()));
                    break;
                case "error_description":
                    callbackDataObject.setErrorDescription(StringUtils.join(param.getValue()));
                    break;
                case "error_uri":
                    callbackDataObject.setErrorUri(StringUtils.join(param.getValue()));
                    break;
                default:
                    break;
            }
        }
        return callbackDataObject;
    }

    /**
     * 使用授权码换取 Token
     *
     * @param code 授权码
     * @return
     * @throws Exception
     */
    public AccessTokenDataObject exchangeToken(String code) throws Exception {
        StringBuilder url = new StringBuilder(UNIFI_AUTH_SERVER_URI);
        if (!UNIFI_AUTH_SERVER_URI.endsWith(URI_SEPARATOR)) {
            url.append(URI_SEPARATOR);
        }
        url.append("oauth2/token");
        URI uri = new URI(url.toString());

        Map<String, String> data = new HashMap<String, String>() {{
            this.put("grant_type", "authorization_code");
            this.put("client_id", CLIENT_ID);
            this.put("redirect_uri", REDIRECT_URI);
            this.put("code", code);
        }};

        HttpClientUtils httpClientUtils = new HttpClientUtils();
        String result = httpClientUtils.postForm(uri, CLIENT_ID, CLIENT_SECRET, data);
        Map<String, Object> stringObjectMap = JSONUtils.json2map(result);
        if (stringObjectMap.get("access_token") != null) {
            return JSONUtils.json2pojo(result, AccessTokenDataObject.class);
        } else if (stringObjectMap.get("error") != null) {
            throw new RuntimeException(stringObjectMap.get("error").toString());
        } else if (stringObjectMap.get("message") != null) {
            throw new RuntimeException(stringObjectMap.get("message").toString());
        } else {
            throw new RuntimeException("RuntimeException: result: " + result);
        }
    }

    public UserService user() {
        return new UserService(this);
    }
}
