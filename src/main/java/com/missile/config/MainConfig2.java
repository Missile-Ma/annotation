package com.missile.config;

import com.missile.bean.Color;
import com.missile.bean.ColorFactoryBean;
import com.missile.bean.Dog;
import com.missile.bean.Person;
import com.missile.condition.LinuxCondition;
import com.missile.condition.MyImportBeanDefinitionRegistrar;
import com.missile.condition.MyImportSelector;
import com.missile.condition.WindowsCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * @author Missile
 * @Date 2021-02-02-20:59
 */
@Configuration
@Conditional({WindowsCondition.class})
@Import({Dog.class, Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//类中组件统一设置满足当前条件，这个类中配置的所有bean注册才能生效
public class MainConfig2 {
    @Lazy
    //懒加载：单实例Bean：默认在容器启动时创建对象；懒加载：容器启动不创建对象，第一次使用，获取，Bean创建对象，并初始化；
    @Bean("person")//默认是单实例的,容器启动则调用方法创建对象放到IOC容器中，以后每次获取就是直接从容器（map.get()）中拿
   // @Scope(scopeName = "prototype")//prototype:多实例的，single:单实例的，request:同一次请求创建一个实例,session:同一个session创建一个实例
    //多实例：IOC容器启动不会去调用方法创建对象放在容器中。每次获取的时候才会调用方法创建对象
    //scope:调整作用域
    public Person person(){
        System.out.println("往容器中添加Person。。。。。。");
        return new Person("zhangsan",25);
    }
    /**
     * @Conditional ： 按照一定条件进行判断，满足条件给窗口中注册bean
     */
   @Conditional({WindowsCondition.class})
   //@Autowired
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",60);
    }
    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public  Person person02(){
        return new Person("linus",48);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
       return new ColorFactoryBean();
    }
}
