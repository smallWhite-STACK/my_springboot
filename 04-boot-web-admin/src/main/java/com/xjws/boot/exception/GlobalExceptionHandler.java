package com.xjws.boot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author xujian
 * @create 2023-02-05 9:53
 * 处理整个web的异常
 */
@ControllerAdvice     //相当于对Component的增强
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    public String exceptionHand(){
        return "login";
    }
}
