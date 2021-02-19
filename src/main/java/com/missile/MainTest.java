package com.missile;

import com.missile.bean.Person;
import com.missile.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Missile
 * @Date 2021-02-01-21:09
 */
public class MainTest {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
       /* ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) context.getBean("person");
        System.out.println(person);*/
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) context.getBean(Person.class);
        System.out.println(person);

        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String name:beanNamesForType) {
            System.out.println(name);
        }
    }
}
