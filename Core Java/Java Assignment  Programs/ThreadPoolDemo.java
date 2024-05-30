package com.wipro.Assignments;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CalculationTask implements Runnable {
    private final int taskId;

    public CalculationTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
        long result = performComplexCalculation(taskId);
        System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName() + " with result: " + result);
    }

    private long performComplexCalculation(int n) {
        long sum = 0;
        for (int i = 0; i < n * 1000; i++) {
            sum += i;
        }
        return sum;
    }
}

class IOTask implements Runnable {
    private final int taskId;

    public IOTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("I/O Task " + taskId + " started by " + Thread.currentThread().getName());
        simulateIOOperation();
        System.out.println("I/O Task " + taskId + " completed by " + Thread.currentThread().getName());
    }

    private void simulateIOOperation() {
        try {
            Thread.sleep(2000); // Simulate I/O operation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("I/O Task interrupted");
        }
    }
}

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Submit Calculation Tasks
        for (int i = 1; i <= 5; i++) {
            executorService.submit(new CalculationTask(i));
        }

        // Submit I/O Tasks
        for (int i = 1; i <= 3; i++) {
            executorService.submit(new IOTask(i));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        System.out.println("All tasks completed");
    }
}




