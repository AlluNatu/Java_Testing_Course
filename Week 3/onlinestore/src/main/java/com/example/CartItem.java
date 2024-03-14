package com.example;

// Cart items are items that are placed to users shopping cart. Contains reference to item and quantity.
public class CartItem {
    private Item item;
    private int quantity;

    // Constructor for CartItem that takes store Item and quantity as parameters. If
    // requested quantity is larger than current stock levels, exception is thrown.
    // In case negative quantity is provided, the quantity is set to 1.
    public CartItem(Item item, int quantity) {
        // check if enough items in stock
        if (item.getStock() >= quantity) {
            if (quantity <= 0) {
                this.quantity = 1;
            } else {
                this.quantity = quantity;
            }
            this.item = item;
        } else {
            throw new IllegalArgumentException("Not enough stock to add to cart.");
        }
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
