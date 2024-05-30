package com.wipro.Assignments;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrimeNumberCalculator {

    public static void main(String[] args) {
        int upperLimit = 100000;
        int numberOfThreads = 4;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
try {
            List<Integer> primeNumbers = findPrimes(upperLimit, executorService);
            String filename = "primescal.txt";
            System.out.println("Writing to file: " + new java.io.File(filename).getAbsolutePath());
            writePrimesToFileAsync(primeNumbers, filename, executorService);
        }
 finally {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
            }
        }
    }

    public static List<Integer> findPrimes(int upperLimit, ExecutorService executorService) {
        List<CompletableFuture<List<Integer>>> futures = new ArrayList<>();
        int chunkSize = upperLimit / 4;

        for (int i = 0; i < 4; i++) {
            int start = i * chunkSize + 1;
            int end = (i == 3) ? upperLimit : start + chunkSize - 1;
            futures.add(CompletableFuture.supplyAsync(() -> calculatePrimes(start, end), executorService));
        }

        List<Integer> primeNumbers = new ArrayList<>();
        futures.forEach(future -> {
            try {
                primeNumbers.addAll(future.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return primeNumbers;
    }

    public static List<Integer> calculatePrimes(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void writePrimesToFileAsync(List<Integer> primes, String filename, ExecutorService executorService) {
        CompletableFuture.runAsync(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (int prime : primes) {
                    writer.write(prime + System.lineSeparator());
                }
                System.out.println("Prime numbers written to " + filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, executorService);
    }
}



