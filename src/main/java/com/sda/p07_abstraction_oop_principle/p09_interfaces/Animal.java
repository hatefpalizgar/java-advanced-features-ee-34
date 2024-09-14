package com.sda.p07_abstraction_oop_principle.p09_interfaces;

public abstract class Animal {
    private int age;

    public Animal(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
