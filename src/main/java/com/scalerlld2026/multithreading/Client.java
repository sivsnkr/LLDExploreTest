package com.scalerlld2026.multithreading;

import com.lldexploretest.multithreading.Node;
import com.lldexploretest.multithreading.TreeSizeCalculator;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
            Future<Integer> resultFuture = executorService.submit(() -> {
                return 10;
            });

            System.out.println("Int result: " + resultFuture.get());
    }
}
