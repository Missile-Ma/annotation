package com.missile.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Missile
 * @Date 2021-02-03-23:06
 */
@Component
public class Car {
    public Car() {
        System.out.println("Car constructor.....");
    }

    public void init(){
        System.out.println("Car init.....");
    }

    public void destroy(){
        System.out.println("car destroy....");
    }
}
