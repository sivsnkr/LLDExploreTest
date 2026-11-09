package com.lldexploretest.Generic;

public class Order implements Comparable<Order> {
    private final int orderId;
    private final boolean isExpress;

    public Order(int orderId, boolean isExpress) {
        this.orderId = orderId;
        this.isExpress = isExpress;
    }

    public int getOrderId() {
        return orderId;
    }

    public boolean isExpress() {
        return isExpress;
    }

    @Override
    public int compareTo(Order o) {
        if(this.isExpress && !o.isExpress) return -1;
        if(!this.isExpress && o.isExpress) return 1;
        return Integer.compare(this.orderId, o.orderId);
    }
}
