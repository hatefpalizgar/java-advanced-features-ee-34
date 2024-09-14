package com.sda.p07_abstraction_oop_principle.abstract_class;

/*
* Abstract class in Java:
* 1. should be declared using `abstract` keyword
* 2. can have 0 or more fields
* 3. can have 0 or more abstract methods
* 4. can have 0 or more concrete methods
* 5. can have constructor
*/
public abstract class MyAbstractClass {
    private String name;

    // abstract method: a method without any implementation/body
    public abstract void abstractMethod();

    public void concreteMethod() {
        System.out.println("inside concreteMethod() --> MyAbstractClass");
    }
}
