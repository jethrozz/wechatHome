package com.wechat.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseController {


    protected HttpServletRequest request;
    protected HttpServletResponse response;

    protected static int successcode = 0;
    protected static String successMessage = "操作成功";

    protected static int errorcode = -1;
    protected static String errorMessage = "操作失败";

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}
