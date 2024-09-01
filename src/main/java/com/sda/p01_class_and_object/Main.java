package com.sda.p01_class_and_object;

public class Main {
    public static void main(String[] args) {
        // Let's create two instances(objects) of the class Building
        Building b1 = new Building("b1", 4, 2); // creating an object == instantiation
        Building b2 = new Building("b2", 5, 3);

        System.out.println(b1.name); // b1
        System.out.println(b2.numberOfRooms); // 3

        b1.name = "Rosetta";
        System.out.println(b1.name); // Rosetta
    }
}
