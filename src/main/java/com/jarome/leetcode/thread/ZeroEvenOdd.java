package com.jarome.leetcode.thread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    private Semaphore semaphoreZ = new Semaphore(1);
    private Semaphore semaphoreE = new Semaphore(0);
    private Semaphore semaphoreO = new Semaphore(0);

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphoreZ.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                semaphoreO.release();
            } else {
                semaphoreE.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i < n; i++) {
            semaphoreE.acquire();
            i++;
            printNumber.accept(i);
            semaphoreZ.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphoreO.acquire();
            i++;
            printNumber.accept(i);
            semaphoreZ.release();
        }
    }
}
