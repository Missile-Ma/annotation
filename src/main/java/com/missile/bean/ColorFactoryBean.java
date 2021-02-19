package com.missile.bean;

import org.springframework.beans.factory.FactoryBean;


/**
 * @author Missile
 * @Date 2021-02-03-22:55
 * 定义一个工厂Bean
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    public Color getObject() throws Exception {
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    //控制是否单例 true为单例
    public boolean isSingleton() {
        return true;
    }
    //返回一个Color对象，这个对象会添加到容器中

}
