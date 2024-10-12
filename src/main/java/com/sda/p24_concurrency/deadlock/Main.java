package com.sda.p24_concurrency.deadlock;

public class Main {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Thread t1 = new DeadlockThread(resource);
        Thread t2 = new DeadlockThread(resource);

        t1.start();
        t2.start();
    }
}
