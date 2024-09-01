package com.sda.p01_class_and_object;


public class Building {
    // properties/instance fields
    String name;
    int numberOfFloors;
    int numberOfRooms;

    // If you don't declare a constructor,
    // Java creates a default (no-arg) constructor
    // but if you declare any other constructor,
    // that constructor will replace the no-arg constructor
//    public Building() {
//
//    }

    // all-args constructor
    public Building(String name, int floors, int rooms) {
        this.name = name;
        this.numberOfFloors = floors;
        this.numberOfRooms = rooms;
    }


}
