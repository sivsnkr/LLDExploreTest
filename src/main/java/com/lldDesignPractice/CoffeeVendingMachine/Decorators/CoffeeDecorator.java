package com.lldDesignPractice.CoffeeVendingMachine.Decorators;

public abstract class CoffeeDecorator extends Coffee {
    private final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    protected void makeSpecificCoffeeType() {
        System.out.println("Calling the next decorator");
        decoratedCoffee.makeSpecificCoffeeType();
    }
}
