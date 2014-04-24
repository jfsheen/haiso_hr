package com.haiso.hr.entity;

import com.haiso.hr.entity.employee.Employee;
import com.haiso.hr.utils.SnGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ff on 4/15/14.
 * 岗位表
 */
@Entity
@Table(name = "t_position")
public class Position {

    private String positionSn;
    private String title;
    private String sequence;
    private byte amountLimit;
    private String postDuty;
    private String remark;
    private Date lastUpdate;
    private Date createDate;
    private int version;

    @Column(name = "last_update", nullable = false, insertable = true, updatable = true, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Version
    @Column(name = "version_lock", length = 10)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "create_date", nullable = false, insertable = true, updatable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    private Department department;
    private Set<Employee> employeeSet = new HashSet<Employee>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_sn", nullable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToMany(mappedBy = "positionSet")
    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    @Id
    @Column(name = "position_sn", nullable = false, insertable = true, updatable = true, length = 20)
    public String getPositionSn() {
        return positionSn;
    }

    public void setPositionSn(String positionSn) {
        this.positionSn = positionSn;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 20)
    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    @Basic
    @Column(name = "sequence", nullable = false, insertable = true, updatable = true, length = 20)
    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    @Basic
    @Column(name = "amount_limit", nullable = false, insertable = true, updatable = true, length = 3)
    public byte getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(byte amountLimit) {
        this.amountLimit = amountLimit;
    }

    @Basic
    @Column(name = "duty", nullable = true, insertable = true, updatable = true, length = 500)
    public String getPostDuty() {
        return postDuty;
    }

    public void setPostDuty(String duty) {
        this.postDuty = duty;
    }

    @Basic
    @Column(name = "remark", nullable = true, insertable = true, updatable = true, length = 500)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }



    @PreUpdate
    public void preUpdate() {
        this.lastUpdate = new Date();
    }

    @PrePersist
    public void prePersist() {
        this.positionSn = SnGenerator.PositionSnGenerator();
        this.createDate = new Date();
        this.lastUpdate = new Date();
    }

    @PreRemove
    public void preRemove() {

    }

    @PostPersist
    public void postPersist() {

    }

    @PostLoad
    public void postLoad() {

    }

    @PostRemove
    public void postRemove() {

    }

    @PostUpdate
    public void postUpdate() {

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

//        Position position = (Position) o;
//
//        if (amountLimit != position.amountLimit) return false;
//        if (id != position.id) return false;
//        if (postDuty != null ? !postDuty.equals(position.postDuty) : position.postDuty != null) return false;
//        if (name != null ? !name.equals(position.name) : position.name != null) return false;
//        if (positionSn != null ? !positionSn.equals(position.positionSn) : position.positionSn != null) return false;
//        if (remark != null ? !remark.equals(position.remark) : position.remark != null) return false;
//        if (sequence != null ? !sequence.equals(position.sequence) : position.sequence != null) return false;
//
        return true;
    }

    @Override
    public int hashCode() {
        int result = (positionSn != null ? positionSn.hashCode() : 0);
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (sequence != null ? sequence.hashCode() : 0);
//        result = 31 * result + (int) amountLimit;
//        result = 31 * result + (postDuty != null ? postDuty.hashCode() : 0);
//        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
