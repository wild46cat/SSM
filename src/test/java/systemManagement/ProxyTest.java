package systemManagement;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wuxueyou on 2016/11/14.
 */
public class ProxyTest implements HelloService {

    @Test
    public void normalClasstest() {
        this.sayHello("cc");
    }

    public void sayHello(String name) {
        System.out.println(name);
    }

    @Test
    public void jdkProxyTest() {
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
        HelloService helloService = (HelloService) helloServiceProxy.bind(new ProxyTest());
        helloService.sayHello("xixi");
    }

    @Test
    public void cglibProxyTest() {
        HelloServiceCglib helloServiceCglib = new HelloServiceCglib();
        ProxyTest proxyTest = (ProxyTest)helloServiceCglib.getInstance(new ProxyTest());
        proxyTest.sayHello("lalala");
    }

}

class HelloServiceProxy implements InvocationHandler {
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理");
        Object result = null;
        System.out.println("before method");
        result = method.invoke(target, args);
        System.out.println("after method");
        return result;
    }
}

class HelloServiceCglib implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB 代理");
        System.out.println("before method running");
        Object returnObj = methodProxy.invokeSuper(o, objects);
        System.out.println("after method running");
        return returnObj;
    }
}

interface HelloService {
    public void sayHello(String name);
}
