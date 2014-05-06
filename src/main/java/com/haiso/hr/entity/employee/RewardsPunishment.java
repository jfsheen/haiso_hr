package com.haiso.hr.entity.employee;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ff on 4/15/14.
 * 个人奖惩记录表
 */
@Entity
@Table(name = "t_empl_rwpns")
public class RewardsPunishment {
    private Integer id;
    private String school;
    private String major;
    private Date startDate;
    private Date endDate;
    private String qualify;
    private String degree;

    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empl_sn", nullable = false, insertable = true, updatable = false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "school", nullable = false, insertable = true, updatable = true, length = 45, precision = 0)
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Basic
    @Column(name = "major", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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
    @Column(name = "qualify", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getQualify() {
        return qualify;
    }

    public void setQualify(String qualify) {
        this.qualify = qualify;
    }

    @Basic
    @Column(name = "degree", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, school, major, startDate, endDate, qualify, degree, employee);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final RewardsPunishment other = (RewardsPunishment) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.school, other.school) && Objects.equal(this.major, other.major) && Objects.equal(this.startDate, other.startDate) && Objects.equal(this.endDate, other.endDate) && Objects.equal(this.qualify, other.qualify) && Objects.equal(this.degree, other.degree) && Objects.equal(this.employee, other.employee);
    }
}
