package com.haiso.hr.entity.person;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.BaseEntity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ff on 4/15/14.
 * 个人工作简历表
 */
@Entity
@Table(name = "t_prsn_wrkexp")
public class WorkExperience extends BaseEntity{
    @Basic
    @Column(name = "company")
    private String companyName;
    @Basic
    @Column(name = "position")
    private String position;
    @Basic
    @Column(name = "start_date")
    private Date startDate;
    @Basic
    @Column(name = "end_date")
    private Date endDate;
    @Basic
    @Column(name = "com_phone")
    private String comPhone;
    @Basic
    @Column(name = "com_address")
    private String comAddress;
    @Basic
    @Column(name = "com_website")
    private String comWebsite;
    @Basic
    @Column(name = "com_email")
    private String comEmail;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id")
    private Person person;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    public String getComWebsite() {
        return comWebsite;
    }

    public void setComWebsite(String com_website) {
        this.comWebsite = com_website;
    }

    public String getComEmail() {
        return comEmail;
    }

    public void setComEmail(String com_email) {
        this.comEmail = com_email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String company) {
        this.companyName = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public String getComPhone() {
        return comPhone;
    }

    public void setComPhone(String contact) {
        this.comPhone = contact;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, companyName, position, startDate, endDate, comPhone, comAddress, comWebsite, comEmail, person);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final WorkExperience other = (WorkExperience) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.companyName, other.companyName) && Objects.equal(this.position, other.position) && Objects.equal(this.startDate, other.startDate) && Objects.equal(this.endDate, other.endDate) && Objects.equal(this.comPhone, other.comPhone) && Objects.equal(this.comAddress, other.comAddress) && Objects.equal(this.comWebsite, other.comWebsite) && Objects.equal(this.comEmail, other.comEmail) && Objects.equal(this.person, other.person);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("companyName", companyName)
                .add("position", position)
                .add("startDate", startDate)
                .add("endDate", endDate)
                .add("comPhone", comPhone)
                .add("comAddress", comAddress)
                .add("comWebsite", comWebsite)
                .add("comEmail", comEmail)
                .add("person", person)
                .toString();
    }
}
