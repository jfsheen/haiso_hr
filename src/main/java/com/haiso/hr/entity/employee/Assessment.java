package com.haiso.hr.entity.employee;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ff on 4/15/14.
 * 员工考核记录表
 */
@Entity
@Table(name = "t_empl_assess")
public class Assessment {
    private Integer id;
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
    private Integer version;

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
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public int hashCode() {
        return Objects.hashCode(id, title, content, startDate, endDate, qualify, score, comment, conclusion, lastUpdate, createDate, version, employee);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Assessment other = (Assessment) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.title, other.title) && Objects.equal(this.content, other.content) && Objects.equal(this.startDate, other.startDate) && Objects.equal(this.endDate, other.endDate) && Objects.equal(this.qualify, other.qualify) && Objects.equal(this.score, other.score) && Objects.equal(this.comment, other.comment) && Objects.equal(this.conclusion, other.conclusion) && Objects.equal(this.lastUpdate, other.lastUpdate) && Objects.equal(this.createDate, other.createDate) && Objects.equal(this.version, other.version) && Objects.equal(this.employee, other.employee);
    }
}
