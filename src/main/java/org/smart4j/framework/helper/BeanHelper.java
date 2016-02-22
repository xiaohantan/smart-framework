package org.smart4j.framework.helper;

import org.smart4j.framework.util.ReflectionUtil;
import sun.plugin.javascript.ReflectUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean助手类
 * Created by ivantan on 16/2/22.
 */
public class BeanHelper {
    /**
     * 用于存放bean类与实例的映射
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> clz : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(clz);
            BEAN_MAP.put(clz, obj);
        }
    }

    /**
     * 获取bean映射
     *
     * @return
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    /**
     * 获取Bean实例
     *
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("Can't get bean by class:" + cls);
        }
        return (T) BEAN_MAP.get(cls);
    }

}
