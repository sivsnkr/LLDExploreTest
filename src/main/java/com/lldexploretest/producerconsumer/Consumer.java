package com.lldexploretest.producerconsumer;

public class Consumer implements Runnable {


    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
