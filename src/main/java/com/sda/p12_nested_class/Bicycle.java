package com.sda.p12_nested_class;

/* ========================================================================================== */
//                                    Inner Class
/* ========================================================================================== */

/*
* In Java, it is possible to declare classes inside other classes.
* We call these classes, 'nested class'. They can be declared as:
*  1. non-static class (so-called non-static or 'inner class')
*  2. static class (so-called static nested) using static keyword.
*
* I suggest to read more in depth examples in the following link: https://docs.java.en.sdacademy.pro/javaAdvanced/inner_classes/#inner-classes
 Also once mastered the concepts of inner classes, take a look at 'local classes' here: https://docs.java.en.sdacademy.pro/javaAdvanced/local_classes/#local-classes
*/
public class Bicycle {


    private int maxSpeed;

    public Bicycle(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }


    public static class StaticInnerClass {
        public void doSomething(){
            System.out.println("I am a static inner class");
        }
    }



    public class Wheel{
        public void slowDown() {
            // we can reference the outer class's field
            maxSpeed *= 0.5;
            System.out.println("Wheel's max speed is now: " + maxSpeed);
        }

    }


}
