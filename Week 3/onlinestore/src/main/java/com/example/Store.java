package com.example;

import java.util.ArrayList;

public class Store {
    private ArrayList<Item> items = new ArrayList<>();

    // adds an item to store and prints the item name. If the item is
    // not defined, catches nullpointer exception and informs user that item does
    // not exist.
    public void addItem(Item item) {
        try {
            items.add(item);
            // causes nullpointer exception if item is null
            System.out.println("Added item: " + item.getName());

        } catch (NullPointerException e) {
            System.out.println("Item does not exist or no name has been set");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // returns item corresponding the index. If index is invalid should inform the
    // user and returns null.
    public Item getItemByIndex(int idx) {
        try {
            return items.get(idx);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds.");
            return null;
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

}
