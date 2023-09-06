package net.renfei.unifiauth.sdk.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

/**
 * 应用详情
 *
 * @author renfei
 */
@Schema(title = "应用详情")
public class ApplicationDetail implements Serializable {
    private static final long serialVersionUID = -3316408227872898096L;
    @Schema(description = "应用名称")
    private String name;
    @Schema(description = "应用URL地址")
    private String home;
    @Schema(description = "应用图标")
    private String icon;
    @Schema(description = "应用描述")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ApplicationDetail{" +
                "name='" + name + '\'' +
                ", home='" + home + '\'' +
                ", icon='" + icon + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
