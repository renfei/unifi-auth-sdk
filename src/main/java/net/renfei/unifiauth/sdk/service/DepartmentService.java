package net.renfei.unifiauth.sdk.service;

import com.fasterxml.jackson.core.type.TypeReference;
import net.renfei.unifiauth.sdk.UnifiAuthClient;
import net.renfei.unifiauth.sdk.constant.HttpStatus;
import net.renfei.unifiauth.sdk.entity.ApiResult;
import net.renfei.unifiauth.sdk.entity.DepartmentDetail;
import net.renfei.unifiauth.sdk.utils.HttpClientUtils;
import net.renfei.unifiauth.sdk.utils.JSONUtils;

import java.net.URI;
import java.util.List;

/**
 * 部门服务
 *
 * @author renfei
 */
public class DepartmentService {
    private final UnifiAuthClient UNIFI_AUTH_CLIENT;

    public DepartmentService(UnifiAuthClient unifiAuthClient) {
        UNIFI_AUTH_CLIENT = unifiAuthClient;
    }

    /**
     * 获取部门树
     *
     * @param token
     * @return
     * @throws Exception
     */
    public List<DepartmentDetail> queryDeptTree(String token) throws Exception {
        StringBuilder url = new StringBuilder(UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI);
        if (!UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI.endsWith(UnifiAuthClient.URI_SEPARATOR)) {
            url.append(UnifiAuthClient.URI_SEPARATOR);
        }
        url.append("resource/dept");
        URI uri = new URI(url.toString());
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        String result = httpClientUtils.get(uri, token);
        ApiResult<List<DepartmentDetail>> apiResult = JSONUtils.json2pojo(result, new TypeReference<ApiResult<List<DepartmentDetail>>>() {
        });
        if (apiResult.getCode() == HttpStatus.SUCCESS) {
            return apiResult.getData();
        } else {
            throw new RuntimeException(apiResult.getMessage());
        }
    }

    /**
     * 查询指定部门的子级部门树
     *
     * @param token
     * @param id
     * @return
     * @throws Exception
     */
    public List<DepartmentDetail> queryDeptTree(String token, long id) throws Exception {
        StringBuilder url = new StringBuilder(UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI);
        if (!UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI.endsWith(UnifiAuthClient.URI_SEPARATOR)) {
            url.append(UnifiAuthClient.URI_SEPARATOR);
        }
        url.append("resource/dept/").append(id).append("child");
        URI uri = new URI(url.toString());
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        String result = httpClientUtils.get(uri, token);
        ApiResult<List<DepartmentDetail>> apiResult = JSONUtils.json2pojo(result, new TypeReference<ApiResult<List<DepartmentDetail>>>() {
        });
        if (apiResult.getCode() == HttpStatus.SUCCESS) {
            return apiResult.getData();
        } else {
            throw new RuntimeException(apiResult.getMessage());
        }
    }

    /**
     * 根据ID查询部门详情
     *
     * @param token
     * @param id
     * @return
     * @throws Exception
     */
    public DepartmentDetail queryDept(String token, long id) throws Exception {
        StringBuilder url = new StringBuilder(UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI);
        if (!UNIFI_AUTH_CLIENT.UNIFI_AUTH_SERVER_URI.endsWith(UnifiAuthClient.URI_SEPARATOR)) {
            url.append(UnifiAuthClient.URI_SEPARATOR);
        }
        url.append("resource/dept/").append(id);
        URI uri = new URI(url.toString());
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        String result = httpClientUtils.get(uri, token);
        ApiResult<DepartmentDetail> apiResult = JSONUtils.json2pojo(result, new TypeReference<ApiResult<DepartmentDetail>>() {
        });
        if (apiResult.getCode() == HttpStatus.SUCCESS) {
            return apiResult.getData();
        } else {
            throw new RuntimeException(apiResult.getMessage());
        }
    }
}
