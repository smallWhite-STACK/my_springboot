package com.xjws.boot.controller;

import com.xjws.boot.pojo.Person;
import com.xjws.boot.pojo.Son;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xujian
 * @create 2023-02-03 12:09
 */
@Controller
public class ResponseTestController {

    @ResponseBody
    @GetMapping("/test/getPerson")
    public Person getPerson(){
        Person xx = new Person("xx", 1,new Son("ss",0));
        return xx;

    }
}
