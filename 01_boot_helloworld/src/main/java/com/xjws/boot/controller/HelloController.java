package com.xjws.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xujian
 * @create 2023-01-29 13:26
*/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){

        return "Hello, it's springboot.";
    }
}
