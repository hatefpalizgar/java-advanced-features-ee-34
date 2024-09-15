package com.sda.p11_anonymous_class;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

// =================== Anonymous class using abstract class ====================
        Cat kit = new Cat("Kitty");

        // below is an ad-hoc object creation
        // here, we are instantiating and extending Animal at the same time.
        // we're creating an instance of Animal(abstract class), with the specified name "dog" and
        // providing implementation for makeSound() method

        // NB! "dog" is the name of the instance variable we have created NOT the name of the class
        // The concrete class here has no name (ANONYMOUS)
        Animal dog = new Animal("Rex") {
            @Override
            public void makeSound() {
                System.out.println("Woof Woof ...");
            }
        };

        dog.makeSound();

        // anonymous class can be useful when you need to use a class just once,
        // or when you need to override just a few methods of a class or interface

        // Cons:
        // They can make code less readable, especially if the anonymous class is large or has lots of methods.
        // so, use them wisely.

        // FYI, later we will use anonymous class concept in Lambda expression.

        // =================== Anonymous class using interface ====================
        // Playable toy = new Playable(); not possible
        Playable toy = new Playable() {
            @Override
            public void play() {
                // ...
            }
        };

        // toy is a Playable object.
        // toy has no class name. it's class name is anonymous and unknown.


        // A real world example of using anonymous class from JavaFX library
        Button button = new Button("Click me!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked");
            }
        });


    }
}
