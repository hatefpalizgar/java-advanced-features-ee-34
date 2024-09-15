package com.sda.p12_nested_class;

public class Main {
    public static void main(String[] args) {

        Bicycle myBike = new Bicycle(40);

        System.out.println(myBike.getMaxSpeed());

        // weird way of instantiating an inner class
        // There is no point at instantiating an inner class (avoid it)
        Bicycle.Wheel aWheel = myBike.new Wheel();
        aWheel.slowDown();

        // creating an instance of a static inner class
        Bicycle.StaticInnerClass myClass = new Bicycle.StaticInnerClass();
        myClass.doSomething();
    }
}
