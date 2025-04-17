package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue queue = new BlockingQueue(5);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Производитель
        executor.submit(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    String item = "Item";
                    queue.enqueue(item);
                    System.out.println("Produced. Queue Size: " + queue.size());
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Потребитель
        executor.submit(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.dequeue();
                    System.out.println("Consumed. Queue Size: " + queue.size());
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread.sleep(5000);
        executor.shutdown();
    }
}
