package com.wechat.controller;

import com.sun.tools.javac.util.StringUtils;
import com.wechat.bean.AccessToken;
import com.wechat.model.Menu;
import com.wechat.service.MenuService;
import com.wechat.service.WechatService;
import com.wechat.util.HttpUtil;
import com.wechat.util.JSONUtils;
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

/**
 * @作者: jethro
 * @时间: 2018/4/9
 * @描述：
 */
@RestController
@RequestMapping("/wechatMenu")
public class MenuController {
    private static Logger log = LoggerFactory.getLogger(MenuController.class);

    @Value("${wechat.appID}")
    private String appId;
    @Value("${wechat.wechat.appsecret}")
    private String appsecret;

    @Autowired
    private MenuService menuService;
    @RequestMapping("/createMenu")
    @ResponseBody
    public ResponseEntity<String> createMenu(HttpServletRequest request, @RequestBody String requestBody){
        int i = -1;
        if (requestBody == null || "".equals(requestBody)){
            log.error("requestBody is empty");
            return new ResponseEntity<String>("requestBody is empty", HttpStatus.OK);
        }
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
}
