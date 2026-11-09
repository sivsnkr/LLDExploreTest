package com.lldDesignPractice.inventoryManagementService;

public class Clothing extends Item {
    private final String size;
    public Clothing(String id, String name, double price, int quantity, String size) {
        super(id, name, price, quantity);
        this.size = size;
    }
}
