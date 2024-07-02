package com.zzy.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class TestListener implements ApplicationListener<TestEvent> {


    @Override
    public void onApplicationEvent(TestEvent event) {
        System.out.println("事件触发了：" + event.getSource());
    }

}
