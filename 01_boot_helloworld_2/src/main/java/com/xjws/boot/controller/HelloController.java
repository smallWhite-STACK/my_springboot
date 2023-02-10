package com.xjws.boot.controller;

import com.xjws.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xujian
 * @create 2023-02-01 14:34
 */
@RestController
public class HelloController {

    @Autowired
    Person person;

    @GetMapping("/person")
    public Person hello(){
        return  person;
    }
}
