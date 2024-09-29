package com.sda.p24_concurrency;

public class RunnableThread implements Runnable {

    @Override
    public void run() {
        System.out.println("inside RunnableThread");
        System.out.println("name of Runnable Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("RunnableThread is terminated");
    }
}
