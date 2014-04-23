package com.haiso.hr.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ff on 4/15/14.
 * 个人工作简历表
 */
@Entity
@Table(name = "t_prsn_workexp")
public class PersonWorkExperience {
    private int id;
    private String company;
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

    @Basic
    @Column(name = "company", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "position", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "start_date", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "com_phone", nullable = true, insertable = true, updatable = true, length = 50, precision = 0)
    public String getComPhone() {
        return comPhone;
    }

    public void setComPhone(String contact) {
        this.comPhone = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonWorkExperience that = (PersonWorkExperience) o;

        if (id != that.id) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (comPhone != null ? !comPhone.equals(that.comPhone) : that.comPhone != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (comPhone != null ? comPhone.hashCode() : 0);
        return result;
    }
}
