package com.haiso.hr.entity.person;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/15/14.
 * 人员证书证件记录表
 */
@Entity
@Table(name = "t_prsn_crtf")
public class Certificate extends BaseEntity{

    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "crtf_sn")
    private String serialNum;
    @Basic
    @Column(name = "obtain_date")
    @Temporal(TemporalType.DATE)
    private Date obtainDate;
    @Basic
    @Column(name = "expiry_date")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @Basic
    @Column(name = "authority")
    private String authority;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "edu_id")
    private Education education;

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(name, serialNum, obtainDate, expiryDate, authority, person, education);
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
        final Certificate other = (Certificate) obj;
        return Objects.equal(this.name, other.name) && Objects.equal(this.serialNum, other.serialNum) && Objects.equal(this.obtainDate, other.obtainDate) && Objects.equal(this.expiryDate, other.expiryDate) && Objects.equal(this.authority, other.authority) && Objects.equal(this.person, other.person) && Objects.equal(this.education, other.education);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("serialNum", serialNum)
                .add("obtainDate", obtainDate)
                .add("expiryDate", expiryDate)
                .add("authority", authority)
                .add("person", person)
                .add("education", education)
                .toString();
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getObtainDate() {
        return obtainDate;
    }

    public void setObtainDate(Date obtainDate) {
        this.obtainDate = obtainDate;
    }


    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }


    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }


    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
