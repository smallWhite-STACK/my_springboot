package com.xjws.boot;

import com.xjws.boot.bean.Car;
import com.xjws.boot.bean.Person;
import com.xjws.boot.bean.Pet;
import com.xjws.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author xujian
 * @create 2023-01-29 13:28
 *  *
 *  * 主程序类
 *  * @SpringBootApplication：这是一个SpringBoot应用
 *  *
 *
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //1.获取ioc容器
        ConfigurableApplicationContext ioc = SpringApplication.run(MainApplication.class, args);
        //2、查看容器里面的组件
        String[] names = ioc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
//        //3、从容器中获取组件
//            //3.1验证是否单例
//        Person bean1 = ioc.getBean(Person.class);
//        Person bean2 = ioc.getBean(Person.class);
//        System.out.println(bean1==bean2);   //true
//            //3.2、配置类本身也是ioc中的组件，也可以获取
//        MyConfig bean = ioc.getBean(MyConfig.class);
//        System.out.println(bean);  //com.xjws.boot.config.MyConfig$$EnhancerBySpringCGLIB$$327a7f7d@470a9030
//
//            //3.3如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
//                //保持组件单实例
//                //通过3.2获取的配置类对象，然后直接调用其中的被@Bean修饰的方法，我们发现仍然是单例
//        Person user = bean.user01();
//        Person user1 = bean.user01();
//        System.out.println(user == user1);   //true
//
//            //3.4我们在Person中加上属性：Pet pet,并且在配置类中重写user01方法（在user01中调用pet01）
//                //通过结果可以看出仍然是单例
//        Person user01 = ioc.getBean("user01", Person.class);
//        Pet tom = ioc.getBean("pet01", Pet.class);
//
//        System.out.println("用户的宠物："+(user01.getPet() == tom));
        //测试conditional
//        System.out.println("=====================");
//        Person bean = ioc.getBean(Person.class);
//        System.out.println(bean);

        //获取Car组件
        Car bean = ioc.getBean(Car.class);
        System.out.println(bean);
    }
}
