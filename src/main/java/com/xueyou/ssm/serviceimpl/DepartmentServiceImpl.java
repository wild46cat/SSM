package com.xueyou.ssm.serviceimpl;

import com.xueyou.ssm.dao.DepartmentDao;
import com.xueyou.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/12.
 */
@Service("DepartmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentDao departmentDao;

    public Map<String, Object> departmentList() {
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("list", departmentDao.departmentList());
        return resMap;
    }

    public Map<String, Object> departmentAdd(Map<String, Object> params) {
        Map<String, Object> resMap = new HashMap<>();
        List<Map<String, Object>> hasExistList = departmentDao.hasExistInThisNode(params);
        if (hasExistList.size() == 0) {
            resMap.put("resCode", departmentDao.departmentAdd(params));
        } else {
            resMap.put("resCode", 9999);
        }
        return resMap;
    }

    public Map<String, Object> departmentEdit(Map<String, Object> params) {
        Map<String, Object> resMap = new HashMap<>();
        List<Map<String, Object>> hasExistList = departmentDao.hasExistInThisNode(params);
        if (hasExistList.size() == 0) {
            resMap.put("resCode", departmentDao.departmentEdit(params));
        } else {
            resMap.put("resCode", 9999);
        }
        return resMap;
    }

    public Map<String, Object> departmentDelete(Map<String, Object> params) {
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("resCode", departmentDao.departmentDelete(params));
        return resMap;
    }

    public Map<String, Object> departmentDeleteCascade(Map<String, Object> params) {
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("resCode", departmentDao.departmentDelete(params));
        resMap.put("resCode", departmentDao.subdepartmentDelete(params));
        return resMap;
    }

    public Map<String, Object> departmentNewRoot() {
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("resCode", departmentDao.departmentNewRoot());
        return resMap;
    }
}
