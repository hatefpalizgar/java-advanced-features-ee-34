package com.sda.p13_enums;

public class Main {
    public static void main(String[] args) {
        // name variable can take any value
        String name = "John";
        name = "Adam";
        name = "Tom";

        // but sometimes, we require special type of variables that can only hold specific/certain values
        SimpleUnit unit = SimpleUnit.CENTIMETER;
        System.out.println(unit);

        System.out.println(SimpleUnit.INCH);
        System.out.println(SimpleUnit.FOOT);

        ComplexUnit complexUnit = ComplexUnit.INCH;
        System.out.println(complexUnit.convertToMeter()); // 2.3


        // Goal of enums:
        // Let's say we have an application that only accepts a predefined set of colors
        // like red, blue, green
        // using enums, we can restrict developers to not use any other color that these defined one
        System.out.println(Color.BLUE);
        System.out.println(Color.GREEN);
        System.out.println(Color.RED);
        // System.out.println(Color.YELLOW);

        // Write an application that prints weekdays using enums
        // also display their corresponding day number (Monday = 1)
        System.out.println(Weekday.MONDAY + " = " + Weekday.MONDAY.ordinal()); // ordinal is the order of enum in the enum values list
        System.out.println(Weekday.FRIDAY + " = " + Weekday.FRIDAY.getOrder());
        System.out.println(Weekday.TUESDAY.name()); // name is the actual name of the enum in the enum values list


        // TODO:
        // Write an application for a traffic light that has RED, GREEN, YELLOW with
        // some message to tell the drivers what to do.
        // simulate a scenario of red light is turned on,
        // show the driver the message

        // TrafficLight light = TrafficLight.RED;
        // System.out.println(light.getMessage()); // Stop behind the line
    }

}


enum Weekday {
    MONDAY(1), // ordinal = 0
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7); // ordinal = 6

    private int order;

    Weekday(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }
}
