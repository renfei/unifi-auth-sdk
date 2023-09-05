package net.renfei.unifiauth.sdk;

import net.renfei.unifiauth.sdk.entity.AccessTokenDataObject;
import net.renfei.unifiauth.sdk.entity.DepartmentDetail;
import net.renfei.unifiauth.sdk.entity.UserProfile;
import net.renfei.unifiauth.sdk.oauth2.Scopes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author renfei
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UnifiAuthClientTest {
    private UnifiAuthClient unifiAuthClient;

    @BeforeAll
    public void init() {
        // 在统一认证中心注册的客户端信息
        unifiAuthClient = new UnifiAuthClient(
                // 统一认证中心地址
                "http://localhost:8888",
                // 客户端ID
                "fec01ad39c9e495082ac74a861588d25",
                // 客户端密码
                "password",
                // 客户端回调地址（接收授权码）
                "http://localhost:8861/authenticate"
        );
    }

    /**
     * 生成授权URL，引导用户至统一认证中心
     */
    @Test
    public void generateAuthorizeRequestUrl() {
        Set<String> scopes = new HashSet<>();
        scopes.add(Scopes.PROFILE);
        scopes.add(Scopes.USER_READ);
        String s = unifiAuthClient.generateAuthorizeRequestUrl(scopes, "123");
        System.out.println(s);
    }

    /**
     * 使用授权码换取 Token
     */
    //@Test
    public void exchangeToken() {
        String code = "SVweWGyxDgbuocnCnI8EmDrUUuiroauovGGkRbgFqlYQb1c8lLmB9jiG9l52C_DdLOWfHjGa036Tq48mSGcP-vfFzMzbfVwxuldRPskQCeLLR0z8ycpC3umYI3JwDBfN";
        AccessTokenDataObject accessTokenDataObject;
        try {
            accessTokenDataObject = unifiAuthClient.exchangeToken(code);
            System.out.println(accessTokenDataObject);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * 使用客户端模式获取 Token
     */
    @Test
    public void exchangeClientToken() {
        AccessTokenDataObject accessTokenDataObject;
        try {
            accessTokenDataObject = unifiAuthClient.exchangeToken();
            System.out.println(accessTokenDataObject);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    //@Test
    public void queryUserInfo() {
        String code = "hhcLHsm5p7bMMH401KhV8FoFfabhDKmdGqWr0jI8gCE2gP22Y2lRokNRBpPgdSM2kf5uWnB9p4BiuxA-0nmRUb7FRCMda1ux5lFM56xserPQKdyhRA6x1dSWZv42XlWW";
        AccessTokenDataObject accessTokenDataObject;
        try {
            accessTokenDataObject = unifiAuthClient.exchangeToken(code);
            UserProfile userProfile = unifiAuthClient.user().queryUserProfile(accessTokenDataObject.getAccessToken());
            System.out.println(userProfile);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void queryDeptTree() {
        AccessTokenDataObject accessTokenDataObject;
        try {
            accessTokenDataObject = unifiAuthClient.exchangeToken();
            List<DepartmentDetail> departmentDetails = unifiAuthClient.department().queryDeptTree(accessTokenDataObject.getAccessToken());
            System.out.println(departmentDetails);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
