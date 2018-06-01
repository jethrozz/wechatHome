package com.wechat.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wechat.dao.ClassesDao;
import com.wechat.dao.NoticeBulletinDao;
import com.wechat.dao.TeacherDao;
import com.wechat.entity.*;
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
	@Autowired
	NoticeBulletinDao noticeDao;
	@Autowired
	ClassesDao classesDao;
	@Override
	public List<Student> getStudentByCid(Integer cid) {
		return null;
	}

	@Override
	public Teacher isTeacher(Teacher teacher) {
		return teacherDao.selectByPrimaryKey(teacher.getId());
	}

	@Override
	public Classes getClassByTeacherId(Teacher teacher) {
		ClassesExample example = new ClassesExample();
		example.or().andTeacherEqualTo(teacher.getId());
		List<Classes> list = classesDao.selectByExample(example);
		if(list != null && list.size() != 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Page<Map<String,Object>> getNotice(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		return teacherDao.selectNoticeByPage();
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
