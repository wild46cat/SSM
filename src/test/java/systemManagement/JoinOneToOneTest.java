package systemManagement;

import com.xueyou.ssm.dao.DutyDao;
import com.xueyou.ssm.dao.UserDao;
import com.xueyou.ssm.model.Duty;
import com.xueyou.ssm.model.User;
import com.xueyou.ssm.model.User2;
import com.xueyou.ssm.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wuxueyou on 16/10/25.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-mvc/springmvc-servlet.xml",
        "file:src/main/webapp/WEB-INF/spring-mvc/datasource.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class JoinOneToOneTest {


    @Autowired
    UserDao userDao;

    @Autowired
    DutyDao dutyDao;


    @Test
    public void getUser(){
        Map<String,Object> params = new HashMap<>();
        params.put("page","1");
        params.put("rows","10");
        List<User2> userlist = userDao.user2List(params);
        for (User2 user : userlist) {
            System.out.println(user);
            System.out.println(user.getDuty());
        }
        Assert.assertEquals(7,userlist.size());
    }

    @Test
    public void getDuty(){
        Map<String,Object> params = new HashMap<>();
        params.put("dutyid", "b68560a6-96c5-11e6-b79e-83fe6f33afd5");
        Duty duty = dutyDao.getDutyById("b68560a6-96c5-11e6-b79e-83fe6f33afd5");
        System.out.println(duty);
        Assert.assertEquals("项目助理",duty.getDutyname());
    }

    @Test
    public void getUserNew(){
        Map<String,Object> params = new HashMap<>();
        params.put("page","1");
        params.put("rows","10");
        List<User2> userlist = userDao.user2Listnew(params);
        for (User2 user : userlist) {
            System.out.println(user);
            System.out.println(user.getDuty());
        }
        Assert.assertEquals(7,userlist.size());
    }
}

