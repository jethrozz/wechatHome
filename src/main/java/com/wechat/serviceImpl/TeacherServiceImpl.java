package com.wechat.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wechat.dao.TeacherDao;
import com.wechat.entity.Student;
import com.wechat.entity.Teacher;
import com.wechat.exception.BizExceptionEnum;
import com.wechat.exception.BussinessException;
import com.wechat.mapper.TeacherMapper;
import com.wechat.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zxc on 2018/5/17.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherDao teacherDao;
	@Autowired
	TeacherMapper teacherMapper;
	@Override
	public List<Student> getStudentByCid(Integer cid) {
		return null;
	}

	@Override
	public Teacher isTeacher(Teacher teacher) {
		return teacherDao.selectByPrimaryKey(teacher.getId());
	}

	@Override
	public Map<String, Object> CheckLoginTeacher(String teacherId, String password) {
		Map<String, Object> teacher = teacherDao.selectByPrimaryteacherId(teacherId);
		if (teacher != null){
			if (teacher.get("password").equals(password)){
				return teacher;
			}
			return null;
		}
		return null;
	}
}
