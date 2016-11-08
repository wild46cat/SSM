package systemManagement;

import com.xueyou.ssm.dao.FirstDao;
import com.xueyou.ssm.model.Ttee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;



/**
 * Created by wuxueyou on 16/10/25.
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-mvc/springmvc-servlet.xml",
        "file:src/main/webapp/WEB-INF/spring-mvc/datasource.xml"})
//@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class PrimaryTest {



    @Autowired
    FirstDao firstDao;

    @Test
    public void getUser(){
        Ttee ttee = new Ttee();
        ttee.setId("abc201611080002");
        ttee.setName("cckk");
        int res = firstDao.inserttestTable(ttee);
        Assert.assertEquals(1,res);
    }
}

