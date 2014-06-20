package com.haiso.hr.entity.manage;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.AuditBaseEntity;
import com.haiso.hr.entity.person.Person;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by ff on 6/17/14.
 */
@Entity
@Table(name = "t_user")
public class User extends AuditBaseEntity{
    /*private String username;
    private String password;
    private Date validFrom;
    private Date validUntil;
    private Boolean isBanned;
    private String desc;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Role> roleSet;

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(username, password, validFrom, validUntil, isBanned, desc, person, roleSet);
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
        final User other = (User) obj;
        return Objects.equal(this.username, other.username) && Objects.equal(this.password, other.password) && Objects.equal(this.validFrom, other.validFrom) && Objects.equal(this.validUntil, other.validUntil) && Objects.equal(this.isBanned, other.isBanned) && Objects.equal(this.desc, other.desc) && Objects.equal(this.person, other.person) && Objects.equal(this.roleSet, other.roleSet);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("username", username)
                .add("password", password)
                .add("validFrom", validFrom)
                .add("validUntil", validUntil)
                .add("isBanned", isBanned)
                .add("desc", desc)
                .add("person", person)
                .add("roleSet", roleSet)
                .toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }*/
}
