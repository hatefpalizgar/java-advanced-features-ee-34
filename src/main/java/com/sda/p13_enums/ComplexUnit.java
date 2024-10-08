package com.sda.p13_enums;

public enum ComplexUnit {
    METER(1),
    FOOT(1.3),
    CENTIMETER(10),
    INCH(2.3);

    private double value;

    ComplexUnit(double value) {
        this.value = value;
    }

    double convertToMeter() {
        return value;
    }
}
