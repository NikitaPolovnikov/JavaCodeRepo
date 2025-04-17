package org.example;

import java.util.concurrent.*;

public class ComplexTaskExecutor {
    private final ExecutorService executor;

    public ComplexTaskExecutor(int numberOfTasks) {
        this.executor = Executors.newFixedThreadPool(numberOfTasks);
    }

    public void execute(int numberOfTasks) {
        CyclicBarrier barrier = new CyclicBarrier(numberOfTasks);
        for (int i = 0; i < numberOfTasks; i++) {
            executor.execute(new ComplexTask(barrier));
        }
    }
}
