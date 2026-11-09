package com.lldexploretest.multithreading;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class Adder implements Runnable {

    private final IntObj val;

    public Adder(IntObj val) {
        this.val = val;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10000; i++) {
            val.add();
        }
    }
}
