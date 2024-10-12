package com.sda.p24_concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    // Non-atomic count variable
    // since count is not atomic,
    // it is possible for multiple threads to interfere with each other and
    // change this count value, producing incorrect result
    // private static int count = 0;

    // Atomic count variable
    private static AtomicInteger count = new AtomicInteger(0);

    // We say an operation is atomic if, while it is being performed,
    // another thread cannot read or change the values of the variables being changed
    // something like synchronized (which applied to methods and blocks) but for variables

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    // count++;
                    count.incrementAndGet();
                }
            }
        };


        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // handle exception
        }

        System.out.println("Final count: " + count);
    }
}
