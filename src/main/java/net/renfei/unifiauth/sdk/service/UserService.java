package net.renfei.unifiauth.sdk.service;

import com.fasterxml.jackson.core.type.TypeReference;
import net.renfei.unifiauth.sdk.UnifiAuthClient;
import net.renfei.unifiauth.sdk.constant.HttpStatus;
import net.renfei.unifiauth.sdk.entity.ApiResult;
import net.renfei.unifiauth.sdk.entity.UserProfile;
import net.renfei.unifiauth.sdk.utils.HttpClientUtils;
import net.renfei.unifiauth.sdk.utils.JSONUtils;

import java.net.URI;

/**
 * @author renfei
 */
public class UserService {
    private final UnifiAuthClient UNIFI_AUTH_CLIENT;

    public UserService(UnifiAuthClient unifiAuthClient) {
        this.UNIFI_AUTH_CLIENT = unifiAuthClient;
    }

    public UserProfile queryUserProfile(String token) throws Exception {
        StringBuilder url = new StringBuilder(UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI);
        if (!UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI.endsWith(UnifiAuthClient.URI_SEPARATOR)) {
            url.append(UnifiAuthClient.URI_SEPARATOR);
        }
        url.append("resource/profile");
        URI uri = new URI(url.toString());
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        String result = httpClientUtils.get(uri, token);
        ApiResult<UserProfile> apiResult = JSONUtils.json2pojo(result, new TypeReference<ApiResult<UserProfile>>() {
        });
        if (apiResult.getCode() == HttpStatus.SUCCESS) {
            return apiResult.getData();
        } else {
            throw new RuntimeException(apiResult.getMessage());
        }
    }
}
