package com.haiso.hr.entity.employee;

import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * Created by ff on 4/15/14.
 * 员工银行信息记录
 */
@Entity
@Table(name = "t_empl_bankinfo")
public class BankInfo {

    private Integer id;
    private String accOwner;
    private String bankcardNum;
    private String cardpicPath;
    private String accBank;
    private java.util.Date lastUpdate;
    private java.util.Date createDate;
    private Integer version;

    private Employee employee;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, length = 10, precision = 0)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "acc_owner", nullable = false, length = 20, precision = 0)
    public String getAccOwner() {
        return accOwner;
    }

    public void setAccOwner(String accOwner) {
        this.accOwner = accOwner;
    }

    @Column(name = "bankcard_num", nullable = false, length = 20, precision = 0)
    public String getBankcardNum() {
        return bankcardNum;
    }

    public void setBankcardNum(String bankcardNum) {
        this.bankcardNum = bankcardNum;
    }

    @Column(name = "cardpic_path", nullable = true, length = 100, precision = 0)
    public String getCardpicPath() {
        return cardpicPath;
    }

    public void setCardpicPath(String cardpicPath) {
        this.cardpicPath = cardpicPath;
    }

    @Column(name = "acc_bank", nullable = false, length = 40, precision = 0)
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
}
