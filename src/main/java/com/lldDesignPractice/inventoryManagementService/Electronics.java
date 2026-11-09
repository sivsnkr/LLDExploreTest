package com.lldDesignPractice.inventoryManagementService;

public class Electronics extends Item {
    private final int warranty;
    public Electronics(String id, String name, double price, int quantity, int warranty) {
        super(id, name, price, quantity);
        this.warranty = warranty;
    }
}
