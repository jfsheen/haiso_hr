package com.haiso.hr.entity.employee;

import com.google.common.base.Objects;
import com.haiso.hr.entity.Department;
import com.haiso.hr.entity.Position;
import com.haiso.hr.entity.param.EmplLevel;
import com.haiso.hr.entity.param.EmplSequence;
import com.haiso.hr.entity.param.EmplStatus;
import com.haiso.hr.entity.person.Person;
import com.haiso.hr.utils.SnGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ff on 4/15/14.
 * 员工信息
 */
@Entity
@Table(name = "t_employee")
public class Employee {

    private String emplSn;
    private String introduction;
    private java.util.Date lastUpdate;
    private java.util.Date createDate;
    private Integer version;
    private Set<Department> departmentSet = new HashSet<Department>();
    private Set<Position> positionSet = new HashSet<Position>();
    private Person person;
    private EmplStatus emplStatus;
    private EmplSequence emplSequence;
    private EmplLevel emplLevel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sequence", nullable = true)
    public EmplSequence getEmplSequence() {
        return emplSequence;
    }

    public void setEmplSequence(EmplSequence emplSequence) {
        this.emplSequence = emplSequence;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "level", nullable = true)
    public EmplLevel getEmplLevel() {
        return emplLevel;
    }

    public void setEmplLevel(EmplLevel emplLevel) {
        this.emplLevel = emplLevel;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status", nullable = true)
    public EmplStatus getEmplStatus() {
        return emplStatus;
    }

    public void setEmplStatus(EmplStatus emplStatus) {
        this.emplStatus = emplStatus;
    }

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    @NotNull
    @Valid
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "empl_dept")
    public Set<Department> getDepartmentSet() {
        return departmentSet;
    }

    public void setDepartmentSet(Set<Department> departmentSet) {
        this.departmentSet = departmentSet;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "empl_post")
    public Set<Position> getPositionSet() {
        return positionSet;
    }

    public void setPositionSet(Set<Position> positionSet) {
        this.positionSet = positionSet;
    }

    @Version
    @Column(name = "version_lock", length = 10)
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Column(name = "create_date", nullable = false, insertable = true, updatable = false, length = 1, precision = 0)
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "last_update", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.util.Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdate = new java.util.Date();
    }

    @PrePersist
    public void prePersist() {
        this.emplSn = SnGenerator.EmployeeSnGenerator();
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

    @Id
    @Column(name = "empl_sn", nullable = false, insertable = true, updatable = true, length = 20)
    public String getEmplSn() {
        return emplSn;
    }

    public void setEmplSn(String emplSn) {
        this.emplSn = emplSn;
    }

    @Column(name = "introduction", nullable = true, insertable = true, updatable = true, length = 500)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(emplSn, introduction, lastUpdate, createDate, version, departmentSet, positionSet, person, emplStatus, emplSequence, emplLevel);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        return Objects.equal(this.emplSn, other.emplSn) && Objects.equal(this.introduction, other.introduction) && Objects.equal(this.lastUpdate, other.lastUpdate) && Objects.equal(this.createDate, other.createDate) && Objects.equal(this.version, other.version) && Objects.equal(this.departmentSet, other.departmentSet) && Objects.equal(this.positionSet, other.positionSet) && Objects.equal(this.person, other.person) && Objects.equal(this.emplStatus, other.emplStatus) && Objects.equal(this.emplSequence, other.emplSequence) && Objects.equal(this.emplLevel, other.emplLevel);
    }
}
