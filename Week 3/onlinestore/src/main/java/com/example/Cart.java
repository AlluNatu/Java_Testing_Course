package com.example;

import java.util.ArrayList;

public class Cart {
    // arraylist containing all cart items.
    private ArrayList<CartItem> contents;

    public Cart() {
        this.contents = new ArrayList<>();
    }

    public ArrayList<CartItem> getContents() {
        return contents;
    }

    // adds an item to cart. If same item is already in cart, increments the already
    // existing cartItem instead of adding another copy of same item. Reduce stock
    // levels accordingly.
    public void addItemToCart(CartItem item) {
        boolean found = false;
        // reduce stock levels when item is added to cart.
        item.getItem().reduceStock(item.getQuantity());
        // increment existing item if item exists in cart
        for (CartItem cartItem : contents) {
            if (cartItem.getItem().equals(item.getItem())) {
                cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
                found = true;
            }
        }
        if (!found) {
            contents.add(item);
        }
    }

    // reduces a certain cart item by number indicated by "amount". If the updated
    // amount is negative, remove item from cart. Increase stock levels
    // accordingly.
    public void reduceItemByAmount(CartItem item, int amount) {
        int total = item.getQuantity() - amount;
        if (item.getQuantity() >= amount) {
            // update quantity
            item.setQuantity(total);
            // update stock levels
            item.getItem().increaseStock(amount);
        } else {
            // remove item from cart
            int removed = item.getQuantity();
            contents.remove(item);
            item.getItem().increaseStock(removed);
        }
    }

    // string representation of the cart contents
    @Override
    public String toString() {
        String contentString = "";

        for (CartItem cartItem : contents) {
            contentString += cartItem.getItem().getName() + ", In cart: " + cartItem.getQuantity() + "\n";
        }
        return contentString;
    }

}
