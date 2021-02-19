package com.missile.config;

import com.missile.bean.AColor;
import com.missile.bean.Car;
import com.missile.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.awt.print.Book;

/**
 * @author Missile
 * @Date 2021-02-19-22:14
 * 自动装配；
 * spring利用依赖注入DI完成对IOC容器中各个组件的依赖关系赋值
 * 一个组件需要用到另一个属性，只需要在属性上标记autowired，就会自动去找，自动装配，找到就赋值，
 */
@Configuration
@ComponentScan({"com.missile.service", "com.missile.controller","com.missile.dao","com.missile.bean"})
public class MainConfigOfAutowired {
    @Primary
    @Bean(value = "bookDao2")
    public BookDao bookDao(){
        BookDao bookDao=new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }
    @Bean
    public AColor aColor(Car car){
        AColor aColor=new AColor();
        aColor.setCar(car);
        return aColor;
    }
}
