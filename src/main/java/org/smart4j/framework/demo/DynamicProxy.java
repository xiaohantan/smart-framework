package org.smart4j.framework.demo;

import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ivantan on 16/2/22.
 */
public class DynamicProxy implements InvocationHandler {
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
//        Hello hello = new HelloImpl();
//        DynamicProxy dynamicProxy = new DynamicProxy(hello);
//        Hello helloProxy = dynamicProxy.getProxy();
//        helloProxy.sayHello("Tommy");

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new HelloImpl());
        proxyFactory.addAdvice(new HelloBeforeAdvice());
        proxyFactory.addAdvice(new MethodAfterAdvice());
        Hello hello = (Hello) proxyFactory.getProxy();
        hello.sayHello("zhangsan");

    }

}
