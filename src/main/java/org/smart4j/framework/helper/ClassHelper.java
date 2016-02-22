package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 类操作助手类
 * Created by ivantan on 16/2/22.
 */
public class ClassHelper {
    /**
     * 存放所加载的类
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包名下所有类
     *
     * @return
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * 获取应用包名下所有Service类
     *
     * @return
     */
    public static Set<Class<?>> getServiceClassSet() {
        return getClassSetWithAnnotation(Service.class);
    }

    /**
     * 获取应用包名下所有Controller类
     *
     * @return
     */
    public static Set<Class<?>> getControllerClassSet() {
        return getClassSetWithAnnotation(Controller.class);
    }

    /**
     * 获取应用包名下所有Bean类(Service+Controller)
     *
     * @return
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        classSet.addAll(getClassSetWithAnnotation(Controller.class));
        classSet.addAll(getClassSetWithAnnotation(Service.class));
        return classSet;
    }

    /**
     * 获取应用包名下具有某个注解的类
     *
     * @param annotationClass
     * @return
     */
    private static Set<Class<?>> getClassSetWithAnnotation(Class<? extends Annotation> annotationClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> clz : CLASS_SET) {
            if (clz.isAnnotationPresent(annotationClass)) {
                classSet.add(clz);
            }
        }
        return classSet;
    }


}
