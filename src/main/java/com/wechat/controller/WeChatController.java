package com.wechat.controller;

import com.wechat.service.WechatService;
import com.wechat.util.SignUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@Value("${token}")
	private String TOKEN;
	@Resource
	WechatService wechatService;
	/**
	 * 微信接入
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/connect",method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public void connectWeixin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");  //微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
		response.setCharacterEncoding("UTF-8"); //在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
		boolean isGet = request.getMethod().toLowerCase().equals("get");//获取消息类型 get/post
		//get请求是微信的验证请求，post请求才是服务请求
		PrintWriter out = response.getWriter();

		try {
			if (isGet) {
				String signature = request.getParameter("signature");// 微信加密签名
				String timestamp = request.getParameter("timestamp");// 时间戳
				String nonce = request.getParameter("nonce");// 随机数
				String echostr = request.getParameter("echostr");//随机字符串

				// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
				if (SignUtil.checkSignature(TOKEN, signature, timestamp, nonce)) {
					System.err.println("Connect the weixin server is successful.");
					response.getWriter().write(echostr);
			} else {
					System.err.println("Failed to verify the signature!");
			}
		}else{
			String respMessage = "异常消息！";

			try {
				respMessage = wechatService.weixinPost(request);
				out.write(respMessage);
				System.err.println("The request completed successfully");
				System.err.println("to weixin server "+respMessage);
			} catch (Exception e) {
				System.err.println("Failed to convert the message from weixin!");
			}

		}
	} catch (Exception e) {
			System.err.println("Connect the weixin server is error.");
	}finally{
		out.close();
	}
}
}
