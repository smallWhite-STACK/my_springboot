package com.xjws.boot.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xjws.boot.exception.UserTooManyException;
import com.xjws.boot.pojo.Person;
import com.xjws.boot.pojo.User;
import com.xjws.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

/**
 * @author xujian
 * @create 2023-02-04 11:20
 */
@Controller
public class TableController {
//    <li><a th:href="@{/basic_table}"> Basic Table</a></li>
//    <li class="active"><a th:href="@{dynamic_table}"> Advanced Table</a></li>
//    <li><a th:href="@{responsive_table}"> Responsive Table</a></li>
//    <li><a th:href="@{editable_table}"> Edit Table</a></li>

    @Autowired
    UserService userService;

    @GetMapping("/delete/user/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes ra){
        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/basic_table")
    public String basicTable(){
        System.out.println(5/0);
        return "tables/basic_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamicTable(@RequestParam(value = "pn",defaultValue = "1") Integer currentPage, Model model){
//        List<Person> people = Arrays.asList(new Person("a", "0"),
//                new Person("b", "1"),
//                new Person("c", "2"),
//                new Person("d", "3"),
//                new Person("e", "4")
//        );
//        if(people.size()>3){
//            throw new UserTooManyException();
//        }
//        model.addAttribute("userList", people);
        //?????????????????????user???????????????????????????
//        List<User> list = userService.list();
//        model.addAttribute("userList", list);
//        public Page(long current, long size)
        Page<User> userPage = new Page<>(currentPage, 3);//??????????????????currentPage???????????????3???
        Page<User> page = userService.page(userPage, null);//queryWrapper???????????????
        //??????page?????????????????????????????????????????????????????????????????????
        model.addAttribute("page", page);
//        page.get
//        page.
        return "tables/dynamic_table";
    }




    @GetMapping("/responsive_table")
    public String responsiveTable(){
        return "tables/responsive_table";
    }
    @GetMapping("/editable_table")
    public String editableTable(){
        return "tables/editable_table";
    }

}
