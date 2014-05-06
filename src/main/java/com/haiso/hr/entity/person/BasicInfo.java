package com.haiso.hr.entity.person;

import javax.persistence.*;

/**
 * Created by ff on 4/17/14.
 * 个人基本信息表
 */

@Entity
@Table(name = "t_prsn_info")
public class BasicInfo {

    private Integer id;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, length = 10)
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
