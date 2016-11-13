package systemManagement;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * Created by wuxueyou on 2016/11/13.
 */
public class ReflectTest {
    public void say(int param1, String param2) {
        System.out.println(param1);
        System.out.println(param2);
    }

    @Test
    public void tt() throws IllegalAccessException, InstantiationException, ClassNotFoundException,
            InvocationTargetException, NoSuchMethodException {
        Object service = Class.forName(ReflectTest.class.getName()).newInstance();
        Method method = service.getClass().getMethod("say", int.class, String.class);
        method.invoke(service, 15, "abcd");

    }
}
