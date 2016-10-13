package com.xueyou.ssm.serviceimpl;

import com.xueyou.ssm.dao.DepartmentDao;
import com.xueyou.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/12.
 */
@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentDao departmentDao;
    @Override
    public Map<String, Object> departmentList() {
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("list",departmentDao.departmentList());
        return resMap;
    }
}
