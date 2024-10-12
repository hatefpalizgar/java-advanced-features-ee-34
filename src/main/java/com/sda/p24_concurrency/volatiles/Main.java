package com.sda.p24_concurrency.volatiles;

public class Main {

    // changes to this MY_INT in one thread,
    // doesn't reflect in any other thread.
    // so, each thread uses a cached version of MY_INT and not a live reference to it
    // Therefore, even though ChangeMaker thread is changing MY_INT from 0 to 5,
    // ChangeListener thread is still seeing the cached MY_INT=0
    // Thus, ChangeListener thread runs forever because
    // local_value(0) == MY_INT(0)
    // private static int MY_INT = 0;

    // volatile keyword makes sure that the changes made in one thread,
    // immediately reflects in other threads
    private static volatile int MY_INT = 0;
    // the value of volatile variables will never be cached and all reads&writes
    // will be done from&to the main memory

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while(local_value < 5) {
                if (local_value != MY_INT) {
                    System.out.println("Got change for MY_INT: {" + MY_INT + "}");
                    local_value = MY_INT;
                }
            }
        }
    }

    static class ChangeMaker extends Thread  {
        @Override
        public void run() {
            int local_value = MY_INT;
            while(MY_INT < 5) {
                System.out.println("Incrementing MY_INT to {" + (local_value+1) + "}");
                MY_INT = ++local_value;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
