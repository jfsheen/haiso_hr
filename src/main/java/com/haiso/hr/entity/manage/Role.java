package com.haiso.hr.entity.manage;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.AuditBaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by ff on 6/17/14.
 */
@Entity
@Table(name = "t_role")
public class Role extends AuditBaseEntity {
    /*private String roleName;
    private Date validFrom;
    private Date validUntil;
    private Boolean isBanned;
    private String desc;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<User> userSet;

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(roleName, validFrom, validUntil, isBanned, desc, userSet);
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
        final Role other = (Role) obj;
        return Objects.equal(this.roleName, other.roleName) && Objects.equal(this.validFrom, other.validFrom) && Objects.equal(this.validUntil, other.validUntil) && Objects.equal(this.isBanned, other.isBanned) && Objects.equal(this.desc, other.desc) && Objects.equal(this.userSet, other.userSet);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("roleName", roleName)
                .add("validFrom", validFrom)
                .add("validUntil", validUntil)
                .add("isBanned", isBanned)
                .add("desc", desc)
                .add("userSet", userSet)
                .toString();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public Boolean getIsBanned() {
        return isBanned;
    }

    public void setIsBanned(Boolean isBanned) {
        this.isBanned = isBanned;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }*/
}
