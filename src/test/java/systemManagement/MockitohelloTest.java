package systemManagement;

import com.xueyou.ssm.service.FirstService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.*;

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
public class MockitohelloTest {

    public List<String> mockannotationList;
    @Test
    public void simpleTest(){
        List<String> mockList = mock(List.class);
        mockList.add("one");
        mockList.add("one");
        mockList.add("one");
        mockList.clear();

        verify(mockList).clear();
        verify(mockList, atLeast(3)).add("one");
    }

    @Autowired
    FirstService firstService;

    @Test
    public void FirstModelTest(){
        Map<String,Object> params = new HashMap<>();
        Map<String,Object> resMap = firstService.getJson(params);
        for (String s : resMap.keySet()) {
            System.out.println(resMap.get(s));
        }
        Assert.assertEquals(1, resMap.get("resCode"));

   }

    @Test
//    @Transactional 由于上面进行了总体的声明,所以这里不用再次声明
//    @Rollback(true)
    public void InsertUser(){
        Map<String,Object> params = new HashMap<>();
        Map<String,Object> resMap = firstService.insertUser(params);
        Assert.assertEquals(1, resMap.get("resCode"));
    }

}

