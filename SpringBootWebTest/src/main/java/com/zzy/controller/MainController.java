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
    public String index() {
        return "index";
    }

    @RequestMapping("/student")
    @ResponseBody
    public Student student() {
        return new Student();
    }
}
