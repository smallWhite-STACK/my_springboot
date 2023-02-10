package com.xjws.boot.bean;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author xujian
 * @create 2023-01-29 16:47
 */
//@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Slf4j
@ConfigurationProperties(prefix = "car")
public class Car {
    private Integer price;
    private String brand;

}
