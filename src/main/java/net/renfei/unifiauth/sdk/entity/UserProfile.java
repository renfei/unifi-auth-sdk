package net.renfei.unifiauth.sdk.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import net.renfei.unifiauth.sdk.constant.SecretLevelEnum;

import java.io.Serializable;
import java.util.List;

/**
 * 用户基础信息
 *
 * @author renfei
 */
@Schema(title = "用户基础信息")
public class UserProfile implements Serializable {
    private static final long serialVersionUID = -3316408227872898096L;
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "姓名")
    private String name;
    @Schema(description = "手机号")
    private String mobile;
    @Schema(description = "办公室地址")
    private String officeAddress;
    @Schema(description = "办公室电话")
    private String officePhone;
    @Schema(description = "性别")
    private String gender;
    @Schema(description = "保密等级")
    private SecretLevelEnum secretLevel;
    @Schema(description = "用户所属部门列表")
    private List<DepartmentDetail> departments;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public SecretLevelEnum getSecretLevel() {
        return secretLevel;
    }

    public void setSecretLevel(SecretLevelEnum secretLevel) {
        this.secretLevel = secretLevel;
    }

    public List<DepartmentDetail> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentDetail> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", officeAddress='" + officeAddress + '\'' +
                ", officePhone='" + officePhone + '\'' +
                ", gender='" + gender + '\'' +
                ", secretLevel=" + secretLevel +
                ", departments=" + departments +
                '}';
    }
}
