package com.wechat.controller;

import com.wechat.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 */

@Controller
@RequestMapping("/parent")
public class ParentController {

	@RequestMapping("/index")
	public ModelAndView parentIndex(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("parent");
		Parent parent = (Parent) request.getSession().getAttribute("user");
		StudentParent studentParent = new StudentParent();
		Student student = new Student();
		List<StudentParent> list = studentParent.selectList("par_id");
		if(list != null){
			student = student.selectById(list.get(0).getStuId());
		}
		modelAndView.addObject("parent",parent);
		modelAndView.addObject("student",parent);
		Classes classes = new Classes();
		classes = classes.selectById(student.getClaId());
		modelAndView.addObject("classes",classes);
		Teacher headMaster = new Teacher();
		headMaster = headMaster.selectById(classes.getTeacher());
		modelAndView.addObject("headMaster",headMaster);

		return modelAndView;

	}

}
