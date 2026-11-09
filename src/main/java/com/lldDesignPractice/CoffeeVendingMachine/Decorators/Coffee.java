package com.lldDesignPractice.CoffeeVendingMachine.Decorators;

public abstract class Coffee {
    protected abstract void makeSpecificCoffeeType();

    public final void makeCoffee() {
        grindCoffee();
        makeSpecificCoffeeType();
        mix();
    }

    private void grindCoffee() {
        System.out.println("Grinding coffee");
    }

    private void mix() {
        System.out.println("Mixing the coffee");
    }
}
