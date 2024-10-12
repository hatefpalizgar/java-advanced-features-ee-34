package com.sda.p24_concurrency.synchronization;

public class SeatTakerThread extends Thread {
    private Chair chair;

    public SeatTakerThread(Chair chair) {
        this.chair = chair;
    }

    @Override
    public void run() {
        try {
            chair.takeASeat();
        } catch (InterruptedException e) {
            System.out.println("Unable to take a seat by the thread: " + e);
        }
    }
}
