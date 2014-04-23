package com.haiso.hr.dao;

import java.io.Serializable;

/**
 * Created by ff on 4/17/14.
 */
public abstract class AbstractDao<T, ID extends Serializable> {
    private final transient Class<T> clazz;

    protected AbstractDao() {
        this.clazz = null;
    }

//    protected AbstractDao(Class<T> clazz) {
//        this.clazz = clazz;
//    }
}