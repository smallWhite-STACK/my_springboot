package com.xjws.boot.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author xujian
 * @create 2023-02-09 9:53
 */

public class MyApplicationContextInitializer implements ApplicationContextInitializer  {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("MyApplicationContextInitializer...initialize");
    }
}
