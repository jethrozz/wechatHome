package com.wechat.util;

import com.wechat.model.Template;
import com.wechat.model.TemplateParam;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Date;

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

	public static Template getTemplate(String toUser,String id,String color,String url,String[] value){
		Template template = new Template();
		template.setToUser(toUser);
		template.setTemplateId(id);
		template.setTopColor(color);
		template.setUrl(url);
		ArrayList<TemplateParam> list = new ArrayList<TemplateParam>();
		int index = 1;
		for(String val : value){
			TemplateParam p = new TemplateParam("keyword"+index,val,"#0000ff");
			list.add(p);
			index++;
		}
		template.setTemplateParamList(list);

		return template;
	}
}
