package com.wechat.controller;

import com.wechat.service.WechatService;
import com.wechat.util.SignUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
	@Resource
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
}
