package com.haiso.hr.entity;

import javax.persistence.*;

/**
 * Created by ff on 4/15/14.
 * 职位表
 */
@Entity
@Table(name = "t_position")
public class Position {
    private int id;
    private String positionSn;
    private String name;
    private String sequence;
    private byte amountLimit;
    private String duty;
    private String remark;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "position_sn", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public String getPositionSn() {
        return positionSn;
    }

    public void setPositionSn(String positionSn) {
        this.positionSn = positionSn;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sequence", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    @Basic
    @Column(name = "amount_limit", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    public byte getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(byte amountLimit) {
        this.amountLimit = amountLimit;
    }

    @Basic
    @Column(name = "duty", nullable = true, insertable = true, updatable = true, length = 500, precision = 0)
    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    @Basic
    @Column(name = "remark", nullable = true, insertable = true, updatable = true, length = 500, precision = 0)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (amountLimit != position.amountLimit) return false;
        if (id != position.id) return false;
        if (duty != null ? !duty.equals(position.duty) : position.duty != null) return false;
        if (name != null ? !name.equals(position.name) : position.name != null) return false;
        if (positionSn != null ? !positionSn.equals(position.positionSn) : position.positionSn != null) return false;
        if (remark != null ? !remark.equals(position.remark) : position.remark != null) return false;
        if (sequence != null ? !sequence.equals(position.sequence) : position.sequence != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (positionSn != null ? positionSn.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sequence != null ? sequence.hashCode() : 0);
        result = 31 * result + (int) amountLimit;
        result = 31 * result + (duty != null ? duty.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}
