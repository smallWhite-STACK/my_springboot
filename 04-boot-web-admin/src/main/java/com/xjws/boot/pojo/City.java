package com.xjws.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xujian
 * @create 2023-02-06 16:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class City {

    private Long id;
    private String name;
    private String state;
    private String country;

    public City(String name, String state, String country) {
        this.name = name;
        this.state = state;
        this.country = country;
    }
}