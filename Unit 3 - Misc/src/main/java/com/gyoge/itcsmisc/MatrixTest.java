package com.gyoge.itcsmisc;

import java.util.Random;

public class MatrixTest {

    public static void main(String[] args) {
        Random random = new Random();
        int[][] arr = new int[5][8];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(20) + 1;
            }
        }

        System.out.println("Original:");
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.print("\n");
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] *= arr[i][j] % 2 == 0 ? 2 : 1;
            }
        }

        System.out.println("New:");
        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.print("\n");
        }

    }
}
