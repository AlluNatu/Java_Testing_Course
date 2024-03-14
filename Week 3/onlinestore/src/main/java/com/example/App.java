package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Store store = new Store();
        CartItem cartItem;
        store.addItem(new Item("test item 1", 9.99, 10));
        store.addItem(new Item("test item 2", 10.99, 52));
        store.addItem(new Item("test item 3", 102.99, 0));

        User user = new User("Kalle", "jokukatuvaan 10");
        Cart cart = user.getCart();

        boolean running = true;
        while (running) {

            // print store items
            System.out.println("-------------------------");
            System.out.println("Available items");

            ArrayList<Item> items = store.getItems();
            for (Item item : items) {
                System.out.println(item.toString());
            }

            // print options
            System.out.println("1) Add item to cart, 2) Remove item from cart, 3) Print cart contents, 0) Stop");

            if (sc.hasNext()) {
                int i = 0;
                String input = sc.nextLine();
                i = Integer.parseInt(input);

                switch (i) {
                    case 1: {
                        System.out.println("Which item do you want to add? (index)");
                        int idx = Integer.parseInt(sc.nextLine());
                        System.out.println("How many items do you want to add?");
                        int amount = Integer.parseInt(sc.nextLine());

                        try {
                            // create cart item
                            Item item = items.get(idx);
                            cartItem = new CartItem(item, amount);
                            cart.addItemToCart(cartItem);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        break;
                    }
                    case 2: {
                        // print cart
                        System.out.println("Current cart contents:");
                        System.out.println(cart.toString());

                        System.out.println("Which item do you want to remove? (index)");
                        int idx = Integer.parseInt(sc.nextLine());
                        System.out.println("How many do you want remove?");
                        int amount = Integer.parseInt(sc.nextLine());

                        // get right cart item and reduce its amount in cart.
                        cartItem = cart.getContents().get(idx);
                        cart.reduceItemByAmount(cartItem, amount);
                        break;
                    }
                    case 3: {
                        System.out.println(cart.toString());
                        break;
                    }
                    case 0: {
                        running = false;
                        sc.close();
                        break;
                    }
                }
            }

        }

    }
}
