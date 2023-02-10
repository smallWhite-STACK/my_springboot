package com.xjws.boot.config;

import com.xjws.boot.interceptor.LoginInterceptor;
import com.xjws.boot.interceptor.RedisUrlControllerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xujian
 * @create 2023-02-04 13:12
 */
/**
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors）
 * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 *
 * @EnableWebMvc:全面接管
 *      1、静态资源？视图解析器？欢迎页.....全部失效
 */
//@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * Filter、Interceptor 几乎拥有相同的功能？
     * 1、Filter是Servlet定义的原生组件。好处，脱离Spring应用也能使用
     * 2、Interceptor是Spring定义的接口。可以使用Spring的自动装配等功能
     *
     */
//    @Autowired
//    RedisUrlControllerInterceptor redisUrlControllerInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")  //所有请求都被拦截包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**",
                        "/js/**","/aa/**","/insertcity"); //放行的请求
        //注意因为我们在RedisUrlControllerInterceptor使用注解@Component，
//        因此在这我们不能自己new（不是从容器中拿）,否则RedisUrlControllerInterceptor内部使用的autowired无法使用（因为只有容器中的组件springboot才会解析这些注解）
        //我们直接在这里注入即可
//        registry.addInterceptor(redisUrlControllerInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**",
//                "/js/**","/aa/**","/insertcity"); ;
//        registry.addInterceptor(redisUrlCountInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**",
//                        "/js/**","/aa/**");
    }

//    @Autowired
//    RedisUrlCountInterceptor redisUrlCountInterceptor;

    /**
     * 定义静态资源行为
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        /**
//         * 访问  /aa/** 所有请求都去 classpath:/static/ 下面进行匹配
//         */
//        registry.addResourceHandler("/aa/**")
//                .addResourceLocations("classpath:/static/");
//    }



//    @Bean
//    public WebMvcRegistrations webMvcRegistrations(){
//        return new WebMvcRegistrations(){
//            @Override
//            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
//                return null;
//            }
//        };
//    }
}

