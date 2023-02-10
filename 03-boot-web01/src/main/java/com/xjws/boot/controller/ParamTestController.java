package com.xjws.boot.controller;

import com.xjws.boot.pojo.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xujian
 * @create 2023-02-02 14:31
 */
@RestController
public class ParamTestController {

    @GetMapping("car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String requestHeader,//获取指定的请求头
                                     @RequestHeader Map<String,String> header, //获取所有的请求头
                                     @RequestParam("age") Integer age, //从请求中获取？后的参数值(?是在html中加上的)
                                     //href="/car/3/owner/zhangsan?age=18&inters=lanqiu&inters=zuqiu"
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> param, //得到所有的请求参数
                                     @CookieValue("_ga") String ga,
                                     @CookieValue("_ga") Cookie cookie

                                     ){
        //参数：@PathVariable Map<String,String> pv代表将请求路径所有的路径变量放在一个map中
        HashMap<String, Object> m = new HashMap<>();
        m.put("id", id);
        m.put("name",name);
        m.put("requestHeader", requestHeader);
        m.put("header", header);
        m.put("inters", inters);
        m.put("param", param);



        return m;
//        {"pv":{"id":"3","username":"zhangsan"},"name":"zhangsan","id":3}
    }

    @PostMapping("/save")
    public Map save(@RequestBody String content){
        HashMap<String, Object> m = new HashMap<>();
        m.put("content", content);
        return m;
    }

    @PostMapping("/savePerson")
    public Person savePerson(Person person){
        System.out.println(person);
        return person;
    }

//    <a href="/cars/sell;low=34;brand=byd,audi,yd">@MatrixVariable（矩阵变量）</a>
//    <a href="/cars/sell;low=34;brand=byd;brand=audi;brand=yd">@MatrixVariable（矩阵变量）</a>
//    <a href="/boss/1;age=20/2;age=10">@MatrixVariable（矩阵变量）/boss/{bossId}/{empId}</a>
    @GetMapping("/cars/{path}")
    public Map carsSell(@PathVariable String path,
                        @MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand){
        HashMap<String, Object> m = new HashMap<>();
        m.put("path", path);
        m.put("low",low);
        m.put("brand",brand);
        return m;
    }

    @GetMapping("/boss/{bossId}/{empoyId}")
    public Map boss(
                        @MatrixVariable(value = "age",pathVar = "bossId") Integer bossId,
                        @MatrixVariable(value = "age",pathVar = "empoyId") Integer empoyId){
        HashMap<String, Object> m = new HashMap<>();
        m.put("bossId",bossId);
        m.put("empoyId",empoyId);
        return m;
    }
}
