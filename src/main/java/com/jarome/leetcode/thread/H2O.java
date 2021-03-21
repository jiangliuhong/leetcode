package com.jarome.leetcode.thread;

import java.util.concurrent.Semaphore;

public class H2O {

    public H2O() {

    }

    private Semaphore semaphoreH = new Semaphore(1);
    private Semaphore semaphoreO = new Semaphore(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        semaphoreH.acquire();
        releaseHydrogen.run();
        if (semaphoreO.availablePermits() == 0) {
            semaphoreH.release();
        }
        semaphoreO.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        semaphoreO.acquire(2);
        releaseOxygen.run();
        semaphoreH.release();
    }
}