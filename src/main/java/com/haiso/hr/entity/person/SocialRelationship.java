package com.haiso.hr.entity.person;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.BaseEntity;
import com.haiso.hr.entity.commons.Address;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by ff on 4/15/14.
 * 个人社会信息表
 */
@Entity
@Table(name = "t_prsn_sclrlt")
public class SocialRelationship extends BaseEntity{

    @Basic
    @Column(name = "is_emgcnt")
    private Boolean isEmergencyContact;  //is emergency contact or not;
    @Basic
    @Column(name = "is_sponsor")
    private Boolean isSponsor;  //is Sponsor or not;
    @Basic
    @Column(name = "relation")
    private String relation;
    @Basic
    @Column(name = "name")
    @NotNull
    private String name;
    @Basic
    @Column(name = "age")
    private Short age;

    @Embedded
    private Address address;
    @Basic
    @Column(name = "company")
    private String company;
    @Basic
    @Column(name = "position")
    private String position;
    @Basic
    @Column(name = "phone")
    private String phone;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id")
    private Person person;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String post) {
        this.position = post;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(isEmergencyContact, isSponsor, relation, name, age, address, company, position, phone, person);
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
        final SocialRelationship other = (SocialRelationship) obj;
        return Objects.equal(this.isEmergencyContact, other.isEmergencyContact) && Objects.equal(this.isSponsor, other.isSponsor) && Objects.equal(this.relation, other.relation) && Objects.equal(this.name, other.name) && Objects.equal(this.age, other.age) && Objects.equal(this.address, other.address) && Objects.equal(this.company, other.company) && Objects.equal(this.position, other.position) && Objects.equal(this.phone, other.phone) && Objects.equal(this.person, other.person);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("isEmergencyContact", isEmergencyContact)
                .add("isSponsor", isSponsor)
                .add("relation", relation)
                .add("name", name)
                .add("age", age)
                .add("address", address)
                .add("company", company)
                .add("position", position)
                .add("phone", phone)
                .add("person", person)
                .toString();
    }

    public Boolean getIsEmergencyContact() {
        return isEmergencyContact;
    }

    public void setIsEmergencyContact(Boolean isEmergencyContact) {
        this.isEmergencyContact = isEmergencyContact;
    }

    public Boolean getIsSponsor() {
        return isSponsor;
    }

    public void setIsSponsor(Boolean isSponsor) {
        this.isSponsor = isSponsor;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
