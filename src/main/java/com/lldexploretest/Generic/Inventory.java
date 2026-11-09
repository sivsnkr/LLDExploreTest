package com.lldexploretest.Generic;

import java.util.Collection;
import java.util.HashMap;

public class Inventory<T extends Item> {
    private final HashMap<String, T> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(T item) {
        items.put(item.getId(), item);
    }

    public void removeItem(String id) {
        items.remove(id);
    }

    public T getItem(String id) {
        return items.get(id);
    }

    public Collection<T> getAllItems() {
        return items.values();
    }
}
