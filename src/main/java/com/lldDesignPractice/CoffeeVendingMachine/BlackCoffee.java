package com.lldDesignPractice.CoffeeVendingMachine;

import com.lldDesignPractice.CoffeeVendingMachine.Decorators.Coffee;

public class BlackCoffee extends Coffee {

    @Override
    protected void makeSpecificCoffeeType() {
        System.out.println("Adding water");
        System.out.println("Adding coffee");
    }
}
