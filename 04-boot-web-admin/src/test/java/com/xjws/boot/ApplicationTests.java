package com.xjws.boot;

import com.xjws.boot.mapper.UserMapper;
import com.xjws.boot.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Map;

@Slf4j
@SpringBootTest
class ApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    @Test
    void contextLoads() {
        User user = userMapper.selectById(1L);
//        Long aLong = jdbcTemplate.queryForObject("select count(*) from account_tb1", Long.class);
////        System.out.println(aLong);
//        log.info("一共有{}条数据", aLong);
//        log.info("数据源是{}", dataSource.getClass());
        log.info("user{}", user);

    }

    @Test
    public void testRedis(){
//        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("hello", "world");
//
//        String hello = valueOperations.get("hello");
//        System.out.println(hello);
        System.out.println(redisConnectionFactory.getClass());
    }





}
