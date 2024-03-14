package com.example;

// Represents item that is available for sale in the store.
public class Item {
    private String name;
    private double price;
    private int stock;

    public Item() {
        this.name = "Undefined";
        this.price = 0;
        this.stock = 0;
    }

    public Item(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // reduce stock levels of item when adding item to cart.
    public void reduceStock(int amount) {
        stock -= amount;
    }

    // increase stock levels of item when removing item from cart.
    public void increaseStock(int amount) {
        stock += amount;
    }

    // returns string representation of the object.
    @Override
    public String toString() {
        return "name: " + name + ", price: " + price + ", stock: " + stock;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
