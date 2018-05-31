package com.wechat.config;

import com.wechat.util.NoticeTemplatePush;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zxc on 2018/6/1.
 */
@Configuration
public class PushConfig {
	@Bean
	public NoticeTemplatePush noticeTemplatePush(){
		return new NoticeTemplatePush();
	}
}
