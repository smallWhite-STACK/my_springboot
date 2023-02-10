package com.xjws.boot.config;

/**
 * @author xujian
 * @create 2023-01-29 14:48
 */

import com.xjws.boot.bean.Car;
import com.xjws.boot.bean.Person;
import com.xjws.boot.bean.Pet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 *
 * 3、proxyBeanMethods：代理bean的方法
 *      Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *      Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *      组件依赖必须使用Full模式默认。其他默认是否Lite模式
 *
 * 4、@Import({User.class, DBHelper.class})
 *      给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
 *
 * 5、@ImportResource("classpath:beans.xml")导入Spring的配置文件，
 *
 */
@EnableConfigurationProperties(Car.class)
@Configuration(proxyBeanMethods = true)//告诉SpringBoot这是一个配置类 == 配置文件
public class MyConfig {

    /**
     * Full:外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * 而且我们可以使用@Bean("自定义名字组件id")
     * @return
     */
//    @Bean //给容器中添加组件。
            // 以方法名作为组件的id。
            // 返回类型就是组件类型。
            // 返回的值，就是组件在容器中的实例
//    public Person user01(){
//        return new Person("张三",18);
//    }
    @ConditionalOnBean(name = "pet01")
    @Bean
    public Person user01(){
        Person p = new Person("张三", 18);
        p.setPet(pet01());
        return p;
    }

    public Pet pet01(){
        return new Pet("欢欢");
    }
}
