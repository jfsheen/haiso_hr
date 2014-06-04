package com.haiso.hr.entity.employee.salary;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.AuditBaseEntity;
import com.haiso.hr.entity.employee.Employee;

import javax.persistence.*;

/**
 * Created by ff on 4/15/14.
 * 员工银行信息记录
 */
@Entity
@Table(name = "t_empl_bankinfo")
public class BankInfo extends AuditBaseEntity{

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empl_sn")
    private Employee employee;

    
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        return 31 * super.hashCode() + Objects.hashCode(accOwner, bankcardNum, cardpicPath, accBank, employee);
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
        final BankInfo other = (BankInfo) obj;
        return Objects.equal(this.accOwner, other.accOwner) && Objects.equal(this.bankcardNum, other.bankcardNum) && Objects.equal(this.cardpicPath, other.cardpicPath) && Objects.equal(this.accBank, other.accBank) && Objects.equal(this.employee, other.employee);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("accOwner", accOwner)
                .add("bankcardNum", bankcardNum)
                .add("cardpicPath", cardpicPath)
                .add("accBank", accBank)
                .add("employee", employee)
                .toString();
    }
}
