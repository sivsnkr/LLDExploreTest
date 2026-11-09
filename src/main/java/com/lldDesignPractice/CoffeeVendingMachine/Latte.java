package com.lldDesignPractice.CoffeeVendingMachine;

import com.lldDesignPractice.CoffeeVendingMachine.Decorators.Coffee;

public class Latte extends Coffee {
    @Override
    protected void makeSpecificCoffeeType() {
        System.out.println("Adding latte ingredients");
    }
}
