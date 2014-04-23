package com.haiso.hr.service.param;

import com.haiso.hr.dao.ParamDao;
import com.haiso.hr.entity.param.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ff on 4/23/14.
 */
@Service
public class ParamServiceImpl implements ParamService {

    @Autowired
    private ParamDao paramDao;


    @Override
    public void addParam(Param param) {
        paramDao.save(param);
    }

    @Override
    public void removeParam(Param param) {
        paramDao.delete(param);
    }
}
