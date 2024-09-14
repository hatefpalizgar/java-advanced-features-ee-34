package com.sda.p03_inheritance_oop_principle.example02;

public class Main {
    public static void main(String[] args) {
        Car aCar = new Car("Ford");
        System.out.println(aCar.getModel()); // Ford
        aCar.turnOnEngine(); // invoked turnOnEngine on Car class

        // any instance of SportCar inherits everything from its parent Car
        // any SportCar IS-A Car
        // BUT we can not say any Car IS-A SportCar
        SportCar aSportCar = new SportCar("Subaru");
        System.out.println(aSportCar.getModel()); // Subaru
        aSportCar.turnOnEngine(); // invoked turnOnEngine on SportCar class
        aSportCar.boostSpeed(); // invoked boostSpeed() on SportCar


        System.out.println(aCar);  // ???
        System.out.println(aSportCar); // ???
    }
}
