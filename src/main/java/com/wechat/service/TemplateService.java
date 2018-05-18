package com.wechat.service;

import com.wechat.model.Template;

/**
 * Created by zxc on 2018/5/10.
 */
public interface TemplateService {
	boolean sendTemplateMsg(String token,Template template);
}
