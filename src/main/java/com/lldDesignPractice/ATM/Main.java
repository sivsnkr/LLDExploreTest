package com.lldDesignPractice.ATM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        IAtm atmService = new AtmService();

        atmService.insertCard();
        Thread transactionThread = new Thread(() -> atmService.withdrawCash(100));
        transactionThread.start();
        Thread.sleep(5);
        atmService.checkBalance();
        atmService.withdrawCash(100);
        atmService.ejectCard();
        transactionThread.join();
        atmService.ejectCard();
        atmService.withdrawCash(100);
    }
}
