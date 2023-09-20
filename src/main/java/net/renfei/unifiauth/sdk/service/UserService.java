package net.renfei.unifiauth.sdk.service;

import com.fasterxml.jackson.core.type.TypeReference;
import net.renfei.unifiauth.sdk.UnifiAuthClient;
import net.renfei.unifiauth.sdk.constant.HttpStatus;
import net.renfei.unifiauth.sdk.entity.*;
import net.renfei.unifiauth.sdk.utils.HttpClientUtils;
import net.renfei.unifiauth.sdk.utils.JSONUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @author renfei
 */
public class UserService {
    private final UnifiAuthClient UNIFI_AUTH_CLIENT;

    public UserService(UnifiAuthClient unifiAuthClient) {
        this.UNIFI_AUTH_CLIENT = unifiAuthClient;
    }

    /**
     * 查询用户基础信息（SCOPE:profile）
     *
     * @param token
     * @return
     * @throws Exception
     */
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

    /**
     * 查询用户的角色列表（SCOPE:roles）
     * <br>
     * 如需使用此功能，需要在统一权限平台上对用户进行角色设置
     * <br>
     * 每个用户在每个子系统中拥有的权限和菜单都不相同
     *
     * @param token
     * @return
     * @throws Exception
     */
    public List<RoleDetail> queryUserRoleList(String token) throws Exception {
        StringBuilder url = new StringBuilder(UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI);
        if (!UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI.endsWith(UnifiAuthClient.URI_SEPARATOR)) {
            url.append(UnifiAuthClient.URI_SEPARATOR);
        }
        url.append("resource/roles");
        URI uri = new URI(url.toString());
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        String result = httpClientUtils.get(uri, token);
        ApiResult<List<RoleDetail>> apiResult = JSONUtils.json2pojo(result, new TypeReference<ApiResult<List<RoleDetail>>>() {
        });
        if (apiResult.getCode() == HttpStatus.SUCCESS) {
            return apiResult.getData();
        } else {
            throw new RuntimeException(apiResult.getMessage());
        }
    }

    /**
     * 查询用户拥有的菜单树（SCOPE:menus）
     * <br>
     * 如需使用此功能，需要在统一权限平台上对用户进行角色设置
     * <br>
     * 每个用户在每个子系统中拥有的权限和菜单都不相同
     *
     * @param token
     * @return
     * @throws Exception
     */
    public List<MenuDetail> queryUserMenuTree(String token) throws Exception {
        StringBuilder url = new StringBuilder(UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI);
        if (!UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI.endsWith(UnifiAuthClient.URI_SEPARATOR)) {
            url.append(UnifiAuthClient.URI_SEPARATOR);
        }
        url.append("resource/menus");
        URI uri = new URI(url.toString());
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        String result = httpClientUtils.get(uri, token);
        ApiResult<List<MenuDetail>> apiResult = JSONUtils.json2pojo(result, new TypeReference<ApiResult<List<MenuDetail>>>() {
        });
        if (apiResult.getCode() == HttpStatus.SUCCESS) {
            return apiResult.getData();
        } else {
            throw new RuntimeException(apiResult.getMessage());
        }
    }

    /**
     * 获取用户拥有的子系统列表
     *
     * @param token
     * @return
     * @throws Exception
     */
    public List<ApplicationDetail> queryUserApplications(String token) throws Exception {
        StringBuilder url = new StringBuilder(UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI);
        if (!UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI.endsWith(UnifiAuthClient.URI_SEPARATOR)) {
            url.append(UnifiAuthClient.URI_SEPARATOR);
        }
        url.append("resource/applications");
        URI uri = new URI(url.toString());
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        String result = httpClientUtils.get(uri, token);
        ApiResult<List<ApplicationDetail>> apiResult = JSONUtils.json2pojo(result, new TypeReference<ApiResult<List<ApplicationDetail>>>() {
        });
        if (apiResult.getCode() == HttpStatus.SUCCESS) {
            return apiResult.getData();
        } else {
            throw new RuntimeException(apiResult.getMessage());
        }
    }

    /**
     * 获取用户资源列表
     *
     * @param username 账号
     * @param name     名称
     * @param phone    手机号
     * @param email    电邮
     * @param pages    页码
     * @param rows     每页行数
     * @return
     */
    public ListData<UserDetail> queryUserList(String token, String username, String name, String phone,
                                              String email, Integer pages, Integer rows) throws Exception {
        StringBuilder url = new StringBuilder(UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI);
        if (!UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI.endsWith(UnifiAuthClient.URI_SEPARATOR)) {
            url.append(UnifiAuthClient.URI_SEPARATOR);
        }
        url.append("resource/user");
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(url.toString());
        if (StringUtils.hasLength(username)) {
            uriComponentsBuilder.queryParam("username", username);
        }
        if (StringUtils.hasLength(name)) {
            uriComponentsBuilder.queryParam("name", name);
        }
        if (StringUtils.hasLength(phone)) {
            uriComponentsBuilder.queryParam("phone", phone);
        }
        if (StringUtils.hasLength(email)) {
            uriComponentsBuilder.queryParam("email", email);
        }
        if (pages != null) {
            uriComponentsBuilder.queryParam("pages", pages);
        }
        if (rows != null) {
            uriComponentsBuilder.queryParam("rows", rows);
        }
        URI uri = uriComponentsBuilder.build().toUri();
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        String result = httpClientUtils.get(uri, token);
        ApiResult<ListData<UserDetail>> apiResult = JSONUtils.json2pojo(result, new TypeReference<ApiResult<ListData<UserDetail>>>() {
        });
        if (apiResult.getCode() == HttpStatus.SUCCESS) {
            return apiResult.getData();
        } else {
            throw new RuntimeException(apiResult.getMessage());
        }
    }
}
