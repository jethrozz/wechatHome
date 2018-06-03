package com.wechat.controller;

import com.alibaba.fastjson.JSON;
import com.wechat.bean.*;
import com.wechat.common.controller.BaseController;
import com.wechat.dao.TeacherDao;
import com.wechat.entity.*;
import com.wechat.model.CommonResult;
import com.wechat.model.SubjectEnum;
import com.wechat.model.Template;
import com.wechat.service.TemplateService;
import com.wechat.util.TemplateId;
import com.wechat.util.WechatUtil;
import io.goeasy.GoEasy;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zxc on 2018/6/1.
 */
@RestController
@RequestMapping("/chat")
@PropertySource(value = {"classpath:wechat.properties"})
public class ChatController extends BaseController {

	@Autowired
	TemplateService templateService;
	@Autowired
	TeacherDao teacherDao;
	@Autowired
	private GoEasy goEasy;
	@Value("${teacherImg}")
	private String teacherImg;
	@Value("${studentImg}")
	private String studentImg;
	@Value("${parentImg}")
	private String parentImg;
	@Value("${wechat.href}")
	private String href;


	@RequestMapping("/teacherChatInfo")
	public LayuiBaseResult<Object> teacherChat(HttpServletRequest request){
		Teacher teacher = (Teacher)request.getSession().getAttribute("user");
		Student student = new Student();
		Parent parent = new Parent();
		TeacherClass teacherClass = new TeacherClass();


		LayuiBaseResult<Object> result = new LayuiBaseResult<>();
		result.setCode(0);
		result.setMsg("success");
		ChatUserGroup chatUserGroup = new ChatUserGroup();
		ChatUser me = new ChatUser();
		me.setStatus("online");
		me.setId(teacher.getOpenid());
		me.setUsername(teacher.getName());
		me.setAvatar(teacherImg);
		chatUserGroup.setMine(me);
		List<Friend> list = new ArrayList<>();

		List<Teacher> teachers = teacher.selectList("id != {0}",teacher.getId());
		//获取这个教师的所教班级
		List<TeacherClass> teacherClasses = teacherClass.selectList("tea_id = {0}",teacher.getId());

		for(TeacherClass t : teacherClasses){

			List<ChatUser> studentChat = new ArrayList<>();
			List<ChatUser> parentChat = new ArrayList<>();
			Friend studentFriend = new Friend();
			Friend parentFriend = new Friend();
			//遍历这个教师的所教班级

			//获得该班信息
			Classes classes = new Classes();
			classes = classes.selectById(t.getClaId());
			//查询该班所有学生
			List<Student> students = student.selectList("cla_id = {0}",classes.getId());
			parentFriend.setId(t.getClaId());
			studentFriend.setId(t.getClaId());
			studentFriend.setGroupname(classes.getGradeName()+"年级"+classes.getClassName()+"班的学生");
			parentFriend.setGroupname(classes.getGradeName()+"年级"+classes.getClassName()+"班的家长");
			StudentParent sp = new StudentParent();

			for(Student s:students){
				//该班学生
				if(StringUtils.isEmpty(s.getOpenid())){
					continue;
				}
				ChatUser chatUser = new ChatUser();
				chatUser.setId(s.getOpenid());
				chatUser.setStatus("hide");
				chatUser.setUsername(s.getName());
				chatUser.setAvatar(studentImg);
				studentChat.add(chatUser);
				List<StudentParent> studentParentList = sp.selectList("stu_id = {0}",s.getId());
				for (StudentParent sParent:studentParentList){
					parent = parent.selectById(sParent.getParId());
					ChatUser pchatUser = new ChatUser();
					pchatUser.setUsername(parent.getName());
					pchatUser.setId(parent.getOpenid());
					pchatUser.setStatus("hide");
					pchatUser.setAvatar(parentImg);
					parentChat.add(pchatUser);
				}
			}

			studentFriend.setList(studentChat);
			parentFriend.setList(parentChat);
			list.add(studentFriend);
			list.add(parentFriend);
		}

		chatUserGroup.setFriend(list);
		result.setData(chatUserGroup);
		return  result;
	}

	/**
	 *发送消息通知
	 * @param type
	 * @param data
	 * @return
	 */
	@RequestMapping("/sendMsg")
	public CommonResult<Object> sendMsg(String type,String data){
		LayMessage msg = JSON.parseObject(data,LayMessage.class);

		ChatRecord chatRecord = new ChatRecord();
		//chatrecord 使用双方的openId作为记录值
		chatRecord.setContent(msg.getMine().getContent());
		chatRecord.setFromUser(msg.getMine().getId());
		chatRecord.setToUser(msg.getTo().getId());
		//保存chatReocrd
		chatRecord.insert();
		//向前端推送
		goEasy.publish("wechatMSG",data);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//封装模板消息需要的数据
		String []val =  new String[4];
		val[0] = TemplateId.MSG.getValue();
		val[1] = msg.getMine().getUsername();
		val[2] = msg.getMine().getContent();
		val[3] = sdf.format(new Date());
		String url = "";
//		if(type.equals("teacher")){
//			//表明是发送给教师的
//			url = href+"chat/";
//		}else if(type.equals("student")){
//			//表示是发送给学生的
//			url = href+"chat/toStudentChat?fromUser="+msg.getMine().getId()+"&toUser="+msg.getTo().getId();
//		}else{
//			//表示是发送给家长的
//			url = href+"chat/toParentChat?fromUser="+msg.getMine().getId()+"&toUser="+msg.getTo().getId();
//		}
		Template template = WechatUtil.getTemplate(msg.getTo().getId(),TemplateId.MSG.getUrl(),"#ccc",url,val);
		//发送模板消息
		templateService.sendTemplateMsg(template);
		//返回消息结果
		return new CommonResult<>(successcode,successMessage);
	}

	//父母自己点击进入的聊天界面
	@GetMapping("/parentChat/{openId}")
	public ModelAndView parentChat(HttpServletRequest request,@PathVariable String openId){
		ModelAndView modelAndView = new ModelAndView("parentChat");
		modelAndView.addObject("me",openId);
		return modelAndView;
	}
	//学生自己点击进入的聊天界面
	@GetMapping("/studentChat/{openId}")
	public ModelAndView studentChat(HttpServletRequest request,@PathVariable String openId){
		ModelAndView modelAndView = new ModelAndView("chat");
		modelAndView.addObject("me",openId);
		return modelAndView;
	}


	/**
	 *发送审核通知
	 * @return
	 */
	@RequestMapping("/sendCheckMsg")
	public CommonResult<Object> sendCheckMsg(@RequestBody Map<String,Object> map){

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//封装模板消息需要的数据
		String []val =  new String[5];
		val[0] = TemplateId.LEAVE.getValue();
		val[1] = map.get("studentName").toString();
		val[2] = map.get("reason").toString();
		val[3] = sdf.format(new Date());
		val[4] = map.get("dayNum").toString();
		Template template = WechatUtil.getTemplate(map.get("teacherOpenId").toString(),TemplateId.LEAVE.getUrl(),"#ccc","",val);
		//发送模板消息
		templateService.sendTemplateMsg(template);
		//返回消息结果
		return new CommonResult<>(successcode,successMessage);
	}


	@GetMapping("/toParentChat")
	public ModelAndView toParentChat(HttpServletRequest request,String fromUser,String toUser){
		ModelAndView modelAndView = new ModelAndView("parentChat");
		modelAndView.addObject("other",fromUser);
		modelAndView.addObject("me",toUser);
		return modelAndView;
	}

	@GetMapping("/toStudentChat")
	public ModelAndView toStudentChat(HttpServletRequest request,@RequestParam(required = false) String fromUser,@RequestParam(required = false)String toUser){
		ModelAndView modelAndView = new ModelAndView("studentChat");
		modelAndView.addObject("other",fromUser);
		modelAndView.addObject("me",toUser);

		return modelAndView;
	}

	//家长端的聊天群组数据接口
	@RequestMapping("/parentChatInfo")
	public LayuiBaseResult<Object> parentChatInfo(HttpServletRequest request,String toUser){
		//两个参数都是OPENID
		Parent parent = new Parent();
		//查询接收方的消息,这里的接收方就是自己
		parent = parent.selectOne("openId = {0}",toUser);
		StudentParent sp = new StudentParent();
		List<StudentParent> spList = sp.selectList("par_id = {0}",parent.getId());

		Student student = new Student();
		student = student.selectById(spList.get(0).getStuId());

		List<Map<String,Object>> teachers = teacherDao.selectClassTeacher(student.getClaId());

		LayuiBaseResult<Object> result = new LayuiBaseResult<>();
		result.setCode(0);
		result.setMsg("success");
		ChatUserGroup chatUserGroup = new ChatUserGroup();
		ChatUser me = new ChatUser();
		me.setStatus("online");
		me.setId(parent.getOpenid());
		me.setUsername(parent.getName());
		me.setAvatar(parentImg);
		chatUserGroup.setMine(me);
		List<Friend> list = new ArrayList<>();
		List<ChatUser> teacherChat = new ArrayList<>();
		Friend teacherFriend = new Friend();
		teacherFriend.setGroupname("教师");
		teacherFriend.setId(1);
		for(Map<String,Object> map : teachers){
			ChatUser chatUser = new ChatUser();
			chatUser.setAvatar(teacherImg);
			String id = (String)map.get("id");
			chatUser.setId(id);
			String username = map.get("subject")+"老师-"+(String)map.get("username");
			chatUser.setUsername(username);
			chatUser.setStatus("online");
			teacherChat.add(chatUser);
		}
		teacherFriend.setList(teacherChat);

		list.add(teacherFriend);
		chatUserGroup.setFriend(list);
		result.setData(chatUserGroup);

		return result;
	}


	//学生端的聊天群组数据接口
	@RequestMapping("/studentChatInfo")
	public LayuiBaseResult<Object> studentChatInfo(HttpServletRequest request, String fromUser, String toUser){
		//两个参数都是OPENID
		Student student = new Student();
		//查询接收方的消息
		student = student.selectOne("openId = {0}",toUser);
		List<Map<String,Object>> teachers = teacherDao.selectClassTeacher(student.getClaId());

		LayuiBaseResult<Object> result = new LayuiBaseResult<>();
		result.setCode(0);
		result.setMsg("success");
		ChatUserGroup chatUserGroup = new ChatUserGroup();
		ChatUser me = new ChatUser();
		me.setStatus("online");
		me.setId(student.getOpenid());
		me.setUsername(student.getName());
		me.setAvatar(studentImg);
		chatUserGroup.setMine(me);
		List<Friend> list = new ArrayList<>();
		List<ChatUser> teacherChat = new ArrayList<>();
		Friend teacherFriend = new Friend();
		teacherFriend.setGroupname("教师");
		teacherFriend.setId(1);
		for(Map<String,Object> map : teachers){
			ChatUser chatUser = new ChatUser();
			chatUser.setAvatar(teacherImg);
			String id = (String)map.get("id");
			chatUser.setId(id);
			String username = map.get("subject")+"老师-"+(String)map.get("username");
			chatUser.setUsername(username);
			chatUser.setStatus("online");
			teacherChat.add(chatUser);
		}
		teacherFriend.setList(teacherChat);

		list.add(teacherFriend);
		chatUserGroup.setFriend(list);
		result.setData(chatUserGroup);

		return result;
	}





}
