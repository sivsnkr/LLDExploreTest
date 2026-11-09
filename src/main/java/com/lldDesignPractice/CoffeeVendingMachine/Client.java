package com.lldDesignPractice.CoffeeVendingMachine;

import com.lldDesignPractice.CoffeeVendingMachine.Decorators.Coffee;

public class Client {
    public static void main(String[] args) {
        CoffeeType latte = CoffeeType.LATTE;
        CoffeeType black = CoffeeType.BLACK_COFFEE;

        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.select(latte);
        vendingMachine.select(latte);
        vendingMachine.make();

        vendingMachine.select(black);
        vendingMachine.make();
        vendingMachine.make();
    }
}
