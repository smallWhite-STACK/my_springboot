package com.xjws.boot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author xujian
 * @create 2023-02-05 11:43
 */
@Slf4j
//@WebListener
public class MyListener implements ServletContextListener {
    @Override
    /**
     * 当前项目的初始化
     */
    public void contextInitialized(ServletContextEvent sce) {
        log.info("MyListener监听到项目初始化完成" );
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("MyListener监听到项目销毁" );

    }
}
