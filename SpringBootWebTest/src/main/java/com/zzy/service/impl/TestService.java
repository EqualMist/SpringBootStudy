package com.zzy.service.impl;

import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestService implements BeanNameAware {

    @Override
    public void setBeanName(String s) {
        System.out.println(s);
    }

//    @Async
//    public void test() {
//        try {
//            Thread.sleep(3000);
//            System.out.println("我是异步任务");
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
