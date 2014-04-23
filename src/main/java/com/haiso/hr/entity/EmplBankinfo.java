package com.haiso.hr.entity;

import javax.persistence.*;

/**
 * Created by ff on 4/15/14.
 * 员工银行信息记录
 */
@Entity
@Table(name = "t_empl_bankinfo")
public class EmplBankinfo {

    private int id;
    private String accOwner;
    private String bankcardNum;
    private String cardpicPath;
    private String accBank;
    private java.util.Date lastUpdate;
    private java.util.Date createDate;
    private int version;

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

    @PreUpdate
    public void preUpdate() {
        this.lastUpdate = new java.util.Date();
    }

    @PrePersist
    public void prePersist() {
        this.createDate = new java.util.Date();
        this.lastUpdate = new java.util.Date();
        System.out.println("person @PrePersist run!");
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
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "acc_owner", nullable = false, insertable = true, updatable = true, length = 45, precision = 0)
    public String getAccOwner() {
        return accOwner;
    }

    public void setAccOwner(String accOwner) {
        this.accOwner = accOwner;
    }

    @Basic
    @Column(name = "bankcard_num", nullable = false, insertable = true, updatable = true, length = 30, precision = 0)
    public String getBankcardNum() {
        return bankcardNum;
    }

    public void setBankcardNum(String bankcardNum) {
        this.bankcardNum = bankcardNum;
    }

    @Basic
    @Column(name = "cardpic_path", nullable = false, insertable = true, updatable = true, length = 100, precision = 0)
    public String getCardpicPath() {
        return cardpicPath;
    }

    public void setCardpicPath(String cardpicPath) {
        this.cardpicPath = cardpicPath;
    }

    @Basic
    @Column(name = "acc_bank", nullable = false, insertable = true, updatable = true, length = 45, precision = 0)
    public String getAccBank() {
        return accBank;
    }

    public void setAccBank(String accBank) {
        this.accBank = accBank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmplBankinfo that = (EmplBankinfo) o;

        if (id != that.id) return false;
        if (accBank != null ? !accBank.equals(that.accBank) : that.accBank != null) return false;
        if (accOwner != null ? !accOwner.equals(that.accOwner) : that.accOwner != null) return false;
        if (bankcardNum != null ? !bankcardNum.equals(that.bankcardNum) : that.bankcardNum != null) return false;
        if (cardpicPath != null ? !cardpicPath.equals(that.cardpicPath) : that.cardpicPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (accOwner != null ? accOwner.hashCode() : 0);
        result = 31 * result + (bankcardNum != null ? bankcardNum.hashCode() : 0);
        result = 31 * result + (cardpicPath != null ? cardpicPath.hashCode() : 0);
        result = 31 * result + (accBank != null ? accBank.hashCode() : 0);
        return result;
    }
}
