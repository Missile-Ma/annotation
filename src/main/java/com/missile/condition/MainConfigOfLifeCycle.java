package com.missile.condition;

import com.missile.bean.Car;
import com.missile.bean.Cat;
import com.missile.bean.Dog;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;

/**
 * @author Missile
 * @Date 2021-02-03-23:05
 * 自定义初始化及销毁方法
 * 一、使用@bean的【initMethod,destroyMethod】
 * 二、使用@componentScan 实现【InitializingBean, DisposableBean】
 * 三、使用注解 @PostConstruct @PreDestroy
 * 四、使用BeanPostProcessor:Bean的后置处理器
 * postProcessBeforeInitialization：在初始化之前工作
 * postProcessAfterInitialization：在初始化之后工作
 */
@Configuration
@ComponentScan({"com.missile.bean","com.missile.condition"})
@Import({Dog.class})
public class MainConfigOfLifeCycle {

   // @Bean(initMethod = "init",destroyMethod = "destroy")
    //@Scope("prototype")
//    @Bean
//    public Car Car() {
//        return new Car();
//    }

}
