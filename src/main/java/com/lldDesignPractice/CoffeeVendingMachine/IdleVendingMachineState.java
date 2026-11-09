package com.lldDesignPractice.CoffeeVendingMachine;

import com.lldDesignPractice.CoffeeVendingMachine.Decorators.Coffee;
import com.lldDesignPractice.CoffeeVendingMachine.Decorators.MilkDecorator;
import com.lldDesignPractice.CoffeeVendingMachine.Decorators.SugarDecorator;

public class IdleVendingMachineState implements IVendingMachine {
    private final VendingMachine vendingMachine;

    public IdleVendingMachineState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void select(CoffeeType coffeeType) {
        switch (coffeeType) {
            case LATTE:
                Coffee coffee = new Latte();
                coffee = new SugarDecorator(coffee);
                coffee = new MilkDecorator(coffee);
                vendingMachine.setCurrentCoffee(coffee);
                break;
            case BLACK_COFFEE:
                vendingMachine.setCurrentCoffee(new BlackCoffee());
                break;
            default:
                throw new IllegalArgumentException("Coffee not supported");
        }
        vendingMachine.setVendingMachineState(new ProgressVendingMachineState(vendingMachine));
    }

    @Override
    public void make() {
        System.out.println("Please select the coffee first");
    }
}
