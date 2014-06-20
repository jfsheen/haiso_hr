package com.haiso.hr.entity.person;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.AuditBaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by ff on 6/18/14.
 */
@Entity
@Table(name = "t_blacklist")
public class Blacklist extends AuditBaseEntity{

    @OneToOne
    private Person personBlocked;
    private String remark;
    private String description;
    private Date invalidFrom;
    private Date validFrom;
    private Boolean remindValid;
    private Boolean remindInvolved;

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(personBlocked, remark, description, invalidFrom, validFrom, remindValid, remindInvolved);
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
        final Blacklist other = (Blacklist) obj;
        return Objects.equal(this.personBlocked, other.personBlocked) && Objects.equal(this.remark, other.remark) && Objects.equal(this.description, other.description) && Objects.equal(this.invalidFrom, other.invalidFrom) && Objects.equal(this.validFrom, other.validFrom) && Objects.equal(this.remindValid, other.remindValid) && Objects.equal(this.remindInvolved, other.remindInvolved);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("personBlocked", personBlocked)
                .add("remark", remark)
                .add("description", description)
                .add("invalidFrom", invalidFrom)
                .add("validFrom", validFrom)
                .add("remindValid", remindValid)
                .add("remindInvolved", remindInvolved)
                .toString();
    }

    public Person getPersonBlocked() {
        return personBlocked;
    }

    public void setPersonBlocked(Person personBlocked) {
        this.personBlocked = personBlocked;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getInvalidFrom() {
        return invalidFrom;
    }

    public void setInvalidFrom(Date invalidFrom) {
        this.invalidFrom = invalidFrom;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Boolean getRemindValid() {
        return remindValid;
    }

    public void setRemindValid(Boolean remindValid) {
        this.remindValid = remindValid;
    }

    public Boolean getRemindInvolved() {
        return remindInvolved;
    }

    public void setRemindInvolved(Boolean remindInvolved) {
        this.remindInvolved = remindInvolved;
    }
}
