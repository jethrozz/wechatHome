package com.wechat.serviceImpl;

import com.wechat.bean.MyClass;
import com.wechat.dao.*;
import com.wechat.entity.*;
import com.wechat.entity.Class;
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
    private ClassMapper classDao;
    @Autowired
    private ExamResultMapper examResultDao;
    @Autowired
    private HomeworkMapper homeworkDao;
    @Autowired
    private TeacherClassMapper teacherClassDao;
    @Autowired
    private TeacherMapper teacherDao;

    @Override
    public Student getStudentInfo(Integer sId) {
        return studentDao.selectByPrimaryKey(sId);
    }

    @Override
    public List<Homework> getTodayHomeWork(Student student) {
        HomeworkExample homeworkExample = new HomeworkExample();
        homeworkExample.or().andH_classEqualTo(student.getC_id()).andH_create_timeEqualTo(new Date());
        return homeworkDao.selectByExample(homeworkExample);
    }

    @Override
    public List<ExamResult> getScoreBySid(Student student) {
        ExamResultExample examResultExample = new ExamResultExample();
        examResultExample.or().andEr_studentEqualTo(student.getS_id());
        examResultExample.setOrderByClause("er_create_time");
        return examResultDao.selectByExample(examResultExample);
    }

    @Override
    public MyClass getClassByCid(Student student) {
        MyClass myClass = new MyClass();
        //获取这个学生的班级
        Class c = classDao.selectByPrimaryKey(student.getC_id());
        TeacherClassExample teacherClassExample = new TeacherClassExample();
        teacherClassExample.or().andC_idEqualTo(c.getC_id());
        List<Teacher>

        return myClass;
    }
}
