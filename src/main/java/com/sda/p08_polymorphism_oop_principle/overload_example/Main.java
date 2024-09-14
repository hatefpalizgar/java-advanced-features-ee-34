package com.sda.p08_polymorphism_oop_principle.overload_example;

/*
* Polymorphism:
* Poly: multiple
* morph: shape/face
*
* Polymorphism is the ability of an object to take on many shapes/forms.
* The most common use of polymorphism in OOP occurs when a parent class reference is used to
* refer to a child class object.
* In other words, the child class can be used as the parent class.
* This is much like a child can be used as a parent in the real world.
*
* Let's say you as the child try to show up at the parent's party and all you have to do is to
* mimic your dad's behaviours.
*
* In Java, polymorphism is achieved in two ways:
*
* 1. Method overloading (compile-time polymorphism)
*   Method overloading happens when various methods with SAME name but
*   DIFFERENT number, order or types of parameters are present in a class.
*   Learn more: https://www.softwaretestinghelp.com/polymorphism-in-java/#:~:text=overloading%20in%20general.-,Method%20Overloading%20In%20Java,have%20%E2%80%9Coverloaded%E2%80%9D%20the%20methods
*
* 2. Method overriding (run-time polymorphism)
*   Method overriding occurs when a child class overrides a method of its parent
*/
public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        calc.add(3, 4);
        calc.add("Hello", "World!");
    }
}


// We can have multiple classes in a single java file
// but ONLY one of them can be public,
// and that's the class with the same name as the java file name
class Calculator {
    // method to add two integers
    public void add(int a, int b) {
        System.out.println("addition of two numbers is: " + (a + b));
    }

    // method to add two strings
    public void add(String a, String b) {
        System.out.println("addition of two strings is: " + a + b);
    }
}
