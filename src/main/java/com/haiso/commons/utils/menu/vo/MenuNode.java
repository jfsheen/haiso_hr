package com.haiso.commons.utils.menu.vo;

import com.google.common.base.Objects;

import java.util.Set;

/**
 * Created by ff on 6/18/14.
 */
public class MenuNode {
    private String menuSn;
    private String name;
    private String desc;
    private String tips;
    private Boolean isSub;
    private Short level;
    private Set<MenuNode> submenu;

    public MenuNode(String menuSn, String name, String desc, String tips, Boolean isSub, Short level, Set<MenuNode> submenu) {
        this.menuSn = menuSn;
        this.name = name;
        this.desc = desc;
        this.tips = tips;
        this.isSub = isSub;
        this.level = level;
        this.submenu = submenu;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("menuSn", menuSn)
                .add("name", name)
                .add("desc", desc)
                .add("tips", tips)
                .add("isSub", isSub)
                .add("level", level)
                .add("submenu", submenu)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(menuSn, name, desc, tips, isSub, level, submenu);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final MenuNode other = (MenuNode) obj;
        return Objects.equal(this.menuSn, other.menuSn) && Objects.equal(this.name, other.name) && Objects.equal(this.desc, other.desc) && Objects.equal(this.tips, other.tips) && Objects.equal(this.isSub, other.isSub) && Objects.equal(this.level, other.level) && Objects.equal(this.submenu, other.submenu);
    }

    public String getMenuSn() {
    
        return menuSn;
    }

    public void setMenuSn(String menuSn) {
        this.menuSn = menuSn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Boolean getIsSub() {
        return isSub;
    }

    public void setIsSub(Boolean isSub) {
        this.isSub = isSub;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Set<MenuNode> getSubmenu() {
        return submenu;
    }

    public void setSubmenu(Set<MenuNode> submenu) {
        this.submenu = submenu;
    }
}
