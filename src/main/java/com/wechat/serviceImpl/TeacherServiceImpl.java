package com.wechat.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wechat.dao.*;
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

	@Autowired
	ExamResultDao examResultDao;
	@Autowired
	LeaveRecordDao leaveRecordDao;
	@Autowired
	HomeworkDao homeworkDao;

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
	public Teacher CheckLoginTeacher(String teacherId, String password) {
		Teacher teacher = teacherDao.selectByPrimaryteacherId(teacherId);
		if (teacher != null){
			if (teacher.getPassword().equals(password)){
				return teacher;
			}
			return null;
		}
		return null;
	}

	@Override
	public Page<Map<String, Object>> getExamResult(int teaId, int pageNo, int pageSize) {
		Page<Map<String, Object>> page =  PageHelper.startPage(pageNo,pageSize);
		Page<Map<String, Object>> result = examResultDao.getTeacherClassExamResult(teaId);
		result.setTotal(page.getTotal());
		return result;
	}

	@Override
	public Page<Map<String, Object>> getLeaverRecord(int teaId, int pageNo, int pageSize) {
		Page<Map<String, Object>> page =  PageHelper.startPage(pageNo,pageSize);

		Page<Map<String, Object>> result = leaveRecordDao.getTeacherLeaveList(teaId);
		result.setTotal(page.getTotal());
		return result;
	}

	@Override
	public Page<Map<String, Object>> getHomework(int teaId, int pageNo, int pageSize) {
		Page<Map<String, Object>> page =  PageHelper.startPage(pageNo,pageSize);
		Page<Map<String, Object>> result = homeworkDao.getHomeworkTeacher(teaId);
		result.setTotal(page.getTotal());
		return result;
	}
}
