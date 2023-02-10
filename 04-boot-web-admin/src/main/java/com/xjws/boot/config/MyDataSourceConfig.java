package com.xjws.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Filter;

/**
 * @author xujian
 * @create 2023-02-06 9:54
 */
@Deprecated
//@Configuration
public class MyDataSourceConfig {
    /**
     * 根据DataSourceConfiguration中的配置，我们这里也设置方法名字为dataSource
     */
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource  dataSource() throws SQLException {
        //我们可以在这里设置配置参数，但是是写死的，
//        我们可以通过注解@ConfigurationProperties("spring.datasource")来使用配置文件的配置
        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl();
//        druidDataSource.setUsername();
//        druidDataSource.setPassword();
//        druidDataSource.setDriverClassName();
        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }

    @Bean
    public ServletRegistrationBean  statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        //public ServletRegistrationBean(T servlet, String... urlMappings)   //urlMappings设置拦截路径
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(statViewServlet,"/druid/*");
        statViewServletServletRegistrationBean.addInitParameter("resetEnable", "true");
        statViewServletServletRegistrationBean.addInitParameter("loginUsername","admin");
        statViewServletServletRegistrationBean.addInitParameter("loginPassword","0123");

        statViewServletServletRegistrationBean.setUrlMappings(Arrays.asList("/druid/*"));
        return statViewServletServletRegistrationBean;
    }

    /**
     * WebStatFilter用于采集web-jdbc关联监控的数据。
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        webStatFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        webStatFilterFilterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return webStatFilterFilterRegistrationBean;
    }
}
