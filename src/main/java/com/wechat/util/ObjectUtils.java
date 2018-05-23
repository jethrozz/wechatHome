package com.wechat.util;

import com.wechat.common.constat.tips.ErrorTip;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectUtils {

    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        System.out.println("ss ---> "+clazz);
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            System.out.println("-->"+fieldName);
            Object value = field.get(obj);
            map.put(fieldName, value);
        }
        return map;
    }
}
