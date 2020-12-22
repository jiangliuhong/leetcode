package com.jarome.leetcode.thread;

public class Foo {
    // 共享变量
    private volatile String state;

    public Foo() {
        this.state = "first";
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            while (!"first".equals(this.state)) {
                this.wait();
            }
            printFirst.run();
            this.state = "second";
            this.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (!"second".equals(this.state)) {
                this.wait();
            }
            printSecond.run();
            this.state = "third";
            this.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (!"third".equals(this.state)) {
                this.wait();
            }
            printThird.run();
            this.notifyAll();
        }
    }
}
