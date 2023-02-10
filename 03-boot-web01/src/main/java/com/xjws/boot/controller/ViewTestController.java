package com.xjws.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xujian
 * @create 2023-02-03 19:24
 */
@Controller
public class ViewTestController {
    @GetMapping("/view")
    public String viewTest(Model model){
        //Model默认会放到请求域中
        model.addAttribute("msg", "你好，这是thymeleaf");
        return "success"; //我们使用thymeleaf解析器
    }
}
