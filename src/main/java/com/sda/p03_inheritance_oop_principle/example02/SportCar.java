package com.sda.p03_inheritance_oop_principle.example02;

public class SportCar extends Car{

    public SportCar(String model) {
        super(model); // this calls Car constructor
    }

    public void boostSpeed() {
        System.out.println("invoked boostSpeed() on SportCar");
    }

    @Override
    public void turnOnEngine() {
        System.out.println("invoked turnOnEngine on SportCar class");
    }


}
