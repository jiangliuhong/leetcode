package com.jarome.leetcode;

public class MyCircularQueue {

    private int[] queue;
    private int head;
    private int total;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.total = k;
        this.head = 0;
        this.size = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.size++;
        int tail = getTail();
        this.queue[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.size--;
        this.head = (this.head + 1) % this.total;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.queue[this.head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int tail = getTail();
        return this.queue[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.total == this.size;
    }

    private int getTail() {
        return (this.head + this.size - 1) % this.total;
    }

}
