package com.example;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String address;
    private Cart cart;

    // every user should have a name, address and a unique identifier
    public User(String name, String address) {
        this.name = name;
        this.address = address;

        generateId();
        this.cart = new Cart();
    }

    private void generateId() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

}
