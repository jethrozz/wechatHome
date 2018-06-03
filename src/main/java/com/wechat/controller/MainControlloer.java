package com.wechat.controller;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.sun.xml.internal.bind.v2.TODO;
import com.wechat.entity.*;
import com.wechat.util.HttpUtil;
import com.wechat.util.WechatUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zxc on 2018/5/30.
 * 页面路径映射
 */
@Controller
@RequestMapping("/index")
@PropertySource(value = {"classpath:wechat.properties"})
public class MainControlloer {

	@Value("${wechat.appID}")
	private String appId;
	@Value("${wechat.appsecret}")
	private String appSecret;
	@Value("${wechat.authUrlCode}")
	private String authUrlCode;

	@RequestMapping("/quit")
	public ModelAndView quit(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("redirect:/index/login");
		request.getSession().invalidate();
		return modelAndView;
	}

	@RequestMapping("/student")
	public ModelAndView student(HttpServletRequest request, HttpServletResponse response,@RequestParam("code") String code){
		ModelAndView modelAndView = new ModelAndView();
		Student student = new Student();
		String openId = WechatUtil.getOpenid(authUrlCode,appId,appSecret,code);
		student = student.selectOne("openId = {0}",openId);

		if(student == null){
			modelAndView.setViewName("user_login");
		}else{
			request.getSession().setAttribute("user",student);
			modelAndView.setViewName("/student/index");
		}
		modelAndView.addObject("openId",openId);

		return modelAndView;
	}


	@RequestMapping("/parent")
	public ModelAndView parent(HttpServletRequest request, HttpServletResponse response,@RequestParam("code") String code){
		ModelAndView modelAndView = new ModelAndView();
		Parent parent = new Parent();

		String openId = WechatUtil.getOpenid(authUrlCode,appId,appSecret,code);
		parent = parent.selectOne("openId = {0}",openId);

		if(parent == null){
			modelAndView.setViewName("parent_login");
		}else{
			request.getSession().setAttribute("user",parent);
			modelAndView.setViewName("/parent/index");
		}

		modelAndView.addObject("openId",openId);
		return modelAndView;
	}

	@RequestMapping("/notice/{id}")
	public ModelAndView getNotice(@PathVariable int id){
		ModelAndView modelAndView = new ModelAndView("/notice");
		NoticeBulletin noticeBulletin = new NoticeBulletin();
		noticeBulletin = noticeBulletin.selectById(id);
		Teacher teacher = new Teacher();
		teacher = teacher.selectById(noticeBulletin.getTeaId());
		modelAndView.addObject("notice",noticeBulletin);
		modelAndView.addObject("teacher",teacher);

		return modelAndView;
	}

	@RequestMapping("/main")
	public ModelAndView intoIndex(HttpServletRequest request){
		Teacher teacher = (Teacher)request.getSession().getAttribute("user");
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("teacher",teacher);
		modelAndView.setViewName("/index");
		return modelAndView;
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("/login");
		return modelAndView;
	}

}
