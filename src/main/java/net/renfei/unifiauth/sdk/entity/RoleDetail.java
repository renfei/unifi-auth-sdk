package net.renfei.unifiauth.sdk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色对象
 *
 * @author renfei
 */
@Schema(title = "角色对象")
public class RoleDetail implements Serializable {
    private static final long serialVersionUID = -5194970536302876575L;
    @Schema(description = "角色ID")
    private String id;
    @Schema(description = "角色名称")
    private String roleName;
    @Schema(description = "角色描述")
    private String roleDescribe;
    @Schema(description = "添加时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;
    @Schema(description = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    @Schema(description = "是否是内置角色")
    private Boolean builtInRole;
    @Schema(description = "扩展预留")
    private String extendJson;
    private List<String> authorityList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
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

    public Boolean getBuiltInRole() {
        return builtInRole;
    }

    public void setBuiltInRole(Boolean builtInRole) {
        this.builtInRole = builtInRole;
    }

    public String getExtendJson() {
        return extendJson;
    }

    public void setExtendJson(String extendJson) {
        this.extendJson = extendJson;
    }

    public List<String> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<String> authorityList) {
        this.authorityList = authorityList;
    }

    @Override
    public String toString() {
        return "RoleDetail{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDescribe='" + roleDescribe + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", builtInRole=" + builtInRole +
                ", extendJson='" + extendJson + '\'' +
                ", authorityList=" + authorityList +
                '}';
    }
}
