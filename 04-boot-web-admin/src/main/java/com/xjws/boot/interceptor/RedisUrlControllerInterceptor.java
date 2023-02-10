package com.xjws.boot.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xujian
 * @create 2023-02-07 11:35
 */

//@Component  //放到ioc中
public class RedisUrlControllerInterceptor implements HandlerInterceptor {
//    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.判断请求是谁
        String requestURI = request.getRequestURI();
        stringRedisTemplate.opsForValue().increment(requestURI);
        return true;//这个拦截器永远都是放行
        //2.去配置类中注册该拦截器
    }

}
