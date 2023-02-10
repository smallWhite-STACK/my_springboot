package com.xjws.boot.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author xujian
 * @create 2023-02-08 10:59
 */
@Component
@ConfigurationProperties("person")
@Profile("testxj")
@Data
public class Person {

    private  String name;
    private String age;
}
