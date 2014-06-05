package com.haiso.hr.entity.employee;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.AuditBaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/15/14.
 * 员工考核记录表
 */
@Entity
@Table(name = "t_empl_assess")
public class Assessment extends AuditBaseEntity {

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "start_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic
    @Column(name = "end_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Basic
    @Column(name = "qualify")
    private String qualify;

    @Basic
    @Column(name = "score")
    private String score;

    @Basic
    @Column(name = "comment")
    private String comment;

    @Basic
    @Column(name = "conclusion")
    private String conclusion;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empl_sn")
    private Employee employee;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getQualify() {
        return qualify;
    }

    public void setQualify(String qualify) {
        this.qualify = qualify;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(title, content, startDate, endDate, qualify, score, comment, conclusion, employee);
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
        final Assessment other = (Assessment) obj;
        return Objects.equal(this.title, other.title) && Objects.equal(this.content, other.content) && Objects.equal(this.startDate, other.startDate) && Objects.equal(this.endDate, other.endDate) && Objects.equal(this.qualify, other.qualify) && Objects.equal(this.score, other.score) && Objects.equal(this.comment, other.comment) && Objects.equal(this.conclusion, other.conclusion) && Objects.equal(this.employee, other.employee);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("title", title)
                .add("content", content)
                .add("startDate", startDate)
                .add("endDate", endDate)
                .add("qualify", qualify)
                .add("score", score)
                .add("comment", comment)
                .add("conclusion", conclusion)
                .add("employee", employee)
                .toString();
    }
}
