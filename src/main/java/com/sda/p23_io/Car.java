package com.sda.p23_io;

import java.io.Serializable;
import java.util.StringJoiner;

public class Car implements Serializable {

    // TODO: Google what is serialVersionUID in Java, what? why?
    private static final long serialVersionUID = 1L;

    private String model;
    private double price;
    private String color; // this field is added after storing car as file

    public Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("model='" + model + "'")
                .add("price=" + price)
//                .add("color='" + color + "'")
                .toString();
    }
}
