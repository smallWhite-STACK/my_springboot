package com.xjws.boot.mapper;

import com.xjws.boot.pojo.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xujian
 * @create 2023-02-06 16:00
 */
@Mapper
public interface AccountMapper {
    List<Account> queryAllUser();
}
