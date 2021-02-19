package com.missile.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Missile
 * @Date 2021-02-19-22:59
 */
@Component

public class Boss {
    private Car car;

    public Car getCar() {
        return car;
    }
    //@Autowired//默认加在IOC容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值操作
/*    public Boss() {
    }*/

    //@Autowired//标注在方法上，Spring容器创建当前对象，就会调用方法，完成赋值；方法使用的参数，自定义类型的值从IOC容器中获取
    public void setCar(Car car) {
        this.car = car;
    }

    public Boss(@Autowired Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
