// This file contains reference code for your tests. Do not modify.
package com.example;
public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        if (age < 0) {
            this.age = 0;
        } else {
            this.age = age;
        }
        if (name == null || name.length() == 0) {
            this.name = "Undefined";
        } else {
            this.name = name;
        }
    }

    public String shout() {
        return "<default shout>";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
