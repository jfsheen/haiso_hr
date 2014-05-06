package com.haiso.hr.entity;

import com.google.common.base.Objects;
import com.haiso.hr.entity.employee.Employee;
import com.haiso.hr.utils.SnGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ff on 4/15/14.
 * 部门表
 */
@Entity
@Table(name = "t_department")
public class Department {

    //    private int id;
    private String deptSn;
    private String name;
    private String duty;
    private String leadDeptSn;
    private String description;
    private java.util.Date lastUpdate;
    private java.util.Date createDate;
    private Integer version;
    private Set<Employee> employeeSet = new HashSet<Employee>();
    private Set<Position> positionSet = new HashSet<Position>();

    @OneToMany(mappedBy = "department")
    public Set<Position> getPositionSet() {
        return positionSet;
    }

    public void setPositionSet(Set<Position> positionSet) {
        this.positionSet = positionSet;
    }

    @ManyToMany(mappedBy = "departmentSet")
    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    @Version
    @Column(name = "version_lock", length = 10)
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "create_date", nullable = false, insertable = true, updatable = false, length = 1, precision = 0)
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "last_update", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdate = new java.util.Date();
    }

    @PrePersist
    public void prePersist() {
        this.deptSn = SnGenerator.DepartmentSnGenerator();
        this.createDate = new java.util.Date();
        this.lastUpdate = new java.util.Date();
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

    @Basic
    @Column(name = "duty", nullable = true, insertable = true, updatable = true, length = 500, precision = 0)
    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    @Column(name = "leaddept_sn", nullable = false, insertable = true, updatable = true, length = 20)
    public String getLeadDeptSn() {
        return leadDeptSn;
    }

    public void setLeadDeptSn(String leadDeptSn) {
        this.leadDeptSn = leadDeptSn;
    }


//    @Id
//    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
//   public int getId() {
//        return id;
//   }
//    public void setId(int id) {
//        this.id = id;
//    }

    @Id
    @Column(name = "dept_sn", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getDeptSn() {
        return deptSn;
    }

    public void setDeptSn(String orgSn) {
        this.deptSn = orgSn;
    }


    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 500, precision = 0)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(deptSn, name, duty, leadDeptSn, description, lastUpdate, createDate, version, employeeSet, positionSet);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Department other = (Department) obj;
        return Objects.equal(this.deptSn, other.deptSn) && Objects.equal(this.name, other.name) && Objects.equal(this.duty, other.duty) && Objects.equal(this.leadDeptSn, other.leadDeptSn) && Objects.equal(this.description, other.description) && Objects.equal(this.lastUpdate, other.lastUpdate) && Objects.equal(this.createDate, other.createDate) && Objects.equal(this.version, other.version) && Objects.equal(this.employeeSet, other.employeeSet) && Objects.equal(this.positionSet, other.positionSet);
    }
}
