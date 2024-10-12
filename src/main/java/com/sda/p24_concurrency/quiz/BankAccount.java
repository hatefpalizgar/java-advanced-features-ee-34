package com.sda.p24_concurrency.quiz;

public class BankAccount {
    private long balance;

    public synchronized void deposit(long amount) {
        balance += amount;
    }

    public synchronized void withdraw(long amount) {
        balance -= amount;
    }

// when a synchronized method is called upon an object (X), before getting into this method, the
// thread holds the lock of the object(X)
// for any single object, we have only one dedicated lock.
// once a synchronized method is running, no other synchronized method can be started on the same
// object (X) because no other method is able to get the lock of the object (X)

    // TODO: is it right or wrong?
    // 1 - Two different threads can never call deposit() at the same time on the same object -> right / wrong
    // 2 - If one thread is busy running deposit(), it means no other thread has started withdraw() -> right / wrong
    // 3 - If one thread is running deposit() of object X, other thread can not run deposit() on the same X object -> right / wrong
    // 4 - If one thread is running deposit() of object X, other thread can not run withdraw() on the same X object -> right / wrong

}
