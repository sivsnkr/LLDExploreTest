package com.lldDesignPractice.inventoryManagementService;

public class Order {
    private final String orderId;
    private final boolean isExpress;

    public Order(String orderId, boolean isExpress) {
        this.orderId = orderId;
        this.isExpress = isExpress;
    }

    public boolean isExpress() {
        return isExpress;
    }

    public String getOrderId() {
        return orderId;
    }
}
