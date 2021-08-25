package com.easy.commonutils.exceptionhandler;

import com.easy.commonutils.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * <p>
 *  统一错误返回
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-08
 */
@ControllerAdvice
public class UnifiedExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResult error(Exception e){
        e.printStackTrace();
        return CommonResult.error().message("统一异常处理");
    }
    //自定义异常
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public CommonResult error(MyException e){
        e.printStackTrace();
        return CommonResult.error().code(e.getCode()).message(e.getMsg());
    }
}
