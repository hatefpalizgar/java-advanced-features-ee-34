package com.sda.p24_concurrency.deadlock;

public class DeadlockThread  extends Thread {
    private Resource resource;

    public DeadlockThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        this.resource.acquire();
        // if you want to prevent deadlock to happen, you have to make threads release the locks
        try {
            Thread.sleep(5000);
            this.resource.release();
        } catch (InterruptedException e) {
            // ...
        }
    }
}
