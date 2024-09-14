package com.sda.p07_abstraction_oop_principle.p09_interfaces;

public class Main {
    public static void main(String[] args) {
        // similar to abstract classes, you can not instantiate interfaces
        // Loveable loveable = new Loveable(); This won't work

        Loveable girl = new Girl("White", "Anna");
        Loveable dog = new Dog(2, "Circular");

        // Thanks to interface Loveable, we can say any Girl object and Dog object is a Loveable object
        showLove(girl);
        showLove(dog);
    }

    //  Below is redundant and duplicate, let's get rid of it
//    public static void showLove(Dog dog) {
//        dog.love();  // showing love to a dog
//    }
//
//    public static void showLove(Girl girl) {
//        girl.love(); // showing love to a girl
//    }

    public static void showLove(Loveable loveable) {
        // because of Loveable contract
        // we are %100 sure that any Loveable object
        // has love() method
        loveable.love();
    }


    // Overview:
    // In this code, we are abstracting away the love() implementation from its definition,
    // in other words, we separated `HOW` from `WHAT`
}
