package com.lldDesignPractice.inventoryManagementService;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MainClass {
    public static void main(String[] args) {

        Book book = new Book("1", "Book", 10, 1, "author");
        Clothing clothing = new Clothing("2", "Clothing", 20, 2, "size");
        Electronics electronic = new Electronics("3", "Electronic", 30, 3, 1);

        Inventory<Item> inventory = new Inventory<>();
        inventory.addItem(electronic);
        inventory.addItem(book);
        inventory.addItem(clothing);

        List<Item> sortedItems = inventory.getAllItems().stream().sorted((item1, item2) -> (int) (item2.getPrice() - item1.getPrice())).toList();

        for(int i = 0; i < 10; i++) {
            inventory.addToRecentlyViewed(book);
        }

        for(int i = 0; i < 5; i++) {
            inventory.addToRecentlyViewed(clothing);
        }

        List<Item> items = inventory.getAllItems().stream().sorted().toList();

//        for (Item item : inventory.getRecentlyViewedItems()) {
//            System.out.println(item.getName());
//        }

        for (Item item : sortedItems) {
            System.out.println(item.getName());
        }

        Queue<Order> orders = new PriorityQueue<>((Order o1, Order o2) -> {
            if (o1.isExpress()) return -1;
            else if(o2.isExpress()) return 1;
            return 0;
        });

        for(int i = 0; i < 10; i++) {
            orders.add(new Order("order" + i, false));
        }

        for(int i = 0; i < 10; i++) {
            orders.add(new Order("order" + i + 10, true));
        }

        for(int i = 0; i < 20 && !orders.isEmpty(); i++) {
            System.out.println(orders.poll().getOrderId());
        }
    }
}
