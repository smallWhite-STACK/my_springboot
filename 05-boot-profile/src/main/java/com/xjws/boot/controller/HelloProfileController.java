package com.xjws.boot.controller;

import com.xjws.boot.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xujian
 * @create 2023-02-08 11:02
 */
@Controller
public class HelloProfileController {
    @Autowired
    Person person;

    @Value("${person.name:周五}")
    String name;


    @ResponseBody
    @GetMapping("/hello")
    public Person helloTestxj(){
        return person;
    }
}
