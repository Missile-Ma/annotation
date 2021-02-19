package com.missile.test;

import com.missile.bean.Blue;
import com.missile.bean.ColorFactoryBean;
import com.missile.bean.Person;
import com.missile.config.MainConfig;
import com.missile.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @author Missile
 * @Date 2021-02-02-20:18
 */
public class IOCTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
    @Test
    public void test02() {
      /*  AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }*/
        System.out.println("IOC容器创建完成");
        Object person = context.getBean("person");
        Object person2 = context.getBean("person");
        System.out.println(person == person2);

    }
    @Test
    public void test03(){
      /*  String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }*/
        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        System.out.println(beansOfType);



    }

    private void printBeans(AnnotationConfigApplicationContext context){
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
    @Test
    public void testImport(){
        printBeans(context);

        Blue bean = context.getBean(Blue.class);
        System.out.println(bean);
        Object colorFactoryBean = context.getBean("colorFactoryBean");
        System.out.println(colorFactoryBean);
        Object colorFactoryBean1 = context.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean1);
    }
}
