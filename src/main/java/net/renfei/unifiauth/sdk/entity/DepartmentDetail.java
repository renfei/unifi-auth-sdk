package net.renfei.unifiauth.sdk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 部门组织对象
 *
 * @author renfei
 */
@Schema(title = "部门组织对象")
public class DepartmentDetail implements Serializable {
    private static final long serialVersionUID = -5194970536302876575L;
    @Schema(description = "ID")
    private Long id;
    @Schema(description = "父级ID")
    private Long pid;
    @Schema(description = "部门名称")
    private String deptName;
    @Schema(description = "排序")
    private Integer deptOrder;
    @Schema(description = "负责人")
    private String leader;
    @Schema(description = "联系电话")
    private String phone;
    @Schema(description = "部门状态（1正常 0停用）")
    private Integer status;
    @Schema(description = "添加时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;
    @Schema(description = "修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    @Schema(description = "子级部门")
    private List<DepartmentDetail> childDepartment;

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getDeptOrder() {
        return deptOrder;
    }

    public void setDeptOrder(Integer deptOrder) {
        this.deptOrder = deptOrder;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public List<DepartmentDetail> getChildDepartment() {
        return childDepartment;
    }

    public void setChildDepartment(List<DepartmentDetail> childDepartment) {
        this.childDepartment = childDepartment;
    }

    @Override
    public String toString() {
        return "DepartmentDetail{" +
                "id=" + id +
                ", pid=" + pid +
                ", deptName='" + deptName + '\'' +
                ", deptOrder=" + deptOrder +
                ", leader='" + leader + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", childDepartment=" + childDepartment +
                '}';
    }
}
