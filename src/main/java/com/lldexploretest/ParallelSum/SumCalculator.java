package com.lldexploretest.ParallelSum;

import java.util.List;
import java.util.concurrent.Callable;

public class SumCalculator implements Callable<Long> {
//    public static List<Integer> list;
    private final long l;
    private final long r;

    public SumCalculator(long l, long r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public Long call() throws Exception {
        long sum =0;

        for(long i = l; i <= r; i++) {
            sum = sum + i;
        }

        return sum;
    }
}
