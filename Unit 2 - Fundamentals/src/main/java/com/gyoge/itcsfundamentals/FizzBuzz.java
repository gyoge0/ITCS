package com.gyoge.itcsfundamentals;

/** @author Yogesh Thambidurai */
public class FizzBuzz {

    public static void main(String[] args) {
        fizzbuzz(100);
    }

    /** Fizzbuzz 1 - n */
    public static void fizzbuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }

}
