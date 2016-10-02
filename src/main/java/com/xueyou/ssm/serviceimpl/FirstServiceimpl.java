package com.xueyou.ssm.serviceimpl;

import com.xueyou.ssm.dao.FirstDao;
import com.xueyou.ssm.service.FirstService;
import com.xueyou.ssm.utils.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuxueyou on 16/9/29.
 */
@Service("FirstService")
public class FirstServiceimpl implements FirstService {
    @Autowired
    FirstDao firstDao;

    @Override
    public Map<String, Object> getJson(Map<String, Object> params) {
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("resCode", Base.MSG_CODE_SUCCESS);
        resMap.put("resMessage", Base.MSG_SUCCESS);
        resMap.put("resList",firstDao.getUser(params));
        return resMap;
    }
}
