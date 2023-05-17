package net.renfei.unifiauth.sdk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import net.renfei.unifiauth.sdk.constant.SecretLevelEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户详情对象
 *
 * @author renfei
 */
@Schema(title = "用户详情")
public class UserDetail implements Serializable {
    private static final long serialVersionUID = -5194970536302876575L;
    @Schema(description = "用户ID")
    private String id;
    @Schema(description = "用户名")
    private String username;
    @Schema(description = "电子邮箱")
    private String email;
    @Schema(description = "手机号")
    private String phone;
    @Schema(description = "注册时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registrationDate;
    @Schema(description = "密码")
    private String password;
    @Schema(description = "一次性密码")
    private String totp;
    @Schema(description = "注册IP地址")
    private String registrationIp;
    @Schema(description = "密码错误次数")
    private Integer trialErrorTimes;
    @Schema(description = "锁定时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lockTime;
    @Schema(description = "是否是内置用户")
    private Boolean builtInUser;
    @Schema(description = "密码过期时间")
    private Date passwordExpirationTime;
    @Schema(description = "是否被锁定")
    private Boolean locked;
    @Schema(description = "是否启用")
    private Boolean enabled;
    @Schema(description = "昵称")
    private String nickname;
    @Schema(description = "密码加密时使用的秘钥UUID")
    private String keyUuid;
    @Schema(description = "性别")
    private String gender;
    @Schema(description = "办公地址")
    private String officeAddress;
    @Schema(description = "办公电话")
    private String officePhone;
    @Schema(description = "用户状态")
    private Integer userStatus;
    @Schema(description = "密码修改时间")
    private Date passwordUpdateTime;
    @Schema(description = "保密等级")
    private SecretLevelEnum secretLevel;
    @Schema(description = "描述")
    private String description;
    @Schema(description = "生日")
    private Date birthDay;
    @Schema(description = "职务")
    private String duty;
    @Schema(description = "学历")
    private String education;
    @Schema(description = "家庭住址")
    private String homeAddress;
    @Schema(description = "家庭电话")
    private String homePhone;
    @Schema(description = "政治面貌")
    private String politicalStatus;
    @Schema(description = "专业")
    private String professional;
    @Schema(description = "参加工作时间")
    private Date workDate;
    @Schema(description = "拥有的角色列表")
    private List<RoleDetail> roleDetailList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTotp() {
        return totp;
    }

    public void setTotp(String totp) {
        this.totp = totp;
    }

    public String getRegistrationIp() {
        return registrationIp;
    }

    public void setRegistrationIp(String registrationIp) {
        this.registrationIp = registrationIp;
    }

    public Integer getTrialErrorTimes() {
        return trialErrorTimes;
    }

    public void setTrialErrorTimes(Integer trialErrorTimes) {
        this.trialErrorTimes = trialErrorTimes;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public Boolean getBuiltInUser() {
        return builtInUser;
    }

    public void setBuiltInUser(Boolean builtInUser) {
        this.builtInUser = builtInUser;
    }

    public Date getPasswordExpirationTime() {
        return passwordExpirationTime;
    }

    public void setPasswordExpirationTime(Date passwordExpirationTime) {
        this.passwordExpirationTime = passwordExpirationTime;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getKeyUuid() {
        return keyUuid;
    }

    public void setKeyUuid(String keyUuid) {
        this.keyUuid = keyUuid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Date getPasswordUpdateTime() {
        return passwordUpdateTime;
    }

    public void setPasswordUpdateTime(Date passwordUpdateTime) {
        this.passwordUpdateTime = passwordUpdateTime;
    }

    public SecretLevelEnum getSecretLevel() {
        return secretLevel;
    }

    public void setSecretLevel(SecretLevelEnum secretLevel) {
        this.secretLevel = secretLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public List<RoleDetail> getRoleDetailList() {
        return roleDetailList;
    }

    public void setRoleDetailList(List<RoleDetail> roleDetailList) {
        this.roleDetailList = roleDetailList;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", registrationDate=" + registrationDate +
                ", password='" + password + '\'' +
                ", totp='" + totp + '\'' +
                ", registrationIp='" + registrationIp + '\'' +
                ", trialErrorTimes=" + trialErrorTimes +
                ", lockTime=" + lockTime +
                ", builtInUser=" + builtInUser +
                ", passwordExpirationTime=" + passwordExpirationTime +
                ", locked=" + locked +
                ", enabled=" + enabled +
                ", nickname='" + nickname + '\'' +
                ", keyUuid='" + keyUuid + '\'' +
                ", gender='" + gender + '\'' +
                ", officeAddress='" + officeAddress + '\'' +
                ", officePhone='" + officePhone + '\'' +
                ", userStatus=" + userStatus +
                ", passwordUpdateTime=" + passwordUpdateTime +
                ", secretLevel=" + secretLevel +
                ", description='" + description + '\'' +
                ", birthDay=" + birthDay +
                ", duty='" + duty + '\'' +
                ", education='" + education + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", professional='" + professional + '\'' +
                ", workDate=" + workDate +
                ", roleDetailList=" + roleDetailList +
                '}';
    }
}
