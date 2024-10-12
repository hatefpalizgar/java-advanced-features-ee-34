package com.sda.p24_concurrency.deadlock;

public class Resource {
    private boolean isLocked = false;

    public synchronized void acquire() {
        System.out.println("Thread[" + Thread.currentThread().getName() + "]: acquiring lock" );
        while(isLocked) { // as long as this resource is locked by another thread
            try {
                System.out.println("Thread[" + Thread.currentThread().getName() + "]: waiting for lock to be released");
                wait(); // this puts the current thread to sleep, and only wakes up when the other thread releases the lock and notifies it
            } catch (InterruptedException e) {
                // handle exception
            }
        }
        isLocked = true; // to declare to other threads that this resource is now acquired by this thread
        System.out.println("Thread[" + Thread.currentThread().getName() + "]: lock is acquired" );
    }

    public synchronized void release() throws InterruptedException {
        isLocked = false;
        System.out.println("Thread[" + Thread.currentThread().getName() + "]: lock is released" );
        // after making isLocked=false, we should notify other threads which are waiting
        notify(); // this awakens all threads that have called wait()
    }

}
