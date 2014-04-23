package com.haiso.hr.entity;

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
    private int id;
    private String deptSn;
    private String name;
    private String duty;
    private String leadDeptSn;
    private String description;
    private java.util.Date lastUpdate;
    private java.util.Date createDate;
    private int version;
    private Set<Employee> employeeSet = new HashSet<Employee>();
    private Set<Position> positionSet = new HashSet<Position>();

    @OneToMany(mappedBy = "department")
    public Set<Position> getPositionSet() {
        return positionSet;
    }

    public void setPositionSet(Set<Position> positionSet) {
        this.positionSet = positionSet;
    }

    @ManyToMany(mappedBy = "dempartmentSet")
    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    @Version
    @Column(name = "version_lock", length = 10)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
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

    @Basic
    @Column(name = "leaddept_sn", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getLeadDeptSn() {
        return leadDeptSn;
    }

    public void setLeadDeptSn(String leadDeptSn) {
        this.leadDeptSn = leadDeptSn;
    }


    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dept_sn", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getDeptSn() {
        return deptSn;
    }

    public void setDeptSn(String orgSn) {
        this.deptSn = orgSn;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 500, precision = 0)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Department that = (Department) o;
//
//        if (id != that.id) return false;
//        if (leadDeptSn != that.leadDeptSn) return false;
//        if (description != null ? !description.equals(that.description) : that.description != null) return false;
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//        if (deptSn != null ? !deptSn.equals(that.deptSn) : that.deptSn != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (deptSn != null ? deptSn.hashCode() : 0);
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (leadDeptSn != null? leadDeptSn.hashCode() : 0);
//        result = 31 * result + (description != null ? description.hashCode() : 0);
//        return result;
//    }
}
