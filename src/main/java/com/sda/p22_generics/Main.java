package com.sda.p22_generics;

/*
 * ==============================================================================================
 *                                      Generics
 * ==============================================================================================
 *
 * Generics are a way to create reusable code that can be used with different types.
 * A generic type is a generic class or interface that is parameterized over types.
 *
 * There is a convention that the parameterized type name is a single uppercase letter.
 * Also, there is a convention specifying which letter should be used:
 *  E, T - element type
 *  K - key type
 *  V - value type
 *  T - type
 *  N - number type
 *  S, U, V if there are more parameterized types
 */

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        GenericBox<Car> boxWithACar = new GenericBox<>(car);

        Integer number = 10;
        GenericBox<Integer> boxWithAnInteger = new GenericBox<>(number);

        Garage<Vehicle> garage = new Garage<>(car);
        garage.repair(); // car is repaired

        LuxuryCar luxuryCar = new LuxuryCar();
//        GenericBox<Vehicle> box1 = new GenericBox<>(luxuryCar);
//        GenericBox<Car> box1 = new GenericBox<>(luxuryCar);
        GenericBox<LuxuryCar> box1 = new GenericBox<>(luxuryCar);

        // with "? extends LuxuryCar" we're limiting our GenericBox to only accept
        // subclasses on LuxuryCar
        GenericBox<? extends LuxuryCar> box2 = new GenericBox<>(luxuryCar);
        // GenericBox<? extends LuxuryCar> box3 = new GenericBox<>(car); // because Car doesn't extend LuxuryCarr


        // with "? super LuxuryCar" we're limiting our GenericBox to only accept
        // superclasses of LuxuryCar
        GenericBox<? super LuxuryCar> box4 = new GenericBox<>(luxuryCar);
        GenericBox<? super LuxuryCar> box5 = new GenericBox<>(car);
    }

}
