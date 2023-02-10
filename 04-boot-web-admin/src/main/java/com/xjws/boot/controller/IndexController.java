package com.xjws.boot.controller;

import com.xjws.boot.pojo.Account;
import com.xjws.boot.pojo.City;
import com.xjws.boot.pojo.Person;
import com.xjws.boot.service.AccountService;
import com.xjws.boot.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author xujian
 * @create 2023-02-03 19:46
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AccountService accountService;
    @Autowired
    CityService cityService;

    @ResponseBody
    @GetMapping("/querycity")
    public City queryCity(){
        City city = cityService.queryCity((long) 1);
        return city;
    }

    @ResponseBody
    @GetMapping("/insertcity")
    public String insertCity(){
        City city = new City("xj", "Suzhou", "China");
        cityService.insertCity(city);
        return "插入数据成功";
    }

    @ResponseBody
    @GetMapping("/getuser")
    public List<Account> getAllUser(){
        List<Account> allUser = accountService.getAllUser();
        return allUser;
    }


    @ResponseBody
    @GetMapping("/sql")
    public Long handleSql(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account_tb1", Long.class);
        return aLong;
    }

    //1.处理login
    @GetMapping(value = {"/","/login"})
    public String login(){
        return "login";
    }

    //2.处理登录，要去login.html中修改表单提交
//    @PostMapping("/login")
//    public String index(){
//        return "index";
//    }
    @PostMapping("/login")
    public String index(Person person,HttpSession session,Model model){
        //1.对提交的用户信息判断
        if(person.getPassword().equals("root")){
            //2.如果符合要求，就放到session并且重定向
            session.setAttribute("user", person);
            return "redirect:index.html";
        }else{
            //3.否则，到login
//            session.setAttribute("msg", "密码错误");
//            不是使用session来返回错误信息，而是通过model等
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }


//    @Autowired
    StringRedisTemplate redisTemplate;
    @GetMapping("/index.html")
    public String indexPage(HttpSession session,Model model){
        log.info("当前的方法是：", "indexPage");
//        if(session.getAttribute("user")!=null){
//            return "index";   //这样当我门在首页时，即使刷新页面，也不会造成表单的重复提交
//        }else{
//            model.addAttribute("msg", "请重新登录");
//
//            return "login";
//        }
        //获取redis中的数据
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        String indexCount = stringStringValueOperations.get("/index.html");
        String sqlCount = stringStringValueOperations.get("/sql");
        model.addAttribute("indexCount", indexCount);
        model.addAttribute("sqlCount", sqlCount);
        return "index";
    }
}
