package com.lldexploretest.WebScrapper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        System.out.println("Web Scrapper Client Initialized");

        ExecutorService executorService0 = Executors.newFixedThreadPool(10);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        testExecutorService(executorService0);
        testExecutorService(executorService1);
    }

    private static void testExecutorService(ExecutorService executorService) {
        int numUrls = 100;


        long startTime = System.currentTimeMillis();

        for(int i = 0; i < numUrls; i++) {
            executorService.submit(new Scrapper());
        }

        // Initiate shutdown so no new tasks can be submitted
        executorService.shutdown();

        try {
            // Block until all tasks have completed, or the timeout occurs
            if (executorService.awaitTermination(1, TimeUnit.HOURS)) {
                long endTime = System.currentTimeMillis();
                System.out.println("All scraping tasks finished in " + (endTime - startTime) + " ms");
            } else {
                System.err.println("Scraping tasks did not finish within the timeout");
            }
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted while waiting for tasks to finish.");
            Thread.currentThread().interrupt();
        }
    }
}
