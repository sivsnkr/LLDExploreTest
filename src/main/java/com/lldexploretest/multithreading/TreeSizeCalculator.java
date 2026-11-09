package com.lldexploretest.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class TreeSizeCalculator implements Callable<Integer> {
    private final Node root;
    private final ExecutorService executorService;

    public TreeSizeCalculator(Node root, ExecutorService executorService) {
        this.root = root;
        this.executorService = executorService;
    }


    @Override
    public Integer call() throws Exception {
        if (root == null) {
            return 0;
        }

        TreeSizeCalculator leftSizeCal = new TreeSizeCalculator(root.left, executorService);
        TreeSizeCalculator rightSizeCal = new TreeSizeCalculator(root.right, executorService);

        int leftSize = executorService.submit(leftSizeCal).get();
        int rightSize = executorService.submit(rightSizeCal).get();

        return leftSize + rightSize + 1;
    }
}
