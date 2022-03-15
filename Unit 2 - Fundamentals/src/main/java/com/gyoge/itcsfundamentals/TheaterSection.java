package com.gyoge.itcsfundamentals;

import java.util.ArrayList;
import java.util.Random;

public class TheaterSection {

    private final boolean[][] section;

    public TheaterSection() {
        section = new boolean[5][20];
        int num;
        for (int r = 0; r < section.length; r++) {
            for (int c = 0; c < section[0].length; c++) {
                Random random = new Random();
                num = random.nextInt(4);
                section[r][c] = num == 0;
            }
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    public TheaterSection(boolean[][] premadeSection) {
        this.section = premadeSection.clone();
    }

    public void printSection() {
        System.out.print(" \t");
        for (int i = 0; i < section[0].length; i++) {
            System.out.print((i + 1) + "\t");
        }
        System.out.print("\n");

        for (int i = 0; i < section.length; i++) {
            System.out.print((char) (i + 65) + "\t");
            for (boolean e : section[i]) {
                System.out.print(e ? "*\t" : "X\t");
            }
            System.out.print("\n");
        }
    }

    public void printAvailable() {
        System.out.println("Row\t\tAvailable Seats");
        int total = 0;

        for (int i = 0; i < section.length; i++) {
            System.out.print((char) (i + 65) + "\t\t");

            ArrayList<Integer> available = new ArrayList<>();
            for (int j = 0; j < section[i].length; j++) {
                if (section[i][j]) {
                    available.add(j + 1);
                    total++;
                }
            }
            // noinspection SpellCheckingInspection
            String idxs = available.toString();
            System.out.println(
                available.isEmpty()
                    ? "None available"
                    : idxs.substring(1, idxs.length() - 1)
            );
        }
        System.out.printf("The total number of seats available is %d.\n", total);
    }


    public static void main(String[] args) {
        boolean[][] example = {{true, true, false}, {false, false, false}};
        TheaterSection test1 = new TheaterSection(example);
        test1.printSection();
        System.out.println();
        test1.printAvailable();

        System.out.println();

        TheaterSection test2 = new TheaterSection();
        test2.printSection();
        System.out.println();
        test2.printAvailable();

    }

}
