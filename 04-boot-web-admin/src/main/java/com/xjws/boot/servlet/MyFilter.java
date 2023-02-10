package com.xjws.boot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author xujian
 * @create 2023-02-05 11:34
 */
@Slf4j
//@WebFilter(urlPatterns={"/css/*","/images/*"})  //此时访问http://localhost:8080/css/style.css就不行了
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("webfilter初始化完成！！！" );
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.info("webfilter放行！！！" );
        //必须放行
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("webfilter销毁！！！" );
    }
}
