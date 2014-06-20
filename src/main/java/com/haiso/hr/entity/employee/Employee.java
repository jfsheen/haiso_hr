package com.haiso.hr.entity.employee;

import com.google.common.base.Objects;
import com.haiso.hr.entity.organization.Department;
import com.haiso.hr.entity.organization.Position;
import com.haiso.hr.entity.base.AuditBaseEntity;
import com.haiso.hr.entity.person.Person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ff on 4/15/14.
 * 员工信息
 */
@Entity
@Table(name = "t_employee")
public class Employee extends AuditBaseEntity{

    @Basic
    @Column(name = "empl_sn")
    @NotNull
    @Size(min = 10, max = 15, message = "empl_sn msg")
    private String emplSn;
    @Basic
    @Column(name = "introduction")
    private String introduction;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "empl_dept")
    private Set<Department> departmentSet = new HashSet<Department>();
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "empl_post")
    private Set<Position> positionSet = new HashSet<Position>();
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "person_id")
    @NotNull
    private Person person;
    @Basic
    @Column(name = "status")
    private Byte emplStatus;
    @Basic
    @Column(name = "sequence")
    private Byte emplSequence;
    @Basic
    @Column(name = "level")
    private Byte emplLevel;


   //todo override @PrePersist method

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(emplSn, introduction, departmentSet, positionSet, person, emplStatus, emplSequence, emplLevel);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        final Employee other = (Employee) obj;
        return Objects.equal(this.emplSn, other.emplSn) && Objects.equal(this.introduction, other.introduction) && Objects.equal(this.departmentSet, other.departmentSet) && Objects.equal(this.positionSet, other.positionSet) && Objects.equal(this.person, other.person) && Objects.equal(this.emplStatus, other.emplStatus) && Objects.equal(this.emplSequence, other.emplSequence) && Objects.equal(this.emplLevel, other.emplLevel);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("emplSn", emplSn)
                .add("introduction", introduction)
                .add("departmentSet", departmentSet)
                .add("positionSet", positionSet)
                .add("person", person)
                .add("emplStatus", emplStatus)
                .add("emplSequence", emplSequence)
                .add("emplLevel", emplLevel)
                .toString();
    }

    public Byte getEmplStatus() {
        return emplStatus;
    }

    public void setEmplStatus(Byte emplStatus) {
        this.emplStatus = emplStatus;
    }

    public Byte getEmplSequence() {
        return emplSequence;
    }

    public void setEmplSequence(Byte emplSequence) {
        this.emplSequence = emplSequence;
    }

    public Byte getEmplLevel() {
        return emplLevel;
    }

    public void setEmplLevel(Byte emplLevel) {
        this.emplLevel = emplLevel;
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


}
