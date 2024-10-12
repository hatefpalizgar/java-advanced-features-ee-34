package com.sda.p24_concurrency.synchronization;

// Simulation of 'Musical Chairs' game
public class Main {
    public static void main(String[] args) {
        Chair chair = new Chair(1);

        Thread t1 = new SeatTakerThread(chair);
        Thread t2 = new SeatTakerThread(chair);

        t1.start();
        t2.start();
    }
}
