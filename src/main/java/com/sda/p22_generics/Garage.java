package com.sda.p22_generics;

// T: stands for Type
// Garage is "Parameterized" over T
public class Garage<T extends Vehicle> {
    private T vehicle;

    public Garage(T vehicle) {
        this.vehicle = vehicle;
    }

    public void repair() {
        this.vehicle.repair();
    }
}
