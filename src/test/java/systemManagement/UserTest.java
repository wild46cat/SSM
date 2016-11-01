package systemManagement;

import com.xueyou.ssm.dao.UserDao;
import com.xueyou.ssm.model.User;
import com.xueyou.ssm.service.FirstService;
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

import static org.mockito.Mockito.*;

/**
 * Created by wuxueyou on 16/10/25.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-mvc/springmvc-servlet.xml",
        "file:src/main/webapp/WEB-INF/spring-mvc/datasource.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UserTest {


    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;


    @Test
    public void userList(){
        Map<String,Object> params = new HashMap<>();
        Map<String,Object> resMap = userService.userList(params);
        for (String s : resMap.keySet()) {
            System.out.println(s + "  " + resMap.get(s));
        }
        Assert.assertEquals(2, Integer.parseInt(resMap.get("count").toString()));
    }

    @Test
    public void getUser(){
        Map<String,Object> params = new HashMap<>();
        List<User> userlist = userDao.userList(params);
        for (User user : userlist) {
            System.out.println(user.getName());
        }
        Assert.assertEquals(2,userlist.size());
    }
}

