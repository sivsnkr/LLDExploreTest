package com.lldexploretest.multithreading;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Runnable {

    public static List<Integer> list;
    private final int left;
    private final int right;

    public MergeSort(int left, int right) {
        this.left = left;
        this.right = right;
    }

    private static void merge(int l, int r, int mid) {
        int i = l, j = mid + 1;
        List<Integer> temp = new ArrayList<>();

        while(i <= mid && j <= r) {
            if(list.get(i) < list.get(j)) {
                temp.add(list.get(i));
                i++;
            }else {
                temp.add(list.get(j));
                j++;
            }
        }

        while(i <= mid) {
            temp.add(list.get(i));
            i++;
        }

        while(j <= r) {
            temp.add(list.get(j));
            j++;
        }

        for(int k = l; k <= r; k++) {
            list.set(k, temp.get(k - l));
        }
    }
    private static void sort(int l, int r) throws InterruptedException {

        if(l >= r) return;

        int mid = (l + r) / 2;


        MergeSort leftSort = new MergeSort(l, mid);
        MergeSort rightSort = new MergeSort(mid + 1, r);

        Thread leftSortThread = new Thread(leftSort);
        Thread rightSortThread = new Thread(rightSort);

        leftSortThread.start();
        rightSortThread.start();

        leftSortThread.join();
        rightSortThread.join();

        merge(l, r, mid);
    }

    @Override
    public void run() {
        try {
            sort(left, right);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

