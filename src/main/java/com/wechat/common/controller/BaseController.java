package com.wechat.common.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class BaseController {


    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    protected static int successcode = 0;
    protected static String successMessage = "操作成功";

    protected static int errorcode = -1;
    protected static String errorMessage = "操作失败";

    @ModelAttribute
    public void setReqAndResp(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

}
