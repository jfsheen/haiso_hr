package com.haiso.hr.entity.person;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/15/14.
 * 人员证书证件记录表
 */
@Entity
@Table(name = "t_prsn_crtf")
public class Certificate {
    private int id;
    private int eduId;
    private String name;
    private String serialNum;
    private Date obtainDate;
    private Date expiryDate;
    private String authority;

    private Person person;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id", nullable = false)
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "edu_id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getEduId() {
        return eduId;
    }

    public void setEduId(int eduId) {
        this.eduId = eduId;
    }


    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "obtain_date", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Date getObtainDate() {
        return obtainDate;
    }

    public void setObtainDate(Date obtainDate) {
        this.obtainDate = obtainDate;
    }


    @Column(name = "crtf_sn", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }


    @Column(name = "expiry_date", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }


    @Column(name = "authority", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, eduId, name, serialNum, obtainDate, expiryDate, authority, person);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Certificate other = (Certificate) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.eduId, other.eduId) && Objects.equal(this.name, other.name) && Objects.equal(this.serialNum, other.serialNum) && Objects.equal(this.obtainDate, other.obtainDate) && Objects.equal(this.expiryDate, other.expiryDate) && Objects.equal(this.authority, other.authority) && Objects.equal(this.person, other.person);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("eduId", eduId)
                .add("name", name)
                .add("serialNum", serialNum)
                .add("obtainDate", obtainDate)
                .add("expiryDate", expiryDate)
                .add("authority", authority)
                .add("person", person)
                .toString();
    }
}
