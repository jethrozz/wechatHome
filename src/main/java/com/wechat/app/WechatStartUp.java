package com.wechat.app;

import com.wechat.util.NoticeTemplatePush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zxc on 2018/6/1.
 */
@Component
public class WechatStartUp implements CommandLineRunner {

	@Autowired
	private NoticeTemplatePush noticeTemplatePush;


	@Override
	public void run(String... args) throws Exception {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
		fixedThreadPool.submit(noticeTemplatePush);
	}
}
