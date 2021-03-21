package com.jarome.leetcode.thread;

import java.util.concurrent.Semaphore;

public class FooBar {

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private Semaphore semaphore1 = new Semaphore(0);
    private Semaphore semaphore2 = new Semaphore(0);

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            if (i > 0) {
                semaphore1.acquire();
            }

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();

            semaphore2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphore1.release();
        }
    }
}
