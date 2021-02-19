package com.missile.bean;

/**
 * @author Missile
 * @Date 2021-02-19-23:12
 */
public class AColor {
    private Car car;


    @Override
    public String toString() {
        return "AColor{" +
                "car=" + car +
                '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
