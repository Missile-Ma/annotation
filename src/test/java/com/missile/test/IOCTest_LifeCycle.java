package com.missile.test;

import com.missile.bean.*;
import com.missile.condition.MainConfigOfLifeCycle;
import com.missile.config.MainConfigOfAutowired;
import com.missile.config.MainConfigOfPropertyValues;
import com.missile.dao.BookDao;
import com.missile.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.SystemEnvironmentPropertySource;

/**
 * @author Missile
 * @Date 2021-02-03-23:08
 */
public class IOCTest_LifeCycle {
    @Test
    public void test1() {
        //创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("IOC创建完成。。。。。");
        //使用@Bean指定init和destory方法
        // applicationContext.getBean("car");

        //使用@ComponentScan时，需要标记@Component，写id名
        //applicationContext.getBean("cat");
        //使用@Import导入时，需要写全类名
        // applicationContext.getBean("com.missile.bean.Dog");
        applicationContext.close();
    }

    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    private void printBeans(AnnotationConfigApplicationContext context) {
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void testProperty() {
        printBeans(annotationConfigApplicationContext);
        System.out.println("==============");
        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
        Person person = (Person) annotationConfigApplicationContext.getBean("person");
        System.out.println(person);
        annotationConfigApplicationContext.close();
    }

    @Test
    public void IOCTest_Autowired() {
        //1.创建IOC容器
        AnnotationConfigApplicationContext Context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

        BookService bean = Context.getBean(BookService.class);
        System.out.println(bean);
        //bean.print();
       /* BookDao bean1 = Context.getBean(BookDao.class);
        System.out.println(bean1);*/
        Boss bean1 = Context.getBean(Boss.class);
        System.out.println(bean1);
        Car bean2 = Context.getBean(Car.class);
        System.out.println(bean2);
        AColor bean3 = Context.getBean(AColor.class);
        System.out.println(bean3);

        Red bean4 = Context.getBean(Red.class);
        System.out.println(bean4);

        Context.close();
    }
}
