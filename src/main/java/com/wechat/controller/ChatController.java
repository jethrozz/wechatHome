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
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		me.setId(teacher.getOpenId());
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
				ChatUser chatUser = new ChatUser();
				chatUser.setId(s.getOpenId());
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
		LayMessage msg = (LayMessage)JSON.parseObject(data,LayMessage.class);

		ChatRecord chatRecord = new ChatRecord();
		//chatrecord 使用双方的openId作为记录值
		chatRecord.setContent(msg.getMine().getContent());
		chatRecord.setFromUser(msg.getMine().getId());
		chatRecord.setToUser(msg.getTo().getId());
		//保存chatReocrd
		chatRecord.insert();
		//向前端推送
		goEasy.publish("newMsg",data);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//封装模板消息需要的数据
		String []val =  new String[4];
		val[0] = TemplateId.MSG.getValue();
		val[1] = msg.getMine().getUsername();
		val[2] = msg.getMine().getContent();
		val[3] = sdf.format(new Date());
		Template template = WechatUtil.getTemplate(msg.getTo().getId(),TemplateId.MSG.getUrl(),"#ccc","",val);
		//发送模板消息
		templateService.sendTemplateMsg(template);
		//返回消息结果
		return new CommonResult<>(successcode,successMessage);
	}

	/**
	 *发送审核通知
	 * @param type
	 * @param data
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



	//学生以及家长端的聊天群组数据接口
	@RequestMapping("/studentChatInfo")
	public LayuiBaseResult<Object> studentChatInfo(HttpServletRequest request,String fromUser,String toUser){
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
		me.setId(student.getOpenId());
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
			String username = SubjectEnum.getNameByCode((int)map.get("subject"))+"老师-"+(String)map.get("username");
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
