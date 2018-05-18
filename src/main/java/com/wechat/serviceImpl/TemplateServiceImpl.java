package com.wechat.serviceImpl;

import com.wechat.model.Template;
import com.wechat.service.TemplateService;
import com.wechat.util.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.wechat.util.HttpUtil.httpRequest;

/**
 * Created by zxc on 2018/5/10.
 */
@Service
public class TemplateServiceImpl implements TemplateService {
	private static Logger log = LoggerFactory.getLogger(TemplateServiceImpl.class);
	@Value("${wechat.templateUrl}")
	private String templateUrl;

	@Override
	public boolean sendTemplateMsg(String token, Template template) {
		boolean flag=false;

		String url = templateUrl.replace("ACCESS_TOKEN", token);
		JSONObject jsonResult= httpRequest(url, "POST", template.toJSON());


		if(jsonResult!=null){
			int errorCode= 0;
			try {
				errorCode = jsonResult.getInt("errcode");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			String errorMessage= null;
			try {
				errorMessage = jsonResult.getString("errmsg");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			if(errorCode==0){
				flag=true;
			}else{
				System.out.println("模板消息发送失败:"+errorCode+","+errorMessage);
				flag=false;
			}
		}
		return flag;
	}
}
