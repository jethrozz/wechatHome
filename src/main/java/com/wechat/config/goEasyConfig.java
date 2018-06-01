package com.wechat.config;

import io.goeasy.GoEasy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @时间: 2018/4/26
 * @描述：
 */
@Configuration
@PropertySource(value = {"classpath:wechat.properties"})
public class goEasyConfig {
    @Value("${go.appkey}")
    String appkey;
    @Value("${go.RESTHost}")
    String restHost;

    @Bean
    public GoEasy goEasy(){
        GoEasy goEasy = new GoEasy(restHost, appkey);
        return goEasy;
    }
}
