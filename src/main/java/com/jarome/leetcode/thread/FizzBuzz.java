package com.jarome.leetcode.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    private int stat = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                lock.lock();
                while (stat != i) {
                    condition.await();
                }
                printFizz.run();
                this.stat = this.stat + 1;
                condition.signalAll();
                lock.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                lock.lock();
                while (stat != i) {
                    condition.await();
                }
                printBuzz.run();
                this.stat = this.stat + 1;
                condition.signalAll();
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                lock.lock();
                while (stat != i) {
                    condition.await();
                }
                printFizzBuzz.run();
                this.stat = this.stat + 1;
                condition.signalAll();
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                lock.lock();
                while (stat != i) {
                    condition.await();
                }
                printNumber.accept(i);
                this.stat = this.stat + 1;
                condition.signalAll();
                lock.unlock();
            }
        }
    }

}
