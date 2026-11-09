package com.lldexploretest.multithreading;

import java.util.concurrent.Callable;

public class Subtractor implements Runnable {
    private final IntObj val;

    public Subtractor(IntObj val) {
        this.val = val;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10000; i++) {
            val.sub();
        }
    }
}
