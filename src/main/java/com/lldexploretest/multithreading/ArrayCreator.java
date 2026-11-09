package com.lldexploretest.multithreading;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<ArrayList<Integer>> {
    private final int n;

    public ArrayCreator(int n) {
        this.n = n;
    }

    @Override
    public ArrayList<Integer> call() {
        ArrayList<Integer> lis = new ArrayList<>();
        for(int i = 1; i <= n; i++) lis.add(i);
        return lis;
    }
}