package com.xjws.boot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author xujian
 * @create 2023-02-04 12:48
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //我们可以使用日志功能输出当前拦截的请求地址
        StringBuffer requestURL = request.getRequestURL();
        log.info("当前拦截的请求是{}",requestURL);

        //如果我们的session中是否有用户信息（user），我们就放行
        //1.获取session
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if(user!=null){
            //2.放行
            return true;
        }
        //3.否则，去登录
        //3.1想reques中加入msg提示（因为我们在login.html中设置了
        //              <label style="color: #1fb5ad" th:text="${msg}"></label>

        request.setAttribute("msg", "请先登录");
        request.getRequestDispatcher("/").forward(request, response);
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行,",modelAndView);
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行异常{}",ex);
    }
}
