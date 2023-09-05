package net.renfei.unifiauth.example.springbootexample.service;

import net.renfei.unifiauth.sdk.UnifiAuthClient;
import net.renfei.unifiauth.sdk.entity.AccessTokenDataObject;
import net.renfei.unifiauth.sdk.entity.DepartmentDetail;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门服务
 *
 * @author renfei
 */
@Service
public class DepartmentService {
    /**
     * 查询部门树
     *
     * @return
     */
    public List<DepartmentDetail> queryDeptTree() throws Exception {
        // 创建一个统一认证客户端实例
        UnifiAuthClient unifiAuthClient = new UnifiAuthClient(
                // 统一认证中心地址
                "http://localhost:8888",
                // 客户端ID
                "fec01ad39c9e495082ac74a861588d25",
                // 客户端密码
                "password",
                // 客户端回调地址（接收授权码）
                "http://localhost:8861/authenticate"
        );
        // 使用客户端模式申请 Token
        AccessTokenDataObject accessTokenDataObject = unifiAuthClient.exchangeToken();
        // 使用Token查询
        List<DepartmentDetail> departmentDetails = unifiAuthClient.department()
                .queryDeptTree(accessTokenDataObject.getAccessToken());
        return departmentDetails;
    }

    /**
     * 查询指定部门的子级部门树
     *
     * @return
     */
    public List<DepartmentDetail> queryDeptTree(long id) throws Exception {
        // 创建一个统一认证客户端实例
        UnifiAuthClient unifiAuthClient = new UnifiAuthClient(
                // 统一认证中心地址
                "http://localhost:8888",
                // 客户端ID
                "fec01ad39c9e495082ac74a861588d25",
                // 客户端密码
                "password",
                // 客户端回调地址（接收授权码）
                "http://localhost:8861/authenticate"
        );
        // 使用客户端模式申请 Token
        AccessTokenDataObject accessTokenDataObject = unifiAuthClient.exchangeToken();
        // 使用Token查询
        List<DepartmentDetail> departmentDetails = unifiAuthClient.department()
                .queryDeptTree(accessTokenDataObject.getAccessToken(), id);
        return departmentDetails;
    }
}
