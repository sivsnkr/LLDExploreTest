package com.lldexploretest.Generic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        GenericPair<String, Integer> pair = new GenericPair<>("shiv", 28);

        LinkedList<Item> itemLinkedList = new LinkedList<>();
        itemLinkedList.contains(new Clothing("1", "T-Shirt", 19.99, 100, "M"));

        List<Item> items = new ArrayList<>();

        Clothing tshirt = new Clothing("1", "T-Shirt", 19.99, 100, "M");
        Clothing jeans = new Clothing("2", "Jeans", 49.99, 50, "32");
        items.add(tshirt);

        Electronics smartphone = new Electronics("2", "Smartphone", 499.99, 50, 24);

        items.add(smartphone);

//        for (Item item : items) {
//            System.out.println("ID: " + item.getId() + ", Name: " + item.getName() + ", Price: " + item.getPrice() + ", Quantity: " + item.getQuantity());
//        }
        Collections.sort(items);
//        for (Item item : items) {
//            System.out.println("ID: " + item.getId() + ", Name: " + item.getName() + ", Price: " + item.getPrice() + ", Quantity: " + item.getQuantity());
//        }

        Inventory<Clothing> clothingInventory = new Inventory<>();

        clothingInventory.addItem(tshirt);
        clothingInventory.addItem(tshirt);
        clothingInventory.addItem(jeans);
//
        Collection<Clothing> clothingItems = clothingInventory.getAllItems();
//        for (Clothing clothing : clothingItems) {
//            System.out.println("ID: " + clothing.getId() + ", Name: " + clothing.getName() + ", Price: " + clothing.getPrice() + ", Quantity: " + clothing.getQuantity() + ", Size: " + clothing.getSize());
//        }
//
//        clothingInventory.removeItem("1");
//        System.out.println("After removing item with ID 1:");
//        clothingItems = clothingInventory.getAllItems();
//        for (Clothing clothing : clothingItems) {
//            System.out.println("ID: " + clothing.getId() + ", Name: " + clothing.getName() + ", Price: " + clothing.getPrice() + ", Quantity: " + clothing.getQuantity() + ", Size: " + clothing.getSize());
//        }

        List<Integer> list = List.of(1, 2, 3, 4, 5);
        List<Integer> nl = list.stream().filter(it -> it % 2 == 0).map(it -> it * it).collect(Collectors.toList());
        System.out.println(nl);
//        Set<Integer> fil = list.stream().filter((a) -> a % 2 == 0).collect(Collectors.toSet());
//
        List<String> strs = List.of("apple", "banana", "avocado", "grape", "apricot");
        List<String> nstrs = strs.stream().filter(it -> it.substring(0, 1).equalsIgnoreCase("a")).map(String::toUpperCase).sorted().collect(Collectors.toList());
        List<Integer> nstrs1 = strs.stream().filter(it -> it.substring(0, 1).equalsIgnoreCase("a")).map(String::length).collect(Collectors.toList());
        System.out.println(nstrs);
        System.out.println(nstrs1);

        List<String> newStrs = List.of("some element", "yet another string", "yet long another string", "yet short another string");
        List<String> newStrs1 = newStrs.stream().flatMap(it -> Arrays.stream(it.split(" "))).distinct().sorted().collect(Collectors.toList());
        System.out.println(newStrs1);

//        String con = strs.stream().collect(Collectors.joining(", "));

        long cnt = strs.stream()
                .map(it -> it.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .count();

        try {
            print(cnt);
        }catch (Exception ex) {
            System.out.println("some kind of exception");
        }

//
//        System.out.println(con);
//
//        System.out.println(fil);

//        BinaryOperator<Integer> add = (x, y) -> x + y;
//        int val = add.apply(4, 5);
//        System.out.println(val);
        customsort(clothingItems.stream().toList());
    }

    public static <T extends Item> void customsort(List<T> list) {
        Collections.sort(list);
    }

    public static void print(Object obj) throws FileNotFoundException {
        File file = new File("somefile");
        Scanner sc = new Scanner(file);
    }
}
