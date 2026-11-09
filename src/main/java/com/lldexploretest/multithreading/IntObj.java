package com.lldexploretest.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class IntObj {
    private int val;
    private final Lock lock = new java.util.concurrent.locks.ReentrantLock();
    private final Object vlock = new Object();

    public IntObj(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public synchronized void add() {
//        this.val.incrementAndGet();
//        lock.lock();
//        val += 1;
//        lock.unlock();

        val += 1;

//        synchronized (vlock) {
//        }
    }

    public synchronized void sub() {
//        this.val.decrementAndGet();
//        lock.lock();
//        val -= 1;
//        lock.unlock();

//        synchronized (vlock) {
//        }


        val -= 1;
    }
}
