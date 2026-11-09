package com.lldDesignPractice.CoffeeVendingMachine;

public class ProgressVendingMachineState implements IVendingMachine {
    private final VendingMachine vendingMachine;

    public ProgressVendingMachineState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void select(CoffeeType coffeeType) {
        System.out.println("Coffee is already selected");
    }

    @Override
    public void make() {
        vendingMachine.buildCoffeeConcrete();
        vendingMachine.dispenseCoffeeConcrete();
        vendingMachine.setVendingMachineState(new IdleVendingMachineState(vendingMachine));
    }
}
