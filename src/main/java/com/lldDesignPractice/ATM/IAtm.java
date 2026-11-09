package com.lldDesignPractice.ATM;

public interface IAtm {
    void insertCard();
    void checkBalance();
    void withdrawCash(int amount);
    void ejectCard();
}
