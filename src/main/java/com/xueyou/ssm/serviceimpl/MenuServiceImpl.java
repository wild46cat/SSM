package com.xueyou.ssm.serviceimpl;

import com.xueyou.ssm.dao.MenuDao;
import com.xueyou.ssm.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/24.
 */
@Service("MenuService")
public class MenuServiceImpl implements MenuService{

    @Autowired
    MenuDao menuDao;

    public Map<String, Object> getMenuList() {
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("list",menuDao.getMenuList());
        return resMap;
    }
}
