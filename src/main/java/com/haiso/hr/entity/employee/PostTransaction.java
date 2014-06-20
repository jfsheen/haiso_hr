package com.haiso.hr.entity.employee;

import com.google.common.base.Objects;
import com.haiso.hr.entity.organization.Position;
import com.haiso.hr.entity.base.AuditBaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ff on 4/15/14.
 */
@Entity
@Table(name = "t_empl_pos_tx")
public class PostTransaction extends AuditBaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empl_id", nullable = false)
    private Employee employee;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "from_post", nullable = false)
    private Position fromPost;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_post", nullable = false)
    private Position toPost;
    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "tx_date")
    private Date txDate;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "deptFrm_leader")
    private Employee deptFromLeader;
    @Basic
    @Column(name = "deptFrm_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deptFromDate;
    @Basic
    @Column(name = "deptFrm_opinion")
    private String deptFromOpinion;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "deptTo_leader")
    private Employee deptToLeader;
    @Basic
    @Column(name = "deptTo_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deptToDate;
    @Basic
    @Column(name = "deptTo_opinion")
    private String deptToOpinion;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "hr_leader", nullable = true)
    private Employee hrLeader;
    @Basic
    @Column(name = "hr_date", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    private Date hrDate;
    @Basic
    @Column(name = "hr_opinion", length = 50)
    private String hrOpinion;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "com_leader", nullable = true)
    private Employee comLeader;
    @Basic
    @Column(name = "com_date", nullable = false, length = 1)
    @Temporal(TemporalType.TIMESTAMP)
    private Date comDate;
    @Basic
    @Column(name = "com_opinion", length = 50)
    private String comOpinion;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "manager", nullable = true)
    private Employee manager;
    @Basic
    @Column(name = "remark", nullable = false, insertable = true, updatable = true, length = 45, precision = 0)
    private String remark;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(employee, fromPost, toPost, txDate, deptFromLeader, deptFromDate, deptFromOpinion, deptToLeader, deptToDate, deptToOpinion, hrLeader, hrDate, hrOpinion, comLeader, comDate, comOpinion, manager, remark);
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
        final PostTransaction other = (PostTransaction) obj;
        return Objects.equal(this.employee, other.employee) && Objects.equal(this.fromPost, other.fromPost) && Objects.equal(this.toPost, other.toPost) && Objects.equal(this.txDate, other.txDate) && Objects.equal(this.deptFromLeader, other.deptFromLeader) && Objects.equal(this.deptFromDate, other.deptFromDate) && Objects.equal(this.deptFromOpinion, other.deptFromOpinion) && Objects.equal(this.deptToLeader, other.deptToLeader) && Objects.equal(this.deptToDate, other.deptToDate) && Objects.equal(this.deptToOpinion, other.deptToOpinion) && Objects.equal(this.hrLeader, other.hrLeader) && Objects.equal(this.hrDate, other.hrDate) && Objects.equal(this.hrOpinion, other.hrOpinion) && Objects.equal(this.comLeader, other.comLeader) && Objects.equal(this.comDate, other.comDate) && Objects.equal(this.comOpinion, other.comOpinion) && Objects.equal(this.manager, other.manager) && Objects.equal(this.remark, other.remark);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("employee", employee)
                .add("fromPost", fromPost)
                .add("toPost", toPost)
                .add("txDate", txDate)
                .add("deptFromLeader", deptFromLeader)
                .add("deptFromDate", deptFromDate)
                .add("deptFromOpinion", deptFromOpinion)
                .add("deptToLeader", deptToLeader)
                .add("deptToDate", deptToDate)
                .add("deptToOpinion", deptToOpinion)
                .add("hrLeader", hrLeader)
                .add("hrDate", hrDate)
                .add("hrOpinion", hrOpinion)
                .add("comLeader", comLeader)
                .add("comDate", comDate)
                .add("comOpinion", comOpinion)
                .add("manager", manager)
                .add("remark", remark)
                .toString();
    }

    public Position getFromPost() {
        return fromPost;
    }

    public void setFromPost(Position fromPost) {
        this.fromPost = fromPost;
    }

    public Position getToPost() {
        return toPost;
    }

    public void setToPost(Position toPost) {
        this.toPost = toPost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public Employee getDeptFromLeader() {
        return deptFromLeader;
    }

    public void setDeptFromLeader(Employee deptFromLeader) {
        this.deptFromLeader = deptFromLeader;
    }

    public Date getDeptFromDate() {
        return deptFromDate;
    }

    public void setDeptFromDate(Date deptFromDate) {
        this.deptFromDate = deptFromDate;
    }

    public String getDeptFromOpinion() {
        return deptFromOpinion;
    }

    public void setDeptFromOpinion(String deptFromOpinion) {
        this.deptFromOpinion = deptFromOpinion;
    }

    public Employee getDeptToLeader() {
        return deptToLeader;
    }

    public void setDeptToLeader(Employee deptToLeader) {
        this.deptToLeader = deptToLeader;
    }

    public Date getDeptToDate() {
        return deptToDate;
    }

    public void setDeptToDate(Date deptToDate) {
        this.deptToDate = deptToDate;
    }

    public String getDeptToOpinion() {
        return deptToOpinion;
    }

    public void setDeptToOpinion(String deptToOpinion) {
        this.deptToOpinion = deptToOpinion;
    }

    public Employee getHrLeader() {
        return hrLeader;
    }

    public void setHrLeader(Employee hrLeader) {
        this.hrLeader = hrLeader;
    }

    public Date getHrDate() {
        return hrDate;
    }

    public void setHrDate(Date hrDate) {
        this.hrDate = hrDate;
    }

    public String getHrOpinion() {
        return hrOpinion;
    }

    public void setHrOpinion(String hrOpinion) {
        this.hrOpinion = hrOpinion;
    }

    public Employee getComLeader() {
        return comLeader;
    }

    public void setComLeader(Employee comLeader) {
        this.comLeader = comLeader;
    }

    public Date getComDate() {
        return comDate;
    }

    public void setComDate(Date comDate) {
        this.comDate = comDate;
    }

    public String getComOpinion() {
        return comOpinion;
    }

    public void setComOpinion(String comOpinion) {
        this.comOpinion = comOpinion;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
