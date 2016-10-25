package com.xueyou.ssm.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/12.
 */
public interface DepartmentDao {
    public List<Map<String,Object>> departmentList();
    public List<Map<String,Object>> hasExistInThisNode(Map<String,Object> params);
    public int departmentAdd(Map<String,Object> params);
    public int departmentEdit(Map<String,Object> params);
    public int departmentDelete(Map<String,Object> params);
    public int departmentDeleteCascade(Map<String,Object> params);
    public int dutyDeleteCascade(Map<String,Object> params);
    public int departmentNewRoot();

}
