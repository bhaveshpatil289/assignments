package com.wipro.Assignments;

public class ImmutableShareThreads {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Runnable decrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(decrementTask);
        Thread thread3 = new Thread(incrementTask);
        Thread thread4 = new Thread(decrementTask);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + counter.getCount());

        // Demonstrating usage of ImmutableData
        ImmutableData data = new ImmutableData(42);
        System.out.println("Immutable Data Value: " + data.getValue());
    }
}




