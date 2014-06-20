package com.haiso.hr.service.manage;

import com.haiso.hr.dao.MenuDao;
import com.haiso.hr.entity.manage.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by ff on 6/17/14.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    @Transactional
    public void addMenu(Menu menu) {
        menuDao.save(menu);
    }

    @Override
    public List<Menu> findAll() {
        return (List<Menu>) menuDao.findAll();

    }

    @Override
    public Menu getMenuById(Long id) {
        return menuDao.findOne(id);
    }

    @Override
    public List<Menu> getMenuByLevel(Short level) {
        return menuDao.findByLevel(level);
    }
}
