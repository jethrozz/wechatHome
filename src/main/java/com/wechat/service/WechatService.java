package com.wechat.service;

import com.wechat.model.Menu;
import org.json.JSONException;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by zxc on 2018/2/19.
 */
public interface WechatService {
	String weixinPost(HttpServletRequest request);

}
