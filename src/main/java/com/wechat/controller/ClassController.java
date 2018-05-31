package com.wechat.controller;

import com.wechat.bean.StudentSelectTree;
import com.wechat.common.controller.BaseController;
import com.wechat.entity.Classes;
import com.wechat.entity.Student;
import com.wechat.entity.TeacherClass;
import com.wechat.model.CommonResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxc on 2018/5/31.
 */
@RestController
@RequestMapping("/class")
@Transactional
public class ClassController extends BaseController {

	//上传单个学生成绩时需要用到的节点树
	@GetMapping("/allClass")
	public List<StudentSelectTree> allClass(HttpServletRequest request){
		List<StudentSelectTree> list = new ArrayList<>();
		Classes classes = new Classes();

		List<Classes> classesList = classes.selectAll();
		Student student = new Student();
		for (Classes c : classesList){
			StudentSelectTree selectTree = new StudentSelectTree();
			//父节点，班级id以及班级名称
			selectTree.setId(c.getId());
			selectTree.setName(c.getGradeName()+"年级"+c.getClassName()+"班");
			List<Student> studentList = student.selectList("cla_id = {0}",c.getId());
			selectTree.setParent(false);

			if(studentList.size() != 0){
				selectTree.setParent(true);
				List<StudentSelectTree> selectTrees = new ArrayList<>();
				for(Student s:studentList){
					StudentSelectTree tree = new StudentSelectTree();
					//子节点，该班学生以及学生id
					tree.setName(s.getName());
					tree.setId(s.getId());
					selectTrees.add(tree);
				}
				selectTree.setChildren(selectTrees);
			}
			list.add(selectTree);
		}
		return list;
	}

	//发布作业时要用到该教师的所教班级的接口
	@GetMapping("/getClassByTid")
	public List<StudentSelectTree> getClassByTid(HttpServletRequest request,int tid){
		List<StudentSelectTree> list = new ArrayList<>();
		Classes classes = new Classes();
		TeacherClass teacherClass = new TeacherClass();
		List<TeacherClass> classesList = teacherClass.selectList("tea_id = {0}",tid);

		for (TeacherClass c : classesList){
			StudentSelectTree selectTree = new StudentSelectTree();
			//父节点，班级id以及班级名称
			classes = classes.selectById(c.getClaId());
			selectTree.setId(classes.getId());
			selectTree.setName(classes.getGradeName()+"年级"+classes.getClassName()+"班");
			selectTree.setParent(false);
			list.add(selectTree);
		}
		return list;
	}

}
