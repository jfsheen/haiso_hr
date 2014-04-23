package com.haiso.hr.entity.employee;

import com.haiso.hr.entity.Department;
import com.haiso.hr.entity.Position;
import com.haiso.hr.entity.person.Person;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ff on 4/15/14.
 * 员工信息
 */
@Entity
@Table(name = "t_employee")
public class Employee {

    //private int id;
    private String emplSn;
    private String name;
    private String introduction;
    private java.util.Date lastUpdate;
    private java.util.Date createDate;
    private int version;
    private Set<Department> departmentSet = new HashSet<Department>();
    private Set<Position> positionSet = new HashSet<Position>();
    private Person person;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
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
        this.createDate = new java.util.Date();
        this.lastUpdate = new java.util.Date();
        System.out.println("person @PrePersist run!");
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

//    @Id
//    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    @Id
    @Column(name = "empl_sn", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public String getEmplSn() {
        return emplSn;
    }

    public void setEmplSn(String emplSn) {
        this.emplSn = emplSn;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "introduction", nullable = true, insertable = true, updatable = true, length = 500, precision = 0)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Employee employee = (Employee) o;
//
//        if (id != employee.id) return false;
//        if (address != null ? !address.equals(employee.address) : employee.address != null) return false;
//        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
//        if (emplSn != null ? !emplSn.equals(employee.emplSn) : employee.emplSn != null) return false;
//        if (ethinic != null ? !ethinic.equals(employee.ethinic) : employee.ethinic != null) return false;
//        if (hometown != null ? !hometown.equals(employee.hometown) : employee.hometown != null) return false;
//        if (idcardNum != null ? !idcardNum.equals(employee.idcardNum) : employee.idcardNum != null) return false;
//        if (idcardPath != null ? !idcardPath.equals(employee.idcardPath) : employee.idcardPath != null) return false;
//        if (introduction != null ? !introduction.equals(employee.introduction) : employee.introduction != null)
//            return false;
//        if (mobile != null ? !mobile.equals(employee.mobile) : employee.mobile != null) return false;
//        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
//        if (partisan != null ? !partisan.equals(employee.partisan) : employee.partisan != null) return false;
//        if (partyDate != null ? !partyDate.equals(employee.partyDate) : employee.partyDate != null) return false;
//        if (phone != null ? !phone.equals(employee.phone) : employee.phone != null) return false;
//        if (photoPath != null ? !photoPath.equals(employee.photoPath) : employee.photoPath != null) return false;
//        if (postalcode != null ? !postalcode.equals(employee.postalcode) : employee.postalcode != null) return false;
//        if (qq != null ? !qq.equals(employee.qq) : employee.qq != null) return false;
//        if (weixin != null ? !weixin.equals(employee.weixin) : employee.weixin != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (emplSn != null ? emplSn.hashCode() : 0);
//        result = 31 * result + (idcardNum != null ? idcardNum.hashCode() : 0);
//        result = 31 * result + (idcardPath != null ? idcardPath.hashCode() : 0);
//        result = 31 * result + (photoPath != null ? photoPath.hashCode() : 0);
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (ethinic != null ? ethinic.hashCode() : 0);
//        result = 31 * result + (partisan != null ? partisan.hashCode() : 0);
//        result = 31 * result + (partyDate != null ? partyDate.hashCode() : 0);
//        result = 31 * result + (hometown != null ? hometown.hashCode() : 0);
//        result = 31 * result + (addressProvince != null ? addressProvince.hashCode() : 0);
//        result = 31 * result + (postalcode != null ? postalcode.hashCode() : 0);
//        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
//        result = 31 * result + (phone != null ? phone.hashCode() : 0);
//        result = 31 * result + (email != null ? email.hashCode() : 0);
//        result = 31 * result + (qq != null ? qq.hashCode() : 0);
//        result = 31 * result + (weixin != null ? weixin.hashCode() : 0);
//        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
//        return result;
//    }
}
