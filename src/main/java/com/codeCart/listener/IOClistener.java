package com.codeCart.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 监听容器初始化完成
 * 监听容器初始化失败
 * 通常使用监听器加载资源
 * 开启定时任务等
 */
public class IOClistener implements ApplicationListener {
    /**
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ApplicationReadyEvent){
            System.out.println("IOC容器初始化完成");
        }
        if (event instanceof ApplicationFailedEvent){
            System.out.println("IOC容器初始化失败");
        }
    }
}
