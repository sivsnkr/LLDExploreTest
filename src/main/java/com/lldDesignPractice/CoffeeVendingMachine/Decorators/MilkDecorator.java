package com.lldDesignPractice.CoffeeVendingMachine.Decorators;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    protected void makeSpecificCoffeeType() {
        System.out.printf("Adding milk");
        super.makeSpecificCoffeeType();
    }
}
