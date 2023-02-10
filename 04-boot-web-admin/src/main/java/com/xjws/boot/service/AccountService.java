package com.xjws.boot.service;

import com.xjws.boot.mapper.AccountMapper;
import com.xjws.boot.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xujian
 * @create 2023-02-06 16:06
 */
@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;

    public List<Account> getAllUser(){
        List<Account> accountList = accountMapper.queryAllUser();
        return accountList;
    }
}
