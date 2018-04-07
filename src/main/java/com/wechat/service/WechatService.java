package com.wechat.service;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by zxc on 2018/2/19.
 */
public interface WechatService {
	String weixinPost(HttpServletRequest request);
}
