package net.renfei.unifiauth.sdk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单对象
 *
 * @author renfei
 */
@Schema(title = "菜单对象")
public class MenuDetail implements Serializable {
    private static final long serialVersionUID = -5194970536302876575L;
    @Schema(description = "ID")
    private Long id;
    @Schema(description = "父级ID")
    private Long pid;
    @Schema(description = "类型：菜单、按钮、接口")
    private MenuTypeEnum menuType;
    @Schema(description = "菜单名称")
    private String menuName;
    @Schema(description = "菜单图标")
    private String menuIcon;
    @Schema(description = "菜单链接")
    private String menuLink;
    @Schema(description = "打开方式")
    private String menuTarget;
    @Schema(description = "样式类")
    private String menuClass;
    @Schema(description = "鼠标悬停标题")
    private String menuTitle;
    @Schema(description = "点击事件")
    private String menuOnclick;
    @Schema(description = "菜单排序")
    private String menuOrder;
    @Schema(description = "添加时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;
    @Schema(description = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    @Schema(description = "CSS样式")
    private String menuCss;
    @Schema(description = "扩展预留")
    private String extendJson;
    @Schema(description = "权限表达式，可用于控制界面上的按钮或功能等")
    private String permissionExpr;
    @Schema(description = "子菜单")
    private List<MenuDetail> childMenu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public MenuTypeEnum getMenuType() {
        return menuType;
    }

    public void setMenuType(MenuTypeEnum menuType) {
        this.menuType = menuType;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuLink() {
        return menuLink;
    }

    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink;
    }

    public String getMenuTarget() {
        return menuTarget;
    }

    public void setMenuTarget(String menuTarget) {
        this.menuTarget = menuTarget;
    }

    public String getMenuClass() {
        return menuClass;
    }

    public void setMenuClass(String menuClass) {
        this.menuClass = menuClass;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuOnclick() {
        return menuOnclick;
    }

    public void setMenuOnclick(String menuOnclick) {
        this.menuOnclick = menuOnclick;
    }

    public String getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMenuCss() {
        return menuCss;
    }

    public void setMenuCss(String menuCss) {
        this.menuCss = menuCss;
    }

    public String getExtendJson() {
        return extendJson;
    }

    public void setExtendJson(String extendJson) {
        this.extendJson = extendJson;
    }

    public String getPermissionExpr() {
        return permissionExpr;
    }

    public void setPermissionExpr(String permissionExpr) {
        this.permissionExpr = permissionExpr;
    }

    public List<MenuDetail> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<MenuDetail> childMenu) {
        this.childMenu = childMenu;
    }

    @Override
    public String toString() {
        return "MenuDetail{" +
                "id=" + id +
                ", pid=" + pid +
                ", menuType=" + menuType +
                ", menuName='" + menuName + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuLink='" + menuLink + '\'' +
                ", menuTarget='" + menuTarget + '\'' +
                ", menuClass='" + menuClass + '\'' +
                ", menuTitle='" + menuTitle + '\'' +
                ", menuOnclick='" + menuOnclick + '\'' +
                ", menuOrder='" + menuOrder + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", menuCss='" + menuCss + '\'' +
                ", extendJson='" + extendJson + '\'' +
                ", permissionExpr='" + permissionExpr + '\'' +
                ", childMenu=" + childMenu +
                '}';
    }
}
