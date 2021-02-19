package com.missile.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Missile
 * @Date 2021-02-02-23:52
 * <p>
 * ConditionContext：context 能使用的上下文条件
 * AnnotatedTypeMetadata：metadata 注解信息
 */
public class WindowsCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //能获取到IOC使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //获取当前环境信息
        Environment environment = context.getEnvironment();
        //获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");
        //可以判断容器中的bean注册情况，也可以给容器中注册bean
        boolean person = registry.containsBeanDefinition("person");
//        registry.registerBeanDefinition();
        if (property.contains("Win")) {
            return true;
        }

        return false;
    }
}
