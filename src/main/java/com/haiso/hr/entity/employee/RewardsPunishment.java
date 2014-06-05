package com.haiso.hr.entity.employee;

import com.google.common.base.Objects;
import com.haiso.hr.entity.Department;
import com.haiso.hr.entity.base.AuditBaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/15/14.
 * 个人奖惩记录表
 */
@Entity
@Table(name = "t_empl_rwpns")
public class RewardsPunishment extends AuditBaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empl_id", nullable = false)
    private Employee employee;
    @Basic
    @Column(name = "is_reward")
    private Boolean isReward;
    @Basic
    @Column(name = "subject")
    private String subject;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "impl_date")
    @Temporal(TemporalType.DATE)
    private Date implDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "impl_dept")
    private Department implDept;
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Boolean getIsReward() {
        return isReward;
    }

    public void setIsReward(Boolean isReward) {
        this.isReward = isReward;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getImplDate() {
        return implDate;
    }

    public void setImplDate(Date implDate) {
        this.implDate = implDate;
    }

    public Department getImplDept() {
        return implDept;
    }

    public void setImplDept(Department implDept) {
        this.implDept = implDept;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(employee, isReward, subject, content, implDate, implDept);
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
        final RewardsPunishment other = (RewardsPunishment) obj;
        return Objects.equal(this.employee, other.employee) && Objects.equal(this.isReward, other.isReward) && Objects.equal(this.subject, other.subject) && Objects.equal(this.content, other.content) && Objects.equal(this.implDate, other.implDate) && Objects.equal(this.implDept, other.implDept);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("employee", employee)
                .add("isReward", isReward)
                .add("subject", subject)
                .add("content", content)
                .add("implDate", implDate)
                .add("implDept", implDept)
                .toString();
    }
}
