package com.gyoge.itcsfundamentals;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private final ArrayList<Integer> grades;

    public Student() {
        grades = new ArrayList<>();
    }

    public void displayGrades() {
        System.out.println(grades);
    }

    public void addGrades() {
        Scanner scanner = new Scanner(System.in);
        int grade;

        System.out.println("Enter a grade:");
        while ((grade = scanner.nextInt()) != -1) {
            System.out.println("Enter a grade: (-1 to stop)");
            grades.add(grade);
        }
    }

    public double getAverageGrade() {
        final double[] sum = {0};
        grades.forEach(grade -> sum[0] += grade);
        return sum[0] / grades.size();
    }

    public void roundUpGrades() {
        for (int i = 0; i < grades.size(); i++) {
            grades.set(i, grades.get(i) % 10 == 9 ? grades.get(i) + 1 : grades.get(i));
        }
    }

    public void removeLowGrade() {
        int lowGrade = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) < lowGrade) {
                lowGrade = grades.get(i);
                index = i;
            }
        }
        grades.remove(index);
    }

    public static void main(String[] args) {
        Student jim = new Student();
        jim.addGrades();
        jim.roundUpGrades();
        jim.removeLowGrade();
        jim.displayGrades();
        System.out.println(jim.getAverageGrade());
    }

}
