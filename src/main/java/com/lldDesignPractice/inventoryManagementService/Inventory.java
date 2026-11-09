package com.lldDesignPractice.inventoryManagementService;

import java.util.*;

public class Inventory <T extends Item> {
    private final Map<String, T> itemsMap;
    private final List<T> recentlyViewedItems;

    public Inventory() {
        this.itemsMap = new HashMap<>();
        this.recentlyViewedItems = new LinkedList<>();
    }

    public void addItem(T item) {
        itemsMap.put(item.getId(), item);
    }

    public void removeItem(String itemId) {
        itemsMap.remove(itemId);
    }

    public T getItem(String itemId) {
        return itemsMap.get(itemId);
    }

    public List<T> getAllItems() {
        return itemsMap.values().stream().toList();
    }

    public void addToRecentlyViewed(T item) {
        recentlyViewedItems.add(item);
        if (recentlyViewedItems.size() > 10) {
            recentlyViewedItems.removeFirst();
        }
    }

    public List<T> getRecentlyViewedItems() {
        return recentlyViewedItems.stream().toList();
    }
}
