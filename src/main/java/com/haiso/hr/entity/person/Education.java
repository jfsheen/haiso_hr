package com.haiso.hr.entity.person;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ff on 4/15/14.
 * 教育培训记录表
 */
@Entity
@Table(name = "t_prsn_edu")
public class Education {
    private int id;
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Education that = (Education) o;

        if (id != that.id) return false;
        if (degree != null ? !degree.equals(that.degree) : that.degree != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (major != null ? !major.equals(that.major) : that.major != null) return false;
        if (qualify != null ? !qualify.equals(that.qualify) : that.qualify != null) return false;
        if (school != null ? !school.equals(that.school) : that.school != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (qualify != null ? qualify.hashCode() : 0);
        result = 31 * result + (degree != null ? degree.hashCode() : 0);
        return result;
    }
}
