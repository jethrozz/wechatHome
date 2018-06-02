package com.wechat.controller;

import com.wechat.service.WechatService;
import com.wechat.util.SignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zxc on 2018/2/19.
 */
@Controller
@RequestMapping("/wechat")
@PropertySource(value = {"classpath:wechat.properties"})
public class WeChatController {
	@Value("${wechat.token}")
	private String TOKEN;
	@Value("${wechat.appID}")
	private String appId;
	@Value("${wechat.appsecret}")
	private String appSecret;




	@Autowired
	WechatService wechatService;


	@GetMapping(value = "/connect")
	@ResponseBody
	public String connectWeixin(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr){
		//排序
		String sortString = SignUtil.sort(TOKEN, timestamp, nonce);
		//加密
		String myString = SignUtil.sha1(sortString);
		//校验
		if (myString != null && myString != "" && myString.equals(signature)) {
			System.out.println("签名校验通过");
			//如果检验成功原样返回echostr，微信服务器接收到此输出，才会确认检验完成。
			return echostr;
		} else {
			System.out.println("签名校验失败");
			return "";
		}
	}

	@PostMapping("/connect")
	@ResponseBody
	public String replyWechat(HttpServletRequest request){
		String respMessage = "异常消息！";

		try {
			respMessage = wechatService.weixinPost(request);

			System.err.println("The request completed successfully");
			System.err.println("to weixin server "+respMessage);
		} catch (Exception e) {
			System.err.println("Failed to convert the message from weixin!");
		}
		return respMessage;
	}

	@RequestMapping("/auth")
	public ModelAndView auth2_0(HttpServletRequest request , HttpServletResponse response, int type){
		ModelAndView modelAndView = new ModelAndView();
		String authUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base#wechat_redirect";
		String url = "redirect:";
		authUrl = authUrl.replace("APPID",appId);
		if(type == 0){
			//学生
			String backurl = "http://iwonderhow.s1.natapp.cc/index/student";
			authUrl = authUrl.replace("REDIRECT_URI",backurl);
		}else if(type == 1){
			//家长
			String backurl = "http://iwonderhow.s1.natapp.cc/index/parent";
			authUrl = authUrl.replace("REDIRECT_URI",backurl);
		}else if(type == 2){
			//教师
		}
		url = url + authUrl;
		modelAndView.setViewName(url);
		return modelAndView;
	}
}
