package com.jarome.leetcode.thread;

import java.util.concurrent.Semaphore;

public class Foo2 {

    private Semaphore s1 = new Semaphore(0);
    private Semaphore s2 = new Semaphore(0);
    public Foo2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s1.acquire();
        printSecond.run();
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        s2.acquire();
        printThird.run();
    }
}
