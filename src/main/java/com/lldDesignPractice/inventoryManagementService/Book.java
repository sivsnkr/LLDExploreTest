package com.lldDesignPractice.inventoryManagementService;

public class Book extends Item {
    private final String author;
    public Book(String id, String name, double price, int quantity, String author) {
        super(id, name, price, quantity);
        this.author = author;
    }
}
