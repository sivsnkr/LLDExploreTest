package com.lldDesignPractice.CoffeeVendingMachine.Decorators;

public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    protected void makeSpecificCoffeeType() {
        System.out.println("Adding sugar");
        super.makeSpecificCoffeeType();
    }
}
