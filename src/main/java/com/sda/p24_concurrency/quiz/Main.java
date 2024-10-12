package com.sda.p24_concurrency.quiz;

// How many threads do we have here? 5 threads: main thread + line 7,8,9,10

// Tell what is the output without running the code?


public class Main {
    public static void main(String[] args) {
        new Thread(new R()).start();
        new T().start();
        new Thread(new R()).start();
        new T().start();

        for (char c = 'a'; c < 'z'; c++) {
            System.out.println(c + " " + Thread.currentThread().getName());
        }
    }
}


class T extends Thread {
    @Override
    public synchronized void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

class R implements Runnable {
    @Override
    public synchronized void run() {
        for (char c = 'A'; c < 'Z'; c++) {
            System.out.println(c);
        }
    }
}
