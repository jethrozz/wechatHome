package com.wechat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Created by zxc on 2018/2/15.
 */
@Configuration
@ComponentScan("com.wechat.controller")
public class SpringmvcConfig {

//	@Bean
//	public MultipartResolver multipartResolver(){
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//		multipartResolver.setMaxUploadSize(1000000);
//		return multipartResolver;
//	}

}
