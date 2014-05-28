package com.haiso.hr.entity.person;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.BaseEntity;

import javax.persistence.*;

/**
 * Created by ff on 4/15/14.
 * 个人社会信息表
 */
@Entity
@Table(name = "t_prsn_sclrlt")
public class SocialRelationship extends BaseEntity{

    @Basic
    @Column(name = "relation")
    private String relation;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "age")
    private Integer age;
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
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("relation", relation)
                .add("name", name)
                .add("age", age)
                .add("company", company)
                .add("post", position)
                .add("phone", phone)
                .add("person", person)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, relation, name, age, company, position, phone, person);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final SocialRelationship other = (SocialRelationship) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.relation, other.relation) && Objects.equal(this.name, other.name) && Objects.equal(this.age, other.age) && Objects.equal(this.company, other.company) && Objects.equal(this.position, other.position) && Objects.equal(this.phone, other.phone) && Objects.equal(this.person, other.person);
    }
}
