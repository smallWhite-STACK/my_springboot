package com.xjws.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xujian
 * @create 2023-01-31 9:53
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pet {
    private String name;
    private Double weight;
}
