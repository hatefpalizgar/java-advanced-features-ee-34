package com.sda.p24_concurrency.synchronization;

public class Chair {
    private int availableSeats;

    public Chair(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    // critical section: a part which we don't want several methods to run/call at the same time
    public synchronized void takeASeat() throws InterruptedException {
        if (availableSeats > 0) {
            Thread.sleep(100);
            this.availableSeats--;
            System.out.println("Taking a seat");
            System.out.println("Free seats available: " + this.availableSeats);
        } else {
            System.out.println("No more free seats. All taken!");
        }
    }
}
