package com.sda.p05_composition;

/*
* Composition:
* This is a stricter form of aggregation.
* It occurs when the two classes you associate are mutually dependent and can't exist without
* each other.
* For example: take a Car and an Engine classes:
*   A Car cannot run without an Engine, while an Engine also can't function without
*   being built into the car.
*
* Composition is also called "PART-OF" relationship.
* */
public class Main {
    public static void main(String[] args) {
        House house = new House(3); // House with a maximum 3 rooms
        house.addRoom("Living room");
        house.addRoom("Kitchen");
        house.addRoom("Bedroom");
        house.addRoom("Pantry");

        System.out.println("House contains rooms:");
        // iterate over the rooms array
        for (Room r: house.getRooms()) {
            if(r != null) {
                System.out.println("- " + r.getName());
            }
        }

        // If we destory the house, all the room objects inside of it will also
        // be destroyed and we can't access them any more (house and room are dependent)
    }
}
