package com.xjws.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xujian
 * @create 2023-02-06 16:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {
    private Long id;
    private String userId;
    private Long money;
}
