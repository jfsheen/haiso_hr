package com.haiso.hr.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ff on 4/15/14.
 * 员工考核记录表
 */
@Entity
@Table(name = "t_empl_appra")
public class EmplAppraisal {
    private int id;
    private String title;
    private String content;
    private Date startDate;
    private Date endDate;
    private String qualify;
    private String score;
    private String comment;
    private String conclusion;
    private java.util.Date lastUpdate;
    private java.util.Date createDate;
    private int version;

    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empl_sn", nullable = false, insertable = true, updatable = false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Version
    @Column(name = "version_lock", length = 10)
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Basic
    @Column(name = "create_date", nullable = false, insertable = true, updatable = false, length = 1, precision = 0)
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "last_update", nullable = false, insertable = true, updatable = true, length = 1, precision = 0)
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.util.Date lastUpdate) {
        this.lastUpdate = lastUpdate;
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
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 45, precision = 0)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = false, insertable = true, updatable = true, length = 100, precision = 0)
    public String getContent() {
        return content;
    }

    public void setContent(String degree) {
        this.content = content;
    }

    @Basic
    @Column(name = "score", nullable = false, insertable = true, updatable = true, length = 6, precision = 0)
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
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

    @Column(name = "conclusion")
    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        EmplAppraisal that = (EmplAppraisal) o;
//
//        if (id != that.id) return false;
//        if (degree != null ? !degree.equals(that.degree) : that.degree != null) return false;
//        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
//        if (major != null ? !major.equals(that.major) : that.major != null) return false;
//        if (qualify != null ? !qualify.equals(that.qualify) : that.qualify != null) return false;
//        if (school != null ? !school.equals(that.school) : that.school != null) return false;
//        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (school != null ? school.hashCode() : 0);
//        result = 31 * result + (major != null ? major.hashCode() : 0);
//        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
//        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
//        result = 31 * result + (qualify != null ? qualify.hashCode() : 0);
//        result = 31 * result + (degree != null ? degree.hashCode() : 0);
//        return result;
//    }
}
