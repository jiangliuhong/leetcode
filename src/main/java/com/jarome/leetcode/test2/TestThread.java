package com.jarome.leetcode.test2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock(true);
        for (int i = 0; i < 50; i++) {
            final int f = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        lock.lock();
                        //Thread.sleep(100);
                        System.out.println(f);
                    }catch (Exception e){
                    }finally {
                        lock.unlock();
                    }

                }
            }).start();
        }
    }
}
