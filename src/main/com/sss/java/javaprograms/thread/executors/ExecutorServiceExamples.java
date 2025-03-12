package src.main.com.sss.java.javaprograms.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;

public class ExecutorServiceExamples {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // Example 1: Runnable with FixedThreadPool
        System.out.println("--- Runnable with FixedThreadPool ---");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            final int taskNumber = i;
            fixedThreadPool.execute(() -> {
                System.out.println("Runnable Task " + taskNumber + " executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        fixedThreadPool.shutdown();
        fixedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS); // Wait for tasks to complete
        System.out.println("FixedThreadPool tasks finished.");

        // Example 2: Callable with CachedThreadPool and Future
        System.out.println("\n--- Callable with CachedThreadPool and Future ---");
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            final int taskNumber = i;
            Callable<String> callableTask = () -> {
                System.out.println("Callable Task " + taskNumber + " executed by " + Thread.currentThread().getName());
                Thread.sleep(1500);
                return "Result from Callable Task " + taskNumber;
            };
            futures.add(cachedThreadPool.submit(callableTask));
        }

        for (Future<String> future : futures) {
            System.out.println("Future result: " + future.get()); // Retrieve results
        }

        cachedThreadPool.shutdown();
        cachedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("CachedThreadPool tasks finished.");

        // Example 3: SingleThreadExecutor
        System.out.println("\n--- SingleThreadExecutor ---");
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 3; i++) {
            final int taskNumber = i;
            singleThreadExecutor.execute(() -> {
                System.out.println("SingleThread Task " + taskNumber + " executed by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        singleThreadExecutor.shutdown();
        singleThreadExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("SingleThreadExecutor tasks finished.");
    }
}