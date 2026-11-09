package com.lldDesignPractice.ATM;

public class BankServer {
    void transact(Atm atm, int amount) {
        try {
            Thread.sleep(2000);
            System.out.println("Amount: " + amount + " withdrawn from atm number: " + atm.getAtmNumber());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw e;
        }
    }

    void checkBalance(Atm atmCard) {
        try {
            Thread.sleep(2000);
            System.out.println("Balance check for atm number: " + atmCard.getAtmNumber());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw e;
        }
    }
}
