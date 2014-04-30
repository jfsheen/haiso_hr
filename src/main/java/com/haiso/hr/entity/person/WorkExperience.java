package com.haiso.hr.entity.person;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ff on 4/15/14.
 * 个人工作简历表
 */
@Entity
@Table(name = "t_prsn_wrkexp")
public class WorkExperience {
    private int id;
    private String companyName;
    private String position;
    private Date startDate;
    private Date endDate;
    private String comPhone;
    private String comAddress;
    private String comWebsite;
    private String comEmail;

    private Person person;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Column(name = "com_address")
    public String getComAddress() {
        return comAddress;
    }

    public void setComAddress(String comAddress) {
        this.comAddress = comAddress;
    }

    @Column(name = "com_website")
    public String getComWebsite() {
        return comWebsite;
    }

    public void setComWebsite(String com_website) {
        this.comWebsite = com_website;
    }

    @Column(name = "com_email")
    public String getComEmail() {
        return comEmail;
    }

    public void setComEmail(String com_email) {
        this.comEmail = com_email;
    }

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "company", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String company) {
        this.companyName = company;
    }


    @Column(name = "position", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Column(name = "start_date", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    @Column(name = "end_date", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    @Column(name = "com_phone", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
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
