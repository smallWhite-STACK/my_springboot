package com.xjws.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author xujian
 * @create 2023-02-05 10:07
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多了！！！")
public class UserTooManyException extends RuntimeException{
    public UserTooManyException(){}

    public UserTooManyException(String message){
        super(message);
    }
}
