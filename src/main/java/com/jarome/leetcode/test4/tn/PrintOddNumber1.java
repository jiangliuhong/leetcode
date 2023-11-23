package com.jarome.leetcode.test4.tn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddNumber1 {

    public static void main(String[] args) {
        // 创建Lock和两个Condition对象
        Lock lock = new ReentrantLock();
        Condition cond1 = lock.newCondition();
        Condition cond2 = lock.newCondition();

        // 创建两个线程，并传入对应的Condition对象
        Thread t1 = new Thread(new OddNumberPrinter(lock, cond1, cond2), "Thread 1");
        Thread t2 = new Thread(new OddNumberPrinter(lock, cond2, cond1), "Thread 2");

        // 启动两个线程
        t1.start();
        t2.start();
    }

    // 实现Runnable接口的内部类，用于打印奇数
    private static class OddNumberPrinter implements Runnable {


        private Lock lock;
        private Condition myCond;
        private Condition otherCond;
        private Integer number = 1;

        public OddNumberPrinter(Lock lock, Condition myCond, Condition otherCond) {
            this.lock = lock;
            this.myCond = myCond;
            this.otherCond = otherCond;
        }

        @Override
        public void run() {
            while (number < 100) {
                lock.lock();

                try {
                    // 判断当前数字是否为奇数
                    if (number % 2 == 1) {
                        // 打印当前数字，并将number加1
                        System.out.println(Thread.currentThread().getName() + ": " + number);
                        number++;
                        // 唤醒另一个线程
                        otherCond.signal();
                    } else {
                        // 如果当前数字为偶数，则等待另一个线程打印完奇数
                        number++;
                        myCond.await();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
