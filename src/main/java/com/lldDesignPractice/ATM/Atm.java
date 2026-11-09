package com.lldDesignPractice.ATM;

public class Atm {
    private final String atmNumber;
    private final Banks bank;

    public Atm(String atmNumber, Banks bank) {
        this.atmNumber = atmNumber;
        this.bank = bank;
    }

    public String getAtmNumber() {
        return atmNumber;
    }

    public Banks getBank() {
        return this.bank;
    }
}
