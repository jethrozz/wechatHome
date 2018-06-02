package com.wechat.controller;

import com.wechat.common.controller.BaseController;
import com.wechat.dao.ParentDao;
import com.wechat.entity.*;
import com.wechat.mapper.LeaveRecordMapper;
import com.wechat.model.CommonResult;
import com.wechat.model.Template;
import com.wechat.service.TemplateService;
import com.wechat.util.HttpUtil;
import com.wechat.util.TemplateId;
import com.wechat.util.WechatUtil;
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
import java.text.SimpleDateFormat;
import java.util.Date;
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

	@Autowired
	private TemplateService templateService;

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
		modelAndView.addObject("student",parent);
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
	@RequestMapping(value = "/leave_record",method = RequestMethod.GET)
	public CommonResult leave_record(HttpServletRequest request,LeaveRecord leaveRecord){

			//查询学生教师的openid
		Parent parent = (Parent) request.getSession().getAttribute("user");
		Map<String, Object> m = parentDao.getMyStudentTeacherOpenId(parent.getId());
		leaveRecord.setStuId((int)m.get("studentId"));
		leaveRecord.setTeaId((int)m.get("teaherId"));

		int s = leaveRecordMapper.insert(leaveRecord);
		if (s==1){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String []val =  new String[5];
			val[0] = TemplateId.LEAVE.getValue();
			val[1] = (String) m.get("name");
			val[2] = leaveRecord.getReason();
			val[3] = sdf.format(leaveRecord.getStartTime());
			val[4] = leaveRecord.getTime().toString();

			Template template = WechatUtil.getTemplate(m.get("openId").toString(),TemplateId.LEAVE.getUrl(),"#ccc","",val);
			templateService.sendTemplateMsg(template);
			return new CommonResult(successcode,successMessage);
		}
		return new CommonResult(errorcode,errorMessage);
	}

}
