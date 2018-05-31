package com.wechat.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @作者: jethro
 * @时间: 2018/4/9
 * @描述：
 */
public class JSONUtils {
    static private ObjectMapper objectMapper = new ObjectMapper();
    private static Logger log = LoggerFactory.getLogger(JSONUtils.class);

    /**
     * 读取json的值
     *
     * @param key
     * @param valueType
     * @return
     */
    static public <T> T readValue(String key, Class<T> valueType) {
        try {
            return objectMapper.readValue(key, valueType);
        } catch (IOException e) {
            log.error(JSONUtils.throwAbleToString(e));
        }

        return null;
    }

    /**
     * 把对象转为json
     *
     * @param object
     * @return
     */
    static public String toJson(Object object) {
//        try {
//            return objectMapper.writeValueAsString(object);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//            log.error(e.getStackTrace().toString());
//
//        }
//        return null;
        return JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
    }

    static public String throwAbleToString(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }
}
