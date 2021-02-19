package com.missile.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Missile
 * @Date 2021-02-03-22:05
 */
public class Dog {
    public Dog() {
        System.out.println("Dog constructor....");
    }
    @PostConstruct//对象创建并赋值之后
    public void init(){
        System.out.println("Dog PostConstruct Method....");
    }
    @PreDestroy//移除对象之前
    public void destroy(){
        System.out.println("Dog PreDestroy Method...");
    }

}
