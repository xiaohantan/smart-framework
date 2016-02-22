package org.smart4j.framework.util;

import java.io.FileInputStream;
import java.util.Observable;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.concurrent.Exchanger;

/**
 * Created by ivantan on 16/2/19.
 */
public class PropsUtil {
    public static final Properties loadProps(String file) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static final String getString(Properties properties, String key) {
        if (properties != null) {
            Object value = properties.get(key);
            if (value != null) {
                return (String) value;
            }
        }
        return  null;
    }
    public static final String getString(Properties properties, String key,String defaultValue) {
        if (properties != null) {
            Object value = properties.get(key);
            if (value != null) {
                return (String) value;
            }
        }
        return  defaultValue;
    }
}
