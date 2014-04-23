package com.haiso.hr.entity.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ff on 4/17/14.
 * 个人基本信息表
 */
@Entity
@Table(name = "t_prsn_info")
public class BasicInfo {

    private String id;

    @Id
    @GeneratedValue
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
