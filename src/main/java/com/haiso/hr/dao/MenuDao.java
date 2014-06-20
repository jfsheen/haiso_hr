package com.haiso.hr.dao;

import com.haiso.hr.entity.manage.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ff on 6/17/14.
 */
public interface MenuDao extends CrudRepository<Menu, Long> {
    public List<Menu> findByLevel(Short level);
}
