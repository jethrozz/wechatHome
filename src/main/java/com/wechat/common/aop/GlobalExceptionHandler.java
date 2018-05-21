package com.wechat.common.aop;

import com.wechat.common.constat.tips.ErrorTip;
import com.wechat.exception.BizExceptionEnum;
import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
public class GlobalExceptionHandler {


    private Logger log = Logger.getLogger(this.getClass());

    /**
     * 拦截未知的运行时异常
     *
     * @author fengshuonan
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorTip notFount(RuntimeException e) {
        log.error("运行时异常:", e);
        return new ErrorTip(BizExceptionEnum.SERVER_ERROR);
    }

}
