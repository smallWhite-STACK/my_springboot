package com.xjws.boot.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author xujian
 * @create 2023-02-07 18:30
 */
@Component
public class MyComInfo implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("username", "张三").withDetail("age", "32")
        .withDetails(Collections.singletonMap("sex", "male"));
    }
}
