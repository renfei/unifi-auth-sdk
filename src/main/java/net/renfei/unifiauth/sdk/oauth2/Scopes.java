package net.renfei.unifiauth.sdk.oauth2;

/**
 * 权限范围
 *
 * @author renfei
 */
public final class Scopes {
    /**
     * 获取用户的基本信息
     */
    public static final String PROFILE = "profile";
    /**
     * 获取用户的角色列表
     */
    public static final String ROLES = "roles";
    /**
     * 获取用户拥有的菜单树
     */
    public static final String MENUS = "menus";
    /**
     * 查询用户资料
     */
    public static final String USER_READ = "user.read";
    /**
     * 创建用户
     */
    public static final String USER_CREATE = "user.create";
    /**
     * 修改用户
     */
    public static final String USER_UPDATE = "user.update";
    /**
     * 删除用户
     */
    public static final String USER_DELETE = "user.delete";
    /**
     * 查询角色列表
     */
    public static final String ROLE_READ = "role.read";
    /**
     * 创建角色
     */
    public static final String ROLE_CREATE = "role.create";
    /**
     * 修改角色
     */
    public static final String ROLE_UPDATE = "role.update";
    /**
     * 删除角色
     */
    public static final String ROLE_DELETE = "role.delete";
    /**
     * 查询菜单列表
     */
    public static final String MENU_READ = "menu.read";
    /**
     * 创建菜单
     */
    public static final String MENU_CREATE = "menu.create";
    /**
     * 修改菜单
     */
    public static final String MENU_UPDATE = "menu.update";
    /**
     * 删除菜单
     */
    public static final String MENU_DELETE = "menu.delete";
    /**
     * 部门读取
     */
    public static final String DEPT_READ = "dept.read";
    /**
     * 部门创建
     */
    public static final String DEPT_CREATE = "dept.create";
    /**
     * 部门编辑
     */
    public static final String DEPT_UPDATE = "dept.update";
    /**
     * 部门删除
     */
    public static final String DEPT_DELETE = "dept.delete";
}
