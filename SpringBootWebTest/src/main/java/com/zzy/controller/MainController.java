package com.zzy.controller;

import com.zzy.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Value("${test.name}")
    String testValue;

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "欢迎访问你的第一个Spring Boot项目";
    }

    @RequestMapping("/student")
    @ResponseBody
    public Student student() {
        Student student = new Student();
        student.setName("Elysia").setSex("女").setSid(123);
        System.out.println(testValue);
        return student;
    }
}
