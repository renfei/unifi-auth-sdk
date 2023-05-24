package net.renfei.unifiauth.sdk.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

/**
 * 子系统对象
 *
 * @author renfei
 */
@Schema(title = "子系统对象")
public class SubSysDetail {
    @Schema(description = "客户端ID")
    private String clientId;
    @Schema(description = "客户端名称")
    private String clientName;
    @Schema(description = "菜单列表")
    List<MenuDetail> menuList;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<MenuDetail> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuDetail> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "SubSysDetail{" +
                "clientId='" + clientId + '\'' +
                ", clientName='" + clientName + '\'' +
                ", menuList=" + menuList +
                '}';
    }
}
