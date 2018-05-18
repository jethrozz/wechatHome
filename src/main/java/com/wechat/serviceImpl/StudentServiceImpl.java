package com.wechat.serviceImpl;

import com.wechat.bean.MyClass;
import com.wechat.dao.*;
import com.wechat.entity.*;
import com.wechat.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @时间: 2018/4/16
 * @描述：
 */
@Service("StudentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentDao;
    @Autowired
    private ClassesMapper classDao;
    @Autowired
    private ExamResultMapper examResultDao;
    @Autowired
    private HomeworkMapper homeworkDao;
    @Autowired
    private TeacherClassMapper teacherClassDao;
    @Autowired
    private TeacherMapper teacherDao;

    @Override
    public Student isStudent(Student student) {
        return null;
    }

    @Override
    public Student getStudentInfo(Integer sId) {
        return studentDao.selectByPrimaryKey(sId);
    }

    @Override
    public List<Homework> getTodayHomeWork(Student student) {
        HomeworkExample homeworkExample = new HomeworkExample();
        homeworkExample.or().andClaIdEqualTo(student.getClaId()).andHCreateTimeEqualTo(new Date());
        return homeworkDao.selectByExample(homeworkExample);
    }

    @Override
    public List<ExamResult> getScoreBySid(Student student) {
        ExamResultExample examResultExample = new ExamResultExample();
        examResultExample.or().andStuIdEqualTo(student.getId());
        examResultExample.setOrderByClause("er_create_time");
        return examResultDao.selectByExample(examResultExample);
    }

    @Override
    public MyClass getClassByCid(Student student) {
        MyClass myClass = new MyClass();
        //获取这个学生的班级
        Classes c = classDao.selectByPrimaryKey(student.getClaId());
        TeacherClassExample teacherClassExample = new TeacherClassExample();
        teacherClassExample.or().andClaIdEqualTo(c.getId());
        //List<Teacher>

        return myClass;
    }
}
