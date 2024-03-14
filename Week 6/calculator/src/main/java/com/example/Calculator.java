package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private Scanner scanner;
    private ArrayList<Integer> vec;

    public Calculator(Scanner scanner) {
        this.scanner = scanner;
    }

    public void askGrades() {
        vec = new ArrayList<>();
        int i = 1;
        String s = "";

        System.out.println(
                "***\nThis program calculates average of school grades (4-10). Input number, press enter. Zero (0) ends the input.");

        while (s != "0") {
            System.out.println(i + ": ");
            if (scanner.hasNext()) {
                try {
                    s = scanner.nextLine();
                    if (Integer.parseInt(s) == 0){
                        break;
                    }
                    else if (Integer.parseInt(s) < 4){
                        System.out.println("Not good.");
                    }
                    else if(Integer.parseInt(s) > 10){
                        System.out.println("Not good.");
                    }
                    else
                    {
                        vec.add(Integer.parseInt(s));
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
                i++;
            }
        }

    }

    public float calculateAverage() {
        return divider(sum(vec), vec.size());

    }

    public float divider(int x, int y) {
        //System.out.println(x + " " + y);
        if(y!=0){
            return(float) x / (float) y;
        }
        else{
            return 0;
        }
    }

    public int sum(ArrayList<Integer> vec) {
        int s = 0;

        for (int i : vec) {
            s += i;
        }

        return s;
    }

    public ArrayList<Integer> getVec() {
        return vec;
    }

}
