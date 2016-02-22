package org.smart4j.framework.demo;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by ivantan on 16/2/22.
 */
public class HelloBeforeAdvice implements MethodBeforeAdvice{

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("BeforeAdvice");
    }
}
