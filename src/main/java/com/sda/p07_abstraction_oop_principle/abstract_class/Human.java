package com.sda.p07_abstraction_oop_principle.abstract_class;

public abstract class Human {
    private String name;

    // abstract methods
    public abstract void eat();
    public abstract void breathe();

    // concrete method
    public void walk() {
        System.out.println("walking...");
    }
}
