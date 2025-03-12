package src.main.com.sss.java.javaprograms.thread;

import java.util.LinkedList;

public class SimpleProducerConsumer {

    public static void main(String[] args) {
        LinkedList<Integer> buffer = new LinkedList<>();
        int capacity = 3;

        Thread producer = new Thread(() -> {
            int value = 0;
            while (true) {
                synchronized (buffer) {
                    while (buffer.size() == capacity) {
                        try { buffer.wait(); } catch (InterruptedException e) { return; }
                    }
                    buffer.add(value);
                    System.out.println("Produced: " + value);
                    value++;
                    buffer.notifyAll();
                }
                try { Thread.sleep(200); } catch (InterruptedException e) { return; }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                synchronized (buffer) {
                    while (buffer.isEmpty()) {
                        try { buffer.wait(); } catch (InterruptedException e) { return; }
                    }
                    int value = buffer.removeFirst();
                    System.out.println("Consumed: " + value);
                    buffer.notifyAll();
                }
                try { Thread.sleep(300); } catch (InterruptedException e) { return; }
            }
        });

        producer.start();
        consumer.start();
    }
}