package com.lldDesignPractice.ATM;

public class ProcessingAtmState extends AtmStateBase {

    public ProcessingAtmState(AtmService atmService) {
        super(atmService);
    }

    void showError() {
        System.out.println("Another transaction is already in progress");
    }

    @Override
    public void insertCard() {
        showError();
    }

    @Override
    public void checkBalance() {
        showError();
    }

    @Override
    public void withdrawCash(int amount) {
        showError();
    }

    @Override
    public void ejectCard() {
        showError();
    }
}
