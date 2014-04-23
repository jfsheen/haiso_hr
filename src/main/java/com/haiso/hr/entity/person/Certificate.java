package com.haiso.hr.entity.person;

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


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Certificate that = (Certificate) o;
//
//        if (id != that.id) return false;
//        if (company != null ? !company.equals(that.company) : that.company != null) return false;
//        if (contact != null ? !contact.equals(that.contact) : that.contact != null) return false;
//        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
//        if (position != null ? !position.equals(that.position) : that.position != null) return false;
//        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (company != null ? company.hashCode() : 0);
//        result = 31 * result + (position != null ? position.hashCode() : 0);
//        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
//        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
//        result = 31 * result + (contact != null ? contact.hashCode() : 0);
//        return result;
//    }
}
