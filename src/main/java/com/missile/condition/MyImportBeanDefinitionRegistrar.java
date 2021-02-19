package com.missile.condition;

import com.missile.bean.Rainbow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Missile
 * @Date 2021-02-03-22:33
 */

/**
 * AnnotationMetadata：importingClassMetadata:当前类的注解信息
 * BeanDefinitionRegistry：registry:BeanDefinitionRegistry注册类
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//        BeanDefinition red = registry.getBeanDefinition("Red");

        boolean red = registry.containsBeanDefinition("com.missile.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.missile.bean.Blue");
        boolean green = registry.containsBeanDefinition("com.missile.bean.Green");
        if (red&&blue&&green) {
            registry.registerBeanDefinition("Rainbow", new RootBeanDefinition(Rainbow.class));
        }
    }
}
