package com.sda.p24_concurrency;

public class Main {

    /* ========================================================================= */
    //                     Creating and Starting Threads
    /* ========================================================================= */
    /*
   To create a thread in Java, you can do one of the following:
      1. Extend the Thread class and override its run() method
      2. Implement the Runnable interface and pass it to a Thread object in the constructor
  */
    public static void main1(String[] args) throws InterruptedException {
//        System.out.println("Main thread starts: " + Thread.currentThread().getName());
//        Thread.sleep(3000);
//        System.out.println("Main thread is still running");
//        Thread.sleep(3000);
//        System.out.println("Main thread ends");

        StopWatchThread myStopWatch = new StopWatchThread();
        StopWatchThread myStopWatch2 = new StopWatchThread();
        // NEVER call run() of Thread yourself; if you just call run() method,
        // it will be executed in the same thread as the rest of your program, and
        // your program will not run concurrently
        // myStopWatch.run();

        /*
        A thread is started only by calling its start() method;
        When you call the start() method on a Thread object, it does the following:

         1. Creates a new, concurrent thread of execution.
         2. Calls the run() method of the Thread object in the new thread.

         The new thread is created by the operating system (Platform Thread),
         and the Java runtime is responsible for managing it and scheduling it to run.
        */

        // order of execution is NOT guaranteed
        myStopWatch.start();
        myStopWatch2.start();

        RunnableThread myRunnableThread = new RunnableThread();
        // myRunnableThread.run();
        // myRunnableThread.start();  doesn't exist

        Thread myRunnableThreadUsingThreadClass = new Thread(myRunnableThread);
        myRunnableThreadUsingThreadClass.start();

        /* ========================================================================= */
        //                           Stopping Threads
        /* ========================================================================= */

        // How to stop a thread by calling the stop() method (deprecated as might cause data corruption)
        // or by using other methods such as interrupt() or volatile variables (volatile boolean flags to
        // stop run method execution)
        // Refer to volatiles package

        /* ========================================================================= */
        //                States for Threads (running, waiting, dead)
        /* ========================================================================= */
        // The five states are as follows:
        // New: A thread is in this state when it has been created, but the start() method has not yet
        // been called on it
        // Runnable: A thread is in this state when it is eligible to run, but the Java runtime has not
        // yet selected it to run. This is also known as the "ready" state
        // Running: A thread is in this state when it is currently executing its run() method
        // Blocked (Non-runnable state): A thread is in this state when it is waiting for a resource that
        // is currently held by another thread
        // Dead or Terminated: A thread is in this state when it has completed execution of its run()
        // method or when it has been stopped

        /* ========================================================================= */
        //                              Synchronization
        /* ========================================================================= */
        /*
          1. What is synchronization?
              Synchronization is a mechanism that allows multiple threads to access shared resources in a controlled manner,
              preventing race conditions and data corruption.

          2. Why is synchronization important? Without synchronization, it is possible for multiple
          threads to access a shared resource simultaneously, which can lead to race conditions and data corruption.
          Synchronization ensures that only one thread can access a shared resource at a time, preventing these issues.

          */

    }


    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(); // counter is the shared resource
        Thread t1 = new IncrementThread(counter);
        Thread t2 = new IncrementThread(counter);

        t1.start();
        t2.start();

        // tell 'main' thread to wait for t1
        t1.join();
        t2.join();

        System.out.println(counter.getCount()); // no guarantee on getting 2000
    }




    static class Counter {
        private int count = 0;

        // RACE CONDITION: when two or more threads try to access a shared resource concurrently,
        // and the outcome of the program depends on the interleaving of the threads
        // In this example, increment() method is being used by multiple threads at the same time,
        // and if we don't use 'synchronized' keyword, we will end up in RACE CONDITION.
        // This increment() method is called the CRITICAL SECTION
        public synchronized void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    static class IncrementThread extends Thread {
        private Counter counter;

        public IncrementThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        }
    }


    // 3. How to synchronize a method:
    class MyClass {
       public synchronized void doSomething() {
           // code to be synchronized
       }
    }

    // 4. How to synchronize a block of code
    class MyClass2 {
        private Object lock = new Object();

        public void doSomething() {
            // some codes that not need to be synchronized
            // ...
            synchronized (lock){
                // some codes that need to be synchronized
                // ...
            }
        }
    }

    // Refer to synchronization package for more example




    /* ========================================================================= */
    //                              Thread Pool
    /* ========================================================================= */
    // Refer to threadpool package

}
