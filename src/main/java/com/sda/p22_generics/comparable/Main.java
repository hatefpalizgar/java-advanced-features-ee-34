package com.sda.p22_generics.comparable;

public class Main {
    public static void main(String[] args) {

        Macbook macbook1 = new Macbook(5);
        Macbook macbook2 = new Macbook(12);

        if (macbook1.compareTo(macbook2) > 0) { // if macbook1 is greater than macbook2
            System.out.println("Macbook1 is faster");
        } else if (macbook1.compareTo(macbook2) < 0) {
            System.out.println("Macbook1 is slower");
        } else {
            System.out.println("Macbook1 is as powerful as Macbook2");
        }
    }

}
