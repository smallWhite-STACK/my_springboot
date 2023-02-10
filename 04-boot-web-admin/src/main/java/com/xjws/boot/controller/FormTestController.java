package com.xjws.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author xujian
 * @create 2023-02-04 15:32
 */
@Controller
@Slf4j
public class FormTestController {
    @GetMapping("/form_layouts")
    public String formLayout(){
        return "forms/form_layouts" ;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("email") String email,
                             @RequestParam("name") String name,
                             @RequestPart("headImg") MultipartFile headImg,
                             @RequestPart("photos") MultipartFile[] photos
                             ) throws IOException {
        //1.我们打印一下接收的表单信息
        log.info("邮箱地址：{},用户名：{},头像size:{},照片个数{}", email,name,headImg.getSize(),photos.length);
        //2.处理接收的图像
            //2.1获取图像的原始名字
            //2.2将图像--》file
            //2.3保存到指定位置
        //headImg
        if(!headImg.isEmpty()) {
            String headImgOriginalFilename = headImg.getOriginalFilename();
            headImg.transferTo(new File("F:\\视频资料\\springboot\\uploadTest\\" + headImgOriginalFilename));
        }
        //photos
        if(photos.length > 0) {
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()) {
                    String photoName = photo.getOriginalFilename();
                    photo.transferTo(new File("F:\\视频资料\\springboot\\uploadTest\\" + photoName));
                }
            }
        }
        return "index";
    }
}
