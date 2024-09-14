package com.sda.p07_abstraction_oop_principle.abstract_class;

public class Main {
    public static void main(String[] args) {

        // We can not instantiate an abstract class
        // MyAbstractClass myAbstractClass = new MyAbstractClass();

        MyConcreteClass myConcreteClass = new MyConcreteClass();
        myConcreteClass.concreteMethod();
        myConcreteClass.abstractMethod();

        // We can not instantiate a Human object
        // Human human = new Human();

        Girl girl = new Girl();
        girl.eat();
        girl.breathe();
    }
}
