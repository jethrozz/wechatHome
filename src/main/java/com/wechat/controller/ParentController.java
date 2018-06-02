package com.wechat.controller;

import com.wechat.common.controller.BaseController;
import com.wechat.dao.ParentDao;
import com.wechat.entity.*;
import com.wechat.mapper.LeaveRecordMapper;
import com.wechat.model.CommonResult;
import com.wechat.util.HttpUtil;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultManagedHttpClientConnection;
import org.apache.http.protocol.HttpContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */

@Controller
@RequestMapping("/parent")
public class ParentController extends BaseController{

	@Autowired
	private LeaveRecordMapper leaveRecordMapper;

	@Autowired
	private ParentDao parentDao;

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
		modelAndView.addObject("student",student);
		Classes classes = new Classes();
		classes = classes.selectById(student.getClaId());
		modelAndView.addObject("classes",classes);
		Teacher headMaster = new Teacher();
		headMaster = headMaster.selectById(classes.getTeacher());
		modelAndView.addObject("headMaster",headMaster);

		return modelAndView;

	}

	/**
	 * 请假 leave_record
	 * @param leaveRecord
	 * @return
	 */
	@RequestMapping(value = "/leave_record",method = RequestMethod.POST)
	public CommonResult leave_record(@RequestBody(required = false) LeaveRecord leaveRecord){

		int s = leaveRecordMapper.insertAllColumn(leaveRecord);
		if (s==1){
			//查询学生教师的openid
			Parent parent = (Parent) request.getSession().getAttribute("user");
			Map<String, Object> m = parentDao.getMyStudentTeacherOpenId(parent.getId());
//			for (Map.Entry<String, Object> entry : m.entrySet()) {
//				System.out.println(entry.getKey()+"---->"+entry.getValue());
//			};
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("studentName",m.get("name"));
			map.put("reason",leaveRecord.getReason());
			map.put("dayNum",leaveRecord.getTime());
			map.put("teacherOpenId",m.get("openId").toString());

			String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
			url += "/chat/sendCheckMsg";
			HttpUtil httpUtil = new HttpUtil();
			String str = httpUtil.doPost(url,map);
			System.out.println("-->"+str);
			return new CommonResult(successcode,successMessage);
		}
		return new CommonResult(errorcode,errorMessage);
	}

}
