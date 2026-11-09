package com.lldDesignPractice.ATM;

public class Dispenser {
    void dispenseMoney(int amount) {
        try {
            Thread.sleep(3000);
            System.out.println("Cash dispensed for amount: " + amount);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
