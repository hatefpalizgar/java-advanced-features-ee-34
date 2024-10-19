package com.sda.p25_functional_interfaces.method_references;

/**
 * <h1>Method reference to a constructor – <code> Class::new </code> </h1>
 * */
public class Example04 {
    public static void main(String[] args) {
//        Manufacture factory = (number) -> new Battery(number); // impl.1 using lambda expression
        Manufacture factory = Battery::new; // impl.2 using method references

        factory.manufacture(100);
    }
}


@FunctionalInterface
interface Manufacture {
    Battery manufacture(int value);
}



class Battery {
    public Battery(int capacity) {
        System.out.println("Battery is created with capacity: " + capacity);
    }
}
