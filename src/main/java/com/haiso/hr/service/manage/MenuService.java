package com.haiso.hr.service.manage;

import com.haiso.hr.entity.manage.Menu;

import java.util.List;
import java.util.Set;

/**
 * Created by ff on 6/17/14.
 */
public interface MenuService {
    public void addMenu(Menu menu);
    public List<Menu> findAll();
    public Menu getMenuById(Long id);
    public List<Menu> getMenuByLevel(Short level);
}