package com.zzy.controller;

import com.zzy.entity.Student;
import com.zzy.service.impl.TestService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class MainController {

    @Value("${test.name}")
    String testValue;

    @Resource
    TestService testService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        log.info("有人访问了login页面");
        return "login";
    }

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
