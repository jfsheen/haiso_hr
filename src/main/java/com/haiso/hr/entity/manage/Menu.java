package com.haiso.hr.entity.manage;

import com.google.common.base.Objects;
import com.haiso.hr.entity.base.AuditBaseEntity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by ff on 6/17/14.
 */
@Entity
@Table(name = "t_menu")
public class Menu extends AuditBaseEntity {
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "tips")
    private String tips;
    @Basic
    @Column(name = "level")
    private Short level;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_menu_id")
    private Menu parentMenu;
    @OneToMany(mappedBy = "parentMenu", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Menu> subMenuSet = new LinkedHashSet<Menu>();

 /*   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "parent_dept_id")
    private Department parentDept;
    @OneToMany(mappedBy = "parentDept", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Department> childDept;
    */

    public Menu() {
    }

    public Menu(String name, String description, String tips, Short level) {
        this.name = name;
        this.description = description;
        this.tips = tips;
        this.level = level;
    }

    public Menu(String name, String description, String tips, Short level, Menu parentMenu, Set<Menu> subMenuSet) {
        this.name = name;
        this.description = description;
        this.tips = tips;
        this.level = level;
        this.parentMenu = parentMenu;
        this.subMenuSet = subMenuSet;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Objects.hashCode(name, description, tips, level, parentMenu, subMenuSet);
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
        final Menu other = (Menu) obj;
        return Objects.equal(this.name, other.name) && Objects.equal(this.description, other.description) && Objects.equal(this.tips, other.tips) && Objects.equal(this.level, other.level) && Objects.equal(this.parentMenu, other.parentMenu) && Objects.equal(this.subMenuSet, other.subMenuSet);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("description", description)
                .add("tips", tips)
                .add("level", level)
                .add("parentMenu", parentMenu)
                .add("subMenuSet", subMenuSet)
                .toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public Set<Menu> getSubMenuSet() {
        return subMenuSet;
    }

    public void setSubMenuSet(Set<Menu> childMenuSet) {
        this.subMenuSet = childMenuSet;
    }
}
