package org.example;

public class BlockingQueue {

    private final Object[] items;
    private int count = 0;
    private int enqueueIndex = 0;
    private int dequeueIndex = 0;

    public BlockingQueue(int capacity) {
        this.items = new Object[capacity];
    }

    public synchronized void enqueue(Object item) throws InterruptedException {
        while (count == items.length) {
            wait();
        }

        items[enqueueIndex] = item;
        enqueueIndex = (enqueueIndex + 1) % items.length;
        count++;

        notifyAll();
    }

    public synchronized Object dequeue() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        Object item = items[dequeueIndex];
        count--;
        notifyAll();
        return item;
    }

    public synchronized int size() {
        return count;
    }
}
