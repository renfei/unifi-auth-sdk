# SpringBoot2.x集成统一认证平台SDK示例

此项目旨在对统一认证平台SDK集成的演示，为让开发人员快速了解如何使用SDK包。

## 示例

完整的示例请参见本文件夹中的项目。

### 创建SDK客户端实例

```java
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
        "https://localhost:8861/authenticate"
);

/**
 * 授权范围，请向统一认证平台管理员索要
 */
private final Set<String> scopes = new HashSet<String>() {{
    this.add("user.read");
}};
```

### 构建授权认证请求地址

当您发现用户未登录时，需要将用户导向统一认证平台进行授权：

```java
@ResponseBody
@RequestMapping("/")
public String index(HttpServletRequest request, HttpServletResponse response) throws IOException {
    HttpSession session = request.getSession();
    String username = (String) session.getAttribute("username");
    if (username == null) {
        // 未登录，重定向到统一认证平台
        String authorizeRequestUrl = unifiAuthClient.generateAuthorizeRequestUrl(scopes, null);
        response.sendRedirect(authorizeRequestUrl);
        return null;
    } else {
        // 已登录，运行业务代码
        return "你好，" + username + "。";
    }
}
```

### 回调地址获取授权码

拿到用户授权码，可以去统一认证平台换取 Token，访问后续资源接口。

```java
/**
 * 回调地址（接收授权码）
 *
 * @param request 请求对象
 * @return
 * @throws Exception
 */
@ResponseBody
@RequestMapping("/authenticate")
public String authenticate(HttpServletRequest request) throws Exception {
    CallbackDataObject callbackDataObject = unifiAuthClient.handlingCallback(request);
    if (callbackDataObject.getSuccess()) {
        // 用户授权码
        String code = callbackDataObject.getCode();
        // 使用授权码交换 Token
        AccessTokenDataObject accessTokenDataObject = unifiAuthClient.exchangeToken(code);
        // 使用 Token 获取用户信息
        // 设置 session
        HttpSession session = request.getSession();
        // session.setAttribute("username", "");
        return accessTokenDataObject.getAccessToken();
    } else {
        return callbackDataObject.getErrorDescription();
    }
}
```
