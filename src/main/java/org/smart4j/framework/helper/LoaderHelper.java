package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.util.ClassUtil;

/**
 * 加载Helper类
 * Created by ivantan on 16/2/22.
 */
public class LoaderHelper {
    public static void init() {
        Class<?>[] classArray = {ClassHelper.class, BeanHelper.class, IocHelper.class, Controller.class};
        for (Class<?> cls : classArray) {
            ClassUtil.loadClass(cls.getName(), false);
        }
    }
}
