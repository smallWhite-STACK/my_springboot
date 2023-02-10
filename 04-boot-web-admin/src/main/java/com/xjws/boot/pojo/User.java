package com.xjws.boot.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xujian
 * @create 2023-02-06 20:17
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@TableName("user")
public class User {
    @TableField(exist = false)
    private String hhhh;

    private Long id;
    private String name;
    private Integer age;
    private String email;
}