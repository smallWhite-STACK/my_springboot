package com.xjws.boot.config;

import com.xjws.boot.converter.GuiguMessageConverter;
import com.xjws.boot.pojo.Son;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xujian
 * @create 2023-02-02 10:38
 */
@Configuration(proxyBeanMethods = false)
public class WebConfig //implements WebMvcConfigurer
{

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("_m");
        return hiddenHttpMethodFilter;
    }

//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }
//}
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            //为例实现
//        <!--<form method="post" action="/savePerson">-->
//            <!--name:<input name="name">-->
//            <!--age:<input name="age">-->
//            <!--son.name<input name="son.name" value="erzi">-->
//            <!--son.age<input name="son.age" value="12">-->
//            <!--<input type="submit" value="提交">-->
//        <!--</form>-->
//        <form method="post" action="/savePerson">
//        name:<input name="name">
//        age:<input name="age">
//        son<input name="son" value="erzi,16">
//            <input type="submit" value="提交">
//        </form>

            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Son>() {
                    @Override
                    public Son convert(String source) {
                        //这个source就是erzi,16
                        String[] split = source.split(",");
                        Son son = new Son();
                        son.setName(split[0]);
//                        son.setAge(split[1]);//记得转换为Integer
                        son.setAge(Integer.parseInt(split[1]));
                        return son;
                    }
                });
            }

            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                GuiguMessageConverter guiguMessageConverter = new GuiguMessageConverter();
                converters.add(guiguMessageConverter);
            }

            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                //我们需要在这加入内容协商策略（原始的策略：基于参数(只有两个) （需要手动开启）、基于请求头）
//                我们要做的是重写内容策略（参数内容协商策略+请求头内容协商策略）
                //1. ParameterContentNegotiationStrategy的参数是Map<String, MediaType> mediaTypes
                Map<String, MediaType> mediaTypes = new HashMap<>();
                mediaTypes.put("json", MediaType.APPLICATION_JSON);
                mediaTypes.put("xml",MediaType.APPLICATION_XML);
                mediaTypes.put("xj",MediaType.parseMediaType("application/xj"));
                ParameterContentNegotiationStrategy parameterContentNegotiationStrategy = new ParameterContentNegotiationStrategy(mediaTypes);
                parameterContentNegotiationStrategy.setParameterName("format");
                HeaderContentNegotiationStrategy headerContentNegotiationStrategy = new HeaderContentNegotiationStrategy();

                configurer.strategies(Arrays.asList(parameterContentNegotiationStrategy,headerContentNegotiationStrategy));
            }
        };

    }




}
