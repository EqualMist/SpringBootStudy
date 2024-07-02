package com.zzy.controller;

import com.zzy.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class MainController {

    @Value("${test.name}")
    String testValue;

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        MDC.put("reqId", request.getSession().getId());
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
