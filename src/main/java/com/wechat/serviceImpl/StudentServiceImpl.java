package com.wechat.serviceImpl;

import com.wechat.bean.MyClass;
import com.wechat.common.constat.tips.ErrorTip;
import com.wechat.dao.*;
import com.wechat.entity.*;
import com.wechat.exception.BizExceptionEnum;
import com.wechat.exception.BussinessException;
import com.wechat.service.StudentService;
import com.wechat.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @时间: 2018/4/16
 * @描述：
 */
@Service("StudentService")
public class StudentServiceImpl implements StudentService {

    private static int code = -1;

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ClassesDao classDao;
    @Autowired
    private ExamResultDao examResultDao;
    @Autowired
    private HomeworkDao homeworkDao;
    @Autowired
    private TeacherClassDao teacherClassDao;
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public boolean updateStudent(Student student) {
        if(studentDao.updateByPrimaryKeySelective(student) >= 1){
            return true;
        }
        return false;
    }

    @Override
    public Student isStudent(Student student) {
        return null;
    }

    @Override
    public Student getStudentInfo(Integer sId) {
        return studentDao.selectByPrimaryKey(sId);
    }

    @Override
    public Student getStudentInfoByStudentNumber(String studentNumber) {
        StudentExample example = new StudentExample();
        example.or().andStudentNumberEqualTo(studentNumber);
        List<Student> list = studentDao.selectByExample(example);
        if(list != null && list.size() != 0){
            return list.get(0);
        }
        return null;
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

    @Override
    public Student CheckLoginStudent(String studentNumber, String password){

        Student student = studentDao.selectByPrimaryStudentNumber(studentNumber);
        if (student != null){
            if (password.equals(student.getPassword())){
                return  student;
            }
            return null;
        }
        return null;
    }

    @Override
    public Student CheckLoginParent(String studentNumber, String identityNumber) {

        Student student = studentDao.selectByPrimaryStudentNumber(studentNumber);
        if (student != null){
            if (student.getIdentityNumber().equals(identityNumber)){
                return student;
            }
            return null;
        }
        return null;
    }
}
