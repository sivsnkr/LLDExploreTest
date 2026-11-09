package com.lldDesignPractice.inventoryManagementService;

public abstract class Item implements Comparable<Item> {
    private final String id;
    private final String name;
    private final double price;
    private final int quantity;

    public Item(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public int compareTo(Item other) {
        return this.name.compareTo(other.name);
    }
}
