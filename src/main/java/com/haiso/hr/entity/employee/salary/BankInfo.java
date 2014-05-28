package com.haiso.hr.entity.employee.salary;

import com.google.common.base.Objects;
import com.haiso.hr.entity.employee.Employee;

import javax.persistence.*;

/**
 * Created by ff on 4/15/14.
 * 员工银行信息记录
 */
@Entity
@Table(name = "t_empl_bankinfo")
public class BankInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "acc_owner")
    private String accOwner;
    @Basic
    @Column(name = "bankcard_num")
    private String bankcardNum;
    @Basic
    @Column(name = "cardpic_path")
    private String cardpicPath;
    @Basic
    @Column(name = "acc_bank")
    private String accBank;
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date lastUpdate;
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createDate;
    @Version
    @Column(name = "version_lock")
    private Integer version;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empl_sn")
    private Employee employee;

    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }


    public java.util.Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(java.util.Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastUpdate = new java.util.Date();
    }

    @PrePersist
    public void prePersist() {
        this.createDate = new java.util.Date();
        this.lastUpdate = new java.util.Date();
    }

    @PreRemove
    public void preRemove() {

    }

    @PostPersist
    public void postPersist() {

    }

    @PostLoad
    public void postLoad() {

    }

    @PostRemove
    public void postRemove() {

    }

    @PostUpdate
    public void postUpdate() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getAccOwner() {
        return accOwner;
    }

    public void setAccOwner(String accOwner) {
        this.accOwner = accOwner;
    }


    public String getBankcardNum() {
        return bankcardNum;
    }

    public void setBankcardNum(String bankcardNum) {
        this.bankcardNum = bankcardNum;
    }


    public String getCardpicPath() {
        return cardpicPath;
    }

    public void setCardpicPath(String cardpicPath) {
        this.cardpicPath = cardpicPath;
    }

    public String getAccBank() {
        return accBank;
    }

    public void setAccBank(String accBank) {
        this.accBank = accBank;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, accOwner, bankcardNum, cardpicPath, accBank, lastUpdate, createDate, version, employee);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final BankInfo other = (BankInfo) obj;
        return Objects.equal(this.id, other.id) && Objects.equal(this.accOwner, other.accOwner) && Objects.equal(this.bankcardNum, other.bankcardNum) && Objects.equal(this.cardpicPath, other.cardpicPath) && Objects.equal(this.accBank, other.accBank) && Objects.equal(this.lastUpdate, other.lastUpdate) && Objects.equal(this.createDate, other.createDate) && Objects.equal(this.version, other.version) && Objects.equal(this.employee, other.employee);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("accOwner", accOwner)
                .add("bankcardNum", bankcardNum)
                .add("cardpicPath", cardpicPath)
                .add("accBank", accBank)
                .add("lastUpdate", lastUpdate)
                .add("createDate", createDate)
                .add("version", version)
                .add("employee", employee)
                .toString();
    }
}
