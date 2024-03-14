package com.example;

import java.util.ArrayList;

public class StudentRegister {
    private DatabaseStub db;

    public StudentRegister() {
        db = new DatabaseStub();
    }

    public double getAverageGrade(String id) {
        ArrayList<Integer> grades = db.getGrades(id);
        int sum = 0;
        for (int i : grades) {
            sum += i;
        }

        return (double) sum / (double) grades.size();
    }

    public String getCourseName(String id) {
        return db.getCourseName(id);
    }

}
