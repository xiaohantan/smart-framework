package org.smart4j.framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 视图对象
 * Created by ivantan on 16/2/22.
 */
public class View {
    /**
     * 视图路径
     */
    private String path;
    /**
     * 模型数据,可以在视图中根据模型的键名获取键值
     */
    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        model = new HashMap<String, Object>();
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
