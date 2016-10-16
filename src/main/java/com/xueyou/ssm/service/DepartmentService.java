package com.xueyou.ssm.service;


import java.util.Map;

/**
 * Created by wuxueyou on 16/10/12.
 */
public interface DepartmentService {
    public Map<String,Object> departmentList();
    public Map<String,Object> departmentAdd(Map<String,Object> params);
    public Map<String,Object> departmentEdit(Map<String,Object> params);
    public Map<String,Object> departmentDelete(Map<String,Object> params);
    public Map<String,Object> departmentDeleteCascade(Map<String,Object> params);
    public Map<String,Object> departmentNewRoot();

}
