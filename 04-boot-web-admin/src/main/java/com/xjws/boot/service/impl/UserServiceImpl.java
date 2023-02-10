package com.xjws.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xjws.boot.mapper.UserMapper;
import com.xjws.boot.pojo.User;
import com.xjws.boot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author xujian
 * @create 2023-02-06 20:37
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
