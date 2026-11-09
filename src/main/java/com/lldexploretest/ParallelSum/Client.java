package com.lldexploretest.ParallelSum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) {
        int numCores = Runtime.getRuntime().availableProcessors();
        System.out.println("cores: " + numCores);

        long mx = 1_000_000_000_01L;
//        List<Integer> list = new ArrayList<>();
//
//        for(int i = 1; i <= mx; i++) list.add(i);
//        SumCalculator.list = list;

        long ch = mx / numCores;
        try(ExecutorService executorService = Executors.newFixedThreadPool(numCores)) {
            long l = 1;
            List<Future<Long>> parallelFut = new ArrayList<>();
            for(int i = 0; i < numCores && l < mx; i++) {
                Future<Long> th = executorService.submit(new SumCalculator(l, Math.min(l + ch - 1, mx - 1)));
                parallelFut.add(th);
                l += ch;
            }

            if(l < mx)
                parallelFut.add(executorService.submit(new SumCalculator(l, mx - 1)));

            Long result = 0L;

            for(Future<Long> fut : parallelFut) {
                result += fut.get();
            }

            System.out.println("result: " + result);
        }catch (Exception e) {
            e.printStackTrace();
        }



    }
}
