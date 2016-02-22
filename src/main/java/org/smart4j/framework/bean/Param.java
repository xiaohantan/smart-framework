package org.smart4j.framework.bean;

import java.util.Map;

/**
 * 请求参数对象
 * Created by ivantan on 16/2/22.
 */
public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public long getLong(String name, long defaultValue) {
        Object obj = paramMap.get(name);
        if (obj != null) {
            try {
                return Long.parseLong(obj.toString());
            } catch (Exception e) {

            }
        }
        return defaultValue;
    }

    public Map<String, Object> getMap() {
        return paramMap;
    }
}
