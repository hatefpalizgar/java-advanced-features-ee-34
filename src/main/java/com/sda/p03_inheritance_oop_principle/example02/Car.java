package com.sda.p03_inheritance_oop_principle.example02;

public class Car {
    // field/properties
    private String model;

    // constructor
    public Car(String model) {
        this.model = model;
    }

    // custom method
    public void turnOnEngine() {
        System.out.println("invoked turnOnEngine on Car class");
    }

    // getters & setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Every Class in Java, inherit another class called Object by default
    // So, this toString() method is overriding the inherited toString() of Object class
    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                '}';
    }

}
