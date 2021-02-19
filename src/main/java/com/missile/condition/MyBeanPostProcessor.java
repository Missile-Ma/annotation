package com.missile.condition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Missile
 * @Date 2021-02-03-23:40
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor{

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization------" + beanName + "------>" + bean);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization------" + beanName + "------>" + bean);
        return bean;
    }
}
