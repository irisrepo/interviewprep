package src.main.com.sss.java.javaprograms.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HashMapTest {
    private static Map<String, Integer> hashMap = new HashMap<>(); // Use ConcurrentHashMap
    private static int MIN_THREAD = 5;
    private static int NUM_ITERFATIONS = 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(MIN_THREAD);
        for (int i = 0; i < MIN_THREAD; i++) {
            executorService.execute(insertRecord());
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS); // Better than a busy-wait loop
        System.out.println("Hashmap size " + hashMap.size());
    }

    private static Runnable insertRecord() {
        return () -> {
            for (int i = 0; i < NUM_ITERFATIONS; i++) {
                hashMap.put(Thread.currentThread().getName() + "-" + i, i); // Include 'i' to demonstrate changes
            }
        };
    }
}