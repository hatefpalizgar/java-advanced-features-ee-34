package com.sda.p03_inheritance_oop_principle.example01;

// Class Dad inherits from class Person
//
public class Dad extends Person {
    // keyword 'this' -> objects of the current class
    // keyword 'super' -> objects of the super class

    public Dad(String name, int age, String color) {
        super(name, age, color); // give birth to the parent class first (call the superclass constructor)
    }

    @Override
    public void play() {
        System.out.println("Dad is playing golf");
    }

    @Override
    public void eat() {
        System.out.println("Dad is eating steak");
    }
}
