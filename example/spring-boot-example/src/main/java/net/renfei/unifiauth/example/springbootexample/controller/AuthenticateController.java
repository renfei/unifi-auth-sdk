package net.renfei.unifiauth.example.springbootexample.controller;

import net.renfei.unifiauth.sdk.UnifiAuthClient;
import net.renfei.unifiauth.sdk.constant.HttpStatus;
import net.renfei.unifiauth.sdk.entity.AccessTokenDataObject;
import net.renfei.unifiauth.sdk.entity.ApiResult;
import net.renfei.unifiauth.sdk.entity.CallbackDataObject;
import net.renfei.unifiauth.sdk.entity.UserProfile;
import net.renfei.unifiauth.sdk.oauth2.Scopes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 认证演示
 *
 * @author renfei
 */
@Controller
public class AuthenticateController {
    /**
     * 客户端信息，这些参数请向统一认证平台管理员索要
     */
    private final UnifiAuthClient unifiAuthClient = new UnifiAuthClient(
            // 统一认证中心地址
            "http://localhost:8888",
            // 客户端ID
            "fec01ad39c9e495082ac74a861588d25",
            // 客户端密码
            "password",
            // 客户端回调地址（接收授权码）
            "http://localhost:8861/authenticate"
    );

    /**
     * 授权范围，请向统一认证平台管理员索要
     */
    private final Set<String> scopes = new HashSet<String>() {{
        this.add(Scopes.PROFILE);
    }};

    /**
     * 访问首页
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        if (name == null) {
            // 未登录，重定向到统一认证平台
            String authorizeRequestUrl = unifiAuthClient.generateAuthorizeRequestUrl(scopes, "example");
            response.sendRedirect(authorizeRequestUrl);
            return null;
        } else {
            // 已登录，运行业务代码
            return "你好，" + name + "。";
        }
    }

    /**
     * 回调地址（接收授权码）
     *
     * @param request 请求对象
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/authenticate")
    public String authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CallbackDataObject callbackDataObject = unifiAuthClient.handlingCallback(request);
        if (callbackDataObject.getSuccess()) {
            // 用户授权码
            String code = callbackDataObject.getCode();
            // 使用授权码交换 Token
            AccessTokenDataObject accessTokenDataObject = unifiAuthClient.exchangeToken(code);
            // 使用 Token 获取用户信息
            UserProfile userProfile = unifiAuthClient.user().queryUserProfile(accessTokenDataObject.getAccessToken());
            // 设置 session
            HttpSession session = request.getSession();
            session.setAttribute("username", userProfile.getUsername());
            session.setAttribute("name", userProfile.getName());
            // 重定向到首页
            response.sendRedirect("/");
            return userProfile.getName();
        } else {
            return callbackDataObject.getErrorDescription();
        }
    }
}
