package com.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Grade calculator app
 *
 */
public class App {
    public static void main(String[] args) {
        ArrayList<Integer> vec = new ArrayList<>();
        Calculator c = new Calculator(new Scanner(System.in));
        c.askGrades();
        System.out.println(c.calculateAverage());
        vec = c.getVec();
        for (int i : vec){
            System.out.println(i);
        }
    }
}
