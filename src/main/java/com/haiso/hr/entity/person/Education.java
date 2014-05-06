package com.haiso.hr.entity.person;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ff on 4/15/14.
 * 教育培训记录表
 */
@Entity
@Table(name = "t_prsn_edu")
public class Education {
    private Integer id;
    private String school;
    private String major;
    private Date startDate;
    private Date endDate;
    private String qualify;
    private String degree;

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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Column(name = "school", nullable = false, insertable = true, updatable = true, length = 45, precision = 0)
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }


    @Column(name = "major", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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


    @Column(name = "qualify", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getQualify() {
        return qualify;
    }

    public void setQualify(String qualify) {
        this.qualify = qualify;
    }


    @Column(name = "degree", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, school, major, startDate, endDate, qualify, degree, person);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Education other = (Education) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.school, other.school) && Objects.equal(this.major, other.major) && Objects.equal(this.startDate, other.startDate) && Objects.equal(this.endDate, other.endDate) && Objects.equal(this.qualify, other.qualify) && Objects.equal(this.degree, other.degree) && Objects.equal(this.person, other.person);
    }
}
