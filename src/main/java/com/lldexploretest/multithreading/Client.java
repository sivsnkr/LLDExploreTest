package com.lldexploretest.multithreading;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {

        class ResourcePool {
            private final Deque<Integer> poolStack = new ArrayDeque<>();
            private final List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());

            ResourcePool(int size) {
                for(int i = 0; i < size; i++) {
                    poolStack.push(i);
                }
            }

            synchronized Integer acquire(long timeout, TimeUnit unit) throws InterruptedException {
                long deadline = System.currentTimeMillis() + unit.toMillis(timeout);
                while(poolStack.isEmpty()) {
                    long remaining = deadline - System.currentTimeMillis();
                    if(remaining <= 0) return null;
                    wait(remaining);
                }

                Integer resource = poolStack.peek();
                poolStack.pop();

                return resource;

            }
            // Blocks up to `timeout` waiting for a resource to become available.
            // Returns a resource if one becomes available in time, otherwise returns null.

            synchronized void release(Integer resource) {
                poolStack.push(resource);
                notifyAll();
            }
            // Returns a resource back to the pool, making it available for others.
        }

        ResourcePool pool = new ResourcePool(10);

        for(int i = 0; i < 50; i++) {
            Thread worker = new Thread(() -> {
                try {
                    Integer resource = pool.acquire(10, TimeUnit.MILLISECONDS);
                    if(resource == null) {
                        System.out.println("Failed to acquire resource");
                        return;
                    }
                    try {
                        Thread.sleep(5);
                        // do something with the pool
                    } finally {
                        pool.release(resource);
                    }
                }catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            });

            worker.start();
        }

        System.out.println("Stopper");

//        ExecutorService executor = Executors.newFixedThreadPool(2);
//
//        for (int i = 0; i < 5; i++) {
//            final int input = i;
//            executor.execute(() -> {
//                try {
//                    System.out.println("Task " + input + " started");
//                    Thread.sleep(1000);
//                    System.out.println("Task" + input + " completed");
//                }catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            });
//        }
//
//        executor.shutdown();












//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        ArrayCreator ac = new ArrayCreator(n);
//
//        try(ExecutorService ec = Executors.newCachedThreadPool()) {
//            Future<ArrayList<Integer>> fa = ec.submit(ac);
//            ArrayList<Integer> lis = fa.get();
//            System.out.println(lis);
//        }

//        testRace();


//        Runnable r = () -> {
//            throw new RuntimeException("Hello from a runnable");
//        };
//        Callable<Void> r1 = () -> {
//            System.out.println("Hello from a callable");
//            return null;
//        };

//        ExecutorService executor = Executors.newFixedThreadPool(1);
//        Future<?> f1 = executor.submit(() -> {
//            System.out.println("Hello from t1");
//            while(!Thread.currentThread().isInterrupted()) {
//             }
//            System.out.println("Hello from t1 after interrupt");
//        });
//
//        Future<?> f2 = executor.submit(() -> {
//            System.out.println("Hello from t2");
//            return 1;
//        });
//
//        Thread.sleep(1000);
//
//
//        var cf2 = f2.cancel(true);

//        var cf1 = f1.cancel(true);

//        var rf1 = f2.get();

//        Thread t = new Thread(r);
//        Future<?> res = executor.submit(r);

//        t.start();

//        var result = res.get();

//        executor.shutdown();

//        System.out.println(result);
    }

    private static void testRace() throws InterruptedException {
        IntObj val = new IntObj(0);

        Adder adder = new Adder(val);
        Subtractor subtractor = new Subtractor(val);

        ScalerThread adderThread = new ScalerThread(adder);
        ScalerThread subtractorThread = new ScalerThread(subtractor);

        adderThread.start();
        subtractorThread.start();

        adderThread.join();
        subtractorThread.join();

        System.out.println(val.getVal());
    }

    private static void testMerge() throws InterruptedException {
        // Test Case 1: Random unsorted
        testMergeSort(new ArrayList<>(Arrays.asList(7, 3, 2, 9, 1, 4, 8, 6)), "Random unsorted");

        // Test Case 2: Already sorted
        testMergeSort(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), "Already sorted");

        // Test Case 3: Reverse sorted
        testMergeSort(new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1)), "Reverse sorted");

        // Test Case 4: Duplicates
        testMergeSort(new ArrayList<>(Arrays.asList(3, 1, 2, 3, 1)), "Duplicates");

        // Test Case 5: Single element
        testMergeSort(new ArrayList<>(List.of(1)), "Single element");

        // Test Case 6: Empty list
        testMergeSort(new ArrayList<>(), "Empty list");
    }

    private static void testMergeSort(List<Integer> input, String testName) throws InterruptedException {
        System.out.println("--- " + testName + " ---");
        System.out.println("Original: " + input);

        if (input.isEmpty()) {
            System.out.println("Sorted:   " + input);
            System.out.println();
            return;
        }

        MergeSort.list = input;
        MergeSort mergeSort = new MergeSort(0, input.size() - 1);
        Thread mergeSortThread = new Thread(mergeSort);

        mergeSortThread.start();
        mergeSortThread.join();

        System.out.println("Sorted:   " + MergeSort.list);
        System.out.println();
    }
}
