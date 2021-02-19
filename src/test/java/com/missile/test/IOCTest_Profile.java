package com.missile.test;

import com.missile.bean.*;
import com.missile.condition.MainConfigOfLifeCycle;
import com.missile.config.MainConfigOfAutowired;
import com.missile.config.MainConfigOfProfile;
import com.missile.config.MainConfigOfPropertyValues;
import com.missile.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.sql.DataSource;

/**
 * @author Missile
 * @Date 2021-02-03-23:08
 */
public class IOCTest_Profile {
    @Test
    public void test1() {
        //创建IOC容器
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        System.out.println("IOC创建完成。。。。。");

        String[] namesForType = context.getBeanNamesForType(DataSource.class);
        for (String s : namesForType) {
            System.out.println(s);
        }
        context.close();
    }
}
