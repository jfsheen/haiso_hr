package com.haiso.hr.entity.employee;

import com.google.common.base.Objects;
import com.haiso.commons.utils.SnGenerator;
import com.haiso.hr.entity.Department;
import com.haiso.hr.entity.Position;
import com.haiso.hr.entity.param.EmplLevel;
import com.haiso.hr.entity.param.EmplSequence;
import com.haiso.hr.entity.param.EmplStatus;
import com.haiso.hr.entity.person.Person;

import javax.persistence.*;
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

    @Version
    @Column(name = "version_lock", length = 10)
    private Integer version;

    @Id
    @Column(name = "empl_sn", nullable = false, insertable = true, updatable = true, length = 20)
    private String emplSn;

    @Column(name = "introduction", nullable = true, insertable = true, updatable = true, length = 500)
    private String introduction;

    @Column(name = "last_update", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date lastUpdate;

    @Column(name = "create_date", nullable = false, insertable = true, updatable = false, length = 1, precision = 0)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "empl_dept")
    private Set<Department> departmentSet = new HashSet<Department>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "empl_post")
    private Set<Position> positionSet = new HashSet<Position>();

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    @NotNull
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status", nullable = true)
    private EmplStatus emplStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sequence", nullable = true)
    private EmplSequence emplSequence;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "level", nullable = true)
    private EmplLevel emplLevel;


    public EmplSequence getEmplSequence() {
        return emplSequence;
    }

    public void setEmplSequence(EmplSequence emplSequence) {
        this.emplSequence = emplSequence;
    }

    public EmplLevel getEmplLevel() {
        return emplLevel;
    }

    public void setEmplLevel(EmplLevel emplLevel) {
        this.emplLevel = emplLevel;
    }

    public EmplStatus getEmplStatus() {
        return emplStatus;
    }

    public void setEmplStatus(EmplStatus emplStatus) {
        this.emplStatus = emplStatus;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Department> getDepartmentSet() {
        return departmentSet;
    }

    public void setDepartmentSet(Set<Department> departmentSet) {
        this.departmentSet = departmentSet;
    }

    public Set<Position> getPositionSet() {
        return positionSet;
    }

    public void setPositionSet(Set<Position> positionSet) {
        this.positionSet = positionSet;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

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

    public String getEmplSn() {
        return emplSn;
    }

    public void setEmplSn(String emplSn) {
        this.emplSn = emplSn;
    }

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
