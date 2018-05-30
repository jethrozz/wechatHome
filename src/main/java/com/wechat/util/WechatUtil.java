package com.wechat.util;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.PropertySource;

/**
 */
public class WechatUtil {

	//网页授权，根据code获取用户openId
	public static String getOpenid(String authUrlCode,String appId,String appSecret,String code){
		String openId = "";
		String codeUrl = authUrlCode.replace("APPID",appId).replace("SECRET",appSecret).replace("CODE",code);
		JSONObject jsonObject = HttpUtil.httpRequest(codeUrl,"GET",null);
		try {
			openId = jsonObject.getString("openid");

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return openId;
	}
}
