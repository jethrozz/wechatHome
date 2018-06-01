package com.wechat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/lay")
public class LayUIComtroller {

	@RequestMapping("/newClass")
	public ModelAndView newClass(){
		ModelAndView modelAndView = new ModelAndView("/newClass");
		return modelAndView;
	}
	@RequestMapping("/chat")
	public ModelAndView chat(){
		ModelAndView modelAndView = new ModelAndView("/chat");
		return modelAndView;
	}
	@RequestMapping("/teacherChat")
	public ModelAndView teacherChat(){
		ModelAndView modelAndView = new ModelAndView("/teacherChat");
		return modelAndView;
	}
	@RequestMapping("/classInfo")
	public ModelAndView classInfo(){
		ModelAndView modelAndView = new ModelAndView("classInfo");
		return modelAndView;
	}

	@RequestMapping("homework_add")
	public ModelAndView homework_add(){
		ModelAndView modelAndView = new ModelAndView("homework_add");
		return modelAndView;
	}

	@RequestMapping("homework_all")
	public ModelAndView homework_all(){
		ModelAndView modelAndView = new ModelAndView("homework_all");
		return modelAndView;
	}

	@RequestMapping("notice_all")
	public ModelAndView notice_all(){
		ModelAndView modelAndView = new ModelAndView("notice_all");
		return modelAndView;
	}

	@RequestMapping("notice_add")
	public ModelAndView notice_add(){
		ModelAndView modelAndView = new ModelAndView("notice_add");
		return modelAndView;
	}

	@RequestMapping("attendance")
	public ModelAndView attendance(){
		ModelAndView modelAndView = new ModelAndView("attendance");
		return modelAndView;
	}

	@RequestMapping("leave_record")
	public ModelAndView leave_record(){
		ModelAndView modelAndView = new ModelAndView("leave_record");
		return modelAndView;
	}

	@RequestMapping("score_all")
	public ModelAndView score_all(){
		ModelAndView modelAndView = new ModelAndView("score_all");
		return modelAndView;
	}

	@RequestMapping("score_add")
	public ModelAndView score_add(){
		ModelAndView modelAndView = new ModelAndView("score_add");
		return modelAndView;
	}

	@RequestMapping("score_batchAdd")
	public ModelAndView score_batchAdd(){
		ModelAndView modelAndView = new ModelAndView("score_batchAdd");
		return modelAndView;
	}



}
