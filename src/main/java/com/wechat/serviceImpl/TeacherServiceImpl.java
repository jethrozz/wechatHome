package com.wechat.serviceImpl;

import com.wechat.dao.TeacherMapper;
import com.wechat.entity.Student;
import com.wechat.entity.Teacher;
import com.wechat.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zxc on 2018/5/17.
 */
@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	TeacherMapper teacherMapper;

	@Override
	public List<Student> getStudentByCid(Integer cid) {
		return null;
	}

	@Override
	public Teacher isTeacher(Teacher teacher) {
		return null;
	}
}
