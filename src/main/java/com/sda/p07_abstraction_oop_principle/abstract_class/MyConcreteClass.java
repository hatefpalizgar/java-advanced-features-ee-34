package com.sda.p07_abstraction_oop_principle.abstract_class;

// We can extend an abstract class
// But we are forced to implement ALL the abstract methods
public class MyConcreteClass extends MyAbstractClass {

    @Override
    public void abstractMethod() {
        System.out.println("inside abstractMethod() --> MyConcreteClass");
    }

}
