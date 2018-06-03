package com.wechat.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wechat.bean.MyClass;
import com.wechat.entity.Classes;
import com.wechat.entity.Student;
import com.wechat.entity.Teacher;
import com.wechat.entity.TeacherClass;
import com.wechat.model.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
	public ModelAndView classInfo(HttpServletRequest request){
		Teacher tea = (Teacher)request.getSession().getAttribute("user");
		ModelAndView modelAndView = new ModelAndView("classInfo");
		MyClass myClass = new MyClass();

		Classes classes = new Classes();
		Teacher teacher = new Teacher();
		Student student = new Student();
		TeacherClass teacherClass = new TeacherClass();
		EntityWrapper<Classes> ew = new EntityWrapper<>();
		ew.where("teacher = {0}",tea.getId());
		List<Classes> classesList = classes.selectList(ew);
		if(classesList.size()!= 0){
			//设置该教师的班级信息
			myClass.setMyclass(classesList.get(0));
			teacher = teacher.selectById(myClass.getMyclass().getTeacher());
			//设置该班班主任
			myClass.setHeadMaster(teacher);
			//设置该班学生
			myClass.setStudentList(student.selectList("cla_id = {0}",myClass.getMyclass().getId()));

			//封装该班教师
			List<Teacher> teachers = new ArrayList<>();
			List<TeacherClass> teacherClasses = teacherClass.selectList("cla_id = {0}",myClass.getMyclass().getId());
			for(TeacherClass t : teacherClasses){
				teachers.add(teacher.selectById(t.getTeaId()));
			}
			myClass.setTeacherList(teachers);

		}
		modelAndView.addObject("myClass",myClass);
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
