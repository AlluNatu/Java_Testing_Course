package com.example;

import java.util.ArrayList;

public class DatabaseStub {
    private String courseName;
    private ArrayList<Integer> grades = new ArrayList<>();

    public String getCourseName(String id) {
        if (id == "CT60A4160"){
            courseName = "Ohjelmistotestauksen periaatteet";
        }
        else if (id == "CT60N00B"){
            courseName = "Help 4 newbies";
        }
        else if (id.length() > 15){
            courseName = "Invalid id";
        }
        else if (id == null){
            throw new NullPointerException("MESSAGE");
        }
        else{
            courseName = "Not Found";
        }
        return courseName;
    }

    public ArrayList<Integer> getGrades(String id) {

        if (id == "123"){
            grades.clear();
            grades.add(3);
            grades.add(4);
        }

        if (id == "666"){
            grades.clear();
            for (int i =0 ; i < 9; i++){
                grades.add(2);
            }
            grades.add(3);
        }

        if (id.length() < 1){
            grades.add(0);
        }
        return grades;
    }

}
