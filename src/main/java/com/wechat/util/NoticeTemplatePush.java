package com.wechat.util;

import com.wechat.bean.AccessToken;
import com.wechat.entity.NoticeBulletin;
import com.wechat.entity.Parent;
import com.wechat.entity.Student;
import com.wechat.entity.Teacher;
import com.wechat.model.Template;
import com.wechat.model.NoticeTemplateQueue;
import com.wechat.model.TemplateParam;
import com.wechat.service.TemplateService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zxc on 2018/6/1.
 */
@Component
public class NoticeTemplatePush implements Runnable{
	volatile boolean stopme = false;
	@Autowired
	TemplateService templateService;
	@Value("${wechat.appID}")
	private String appId;
	@Value("${wechat.appsecret}")
	private String appsecret;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	@Override
	public void run() {
		try{
			while (true){
				if (Thread.currentThread().isInterrupted() || stopme){
					break;
				}
				Parent parent = new Parent();
				Teacher tea = new Teacher();
				Student student = new Student();
				NoticeBulletin notice = NoticeTemplateQueue.getInstance().getTemplateQueue().take();

				List<Student> listStudent = student.selectList(" openid is not null");
				List<Parent> listParent = parent.selectList(" openid is not null");
				List<Teacher> listTeacher = tea.selectList(" openid is not null");

				for(Student s:listStudent){
					sendMsg(s.getOpenId(),notice);
				}
				for(Parent p:listParent){
					sendMsg(p.getOpenid(),notice);
				}
				for(Teacher t:listTeacher){
					sendMsg(t.getOpenId(),notice);
				}

				Thread.currentThread().yield();
			}
		}catch (Exception e){
			stopThread();
		}
	}
	private void sendMsg(String openId,NoticeBulletin notice){
		Template template = new Template();
		template.setToUser(openId);
		template.setTemplateId(TemplateId.MSG.getUrl());
		template.setTopColor("#ccc");
		AccessToken accessToken = null;
		TemplateParam p1 = new TemplateParam("keyword1",TemplateId.NOTICE.getValue(),"#743A3A");
		TemplateParam p2 = new TemplateParam("keyword2",notice.getTitle(),"#0000ff");
		TemplateParam p3 = new TemplateParam("keyword3",notice.getContent(),"#0000ff");
		TemplateParam p4 = new TemplateParam("keyword4",sdf.format(new Date()),"#0000ff");
		ArrayList<TemplateParam> list = new ArrayList<TemplateParam>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		template.setTemplateParamList(list);
		try {
			accessToken = HttpUtil.getAccessToken(appId,appsecret);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		templateService.sendTemplateMsg(accessToken.getAccessToken(),template);
	}
	private void stopThread(){
		stopme = true;
	}
}
