package com.lldDesignPractice.CoffeeVendingMachine;

import com.lldDesignPractice.CoffeeVendingMachine.Decorators.Coffee;

public class VendingMachine implements IVendingMachine {

    private IVendingMachine vendingMachineState;
    private Coffee currentCoffee;

    public VendingMachine() {
        this.vendingMachineState = new IdleVendingMachineState(this);
    }

    @Override
    public void select(CoffeeType coffeeType) {
        vendingMachineState.select(coffeeType);
    }

    @Override
    public void make() {
        vendingMachineState.make();
    }

    void setCurrentCoffee(Coffee coffee) {
        this.currentCoffee = coffee;
    }

    void buildCoffeeConcrete() {
        System.out.println("Started making coffee");
        currentCoffee.makeCoffee();
    }

    void dispenseCoffeeConcrete() {
        System.out.println("Dispensing coffee");
    }

    void setVendingMachineState(IVendingMachine vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }
}
