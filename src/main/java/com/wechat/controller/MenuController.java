package com.wechat.controller;

import com.wechat.bean.AccessToken;
import com.wechat.dao.StudentDao;
import com.wechat.entity.Student;
import com.wechat.model.Menu;
import com.wechat.model.Template;
import com.wechat.model.TemplateParam;
import com.wechat.service.MenuService;
import com.wechat.service.TeacherService;
import com.wechat.service.TemplateService;
import com.wechat.util.HttpUtil;
import com.wechat.util.JSONUtils;
import com.wechat.util.TemplateId;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @作者: jethro
 * @时间: 2018/4/9
 * @描述：
 */
@RestController
@RequestMapping("/wechat")
public class MenuController {
    private static Logger log = LoggerFactory.getLogger(MenuController.class);

    @Value("${wechat.appID}")
    private String appId;
    @Value("${wechat.appsecret}")
    private String appsecret;

    @Autowired
    private MenuService menuService;
    @Autowired
    private TemplateService templateService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentDao studentMapper;

    @RequestMapping("/getToken")
    @ResponseBody
    public ResponseEntity<String> getToken(){
        try {
            String accessToken = HttpUtil.getAccessToken(appId,appsecret).getAccessToken();
            return new ResponseEntity<String>(accessToken, HttpStatus.OK);
        } catch (JSONException e) {
            log.error("get accessToken failed",e);
            e.printStackTrace();
            return new ResponseEntity<String>("get accessToken failed", HttpStatus.OK);
        }
    }

    @RequestMapping("/createMenu")
    @ResponseBody
    public ResponseEntity<String> createMenu(HttpServletRequest request, @RequestBody String requestBody){

        int i = -1;
        if (requestBody == null || "".equals(requestBody)){
            log.error("requestBody is empty");
            return new ResponseEntity<String>("requestBody is empty", HttpStatus.OK);
        }
        System.out.println(requestBody);
        Menu menu = JSONUtils.readValue(requestBody,Menu.class);
        AccessToken accessToken = null;
        try {
            accessToken = HttpUtil.getAccessToken(appId,appsecret);
        } catch (JSONException e) {
            log.error("get accessToken failed",e);
            e.printStackTrace();
            return new ResponseEntity<String>("get accessToken failed", HttpStatus.OK);
        }

        try {
            i = menuService.createMenu(menu,accessToken.getAccessToken());
        } catch (JSONException e) {
            log.error("create Menu failed",e);
            e.printStackTrace();
            return new ResponseEntity<String>("create Menu failed", HttpStatus.OK);
        }

        if(i !=0 ){
            return new ResponseEntity<String>("create Menu success", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("create Menu failed", HttpStatus.OK);
        }
    }

//    @RequestMapping("/sendTemplate")
//    public ResponseEntity<String> sendTemplate(){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Template template = new Template();
//        TemplateParam p1 = new TemplateParam("keyword1",TemplateId.MSG.getValue(),"#743A3A");
//        TemplateParam p2 = new TemplateParam("keyword2","我有一条没毛驴","#0000ff");
//        TemplateParam p3 = new TemplateParam("keyword3","在吗？","#0000ff");
//        TemplateParam p4 = new TemplateParam("keyword4",sdf.format(new Date()),"#0000ff");
//        ArrayList<TemplateParam> list = new ArrayList<TemplateParam>();
//        list.add(p1);
//        list.add(p2);
//        list.add(p3);
//        list.add(p4);
//        template.setToUser("oMwUa1p65kY_CbMrfDa9-Vko5CsM");
//        template.setTemplateId(TemplateId.MSG.getUrl());
//        template.setTopColor("#abcdef");
//        template.setTemplateParamList(list);
//        AccessToken accessToken = null;
//        try {
//            accessToken = HttpUtil.getAccessToken(appId,appsecret);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        templateService.sendTemplateMsg(accessToken.getAccessToken(),template);
//        return new ResponseEntity<String>("sendTemplate SUCCESS", HttpStatus.OK);
//    }

    @RequestMapping("/test")
    @ResponseBody
    public String getTest(){

        Student student = studentMapper.selectByPrimaryKey(1);
        return student.getName();
    }

}
