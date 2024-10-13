package com.sda.p25_functional_interfaces.built_in_jdk_func_interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/*
* Consumer consumes value T. This FI (func. interface) always takes an argument T and never returns anything.
* Consumer has an abstract method called accept()
* */
public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<Person> personConsumer = (p) -> {
            System.out.println(p.getName());
            System.out.println(p.getAge());
        };

        Person mary = new Person("Mary", 22);

        personConsumer.accept(mary);


        Consumer<String> stringConsumer = str -> System.out.println(str.toUpperCase());
        stringConsumer.accept("Hello World"); // HELLO WORLD

        // an example of how JDK uses Consumer in the forEach method
        List<Person> list = new ArrayList<>();
        list.add(new Person("Toby", 35));
        list.add(new Person("Rose", 20));
        list.add(new Person("Tom", 21));

        list.forEach(personConsumer); // consume each member of the list collection using personConsumer

    }

}

/**
 *
 * @see com.sda.p25_functional_interfaces.built_in_jdk_func_interfaces.SupplierExample
 * */
