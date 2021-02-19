package com.missile.config;

import com.missile.bean.Person;
import com.missile.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author Missile
 * @Date 2021-02-01-21:14
 * 等于以前的配置文件，代替原来的xml文件
 */
@ComponentScans(value = {
        @ComponentScan(value = "com.missile",includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
        },useDefaultFilters = false)
       /* @ComponentScan(value = "com.missile",excludeFilters = {
                //@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})
        })//value:指定要扫描的包,excludeFilters=Filter[]:扫描的时候按照什么规则排除哪些组件,includeFilters=Filter[]:包含哪些组件

        */
})
@Configuration//告诉Spring这是一个配置类
public class MainConfig {
   // @Bean("kaka")//给容器中注册一个Bean；类型为返回值的类型，id默认是用方法名做id
    @Bean
    public Person person() {
        return new Person("zhangsan", 20,null);
    }
}
/*
FilterType.ANNOTATION:按照注解
FilterType.ASSIGNABLE_TYPE:按照给定的类型
FilterType.ASPECTJ:使用ASPECTJ表达式
FilterType.REGEX:使用正则表达式
FilterType.CUSTOM:使用自定义规则
 */