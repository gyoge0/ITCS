package com.gyoge.itcsfundamentals;

import java.util.HashSet;
import java.util.Random;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class BingoCard {

    String[][] card = new String[6][5];

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            BingoCard b = new BingoCard();
            b.generateBingoCard();
            b.displayCard();
            System.out.println();
        }
    }

    public String[][] getCard() {
        return card;
    }

    public void setCard(String[][] card) {
        this.card = card;
    }

    @SuppressWarnings("CommentedOutCode")
    public String[][] generateBingoCard() {
        Rando r = new Rando();
        int[][] bounds = {
            {1, 15}, {16, 30}, {31, 45}, {46, 60}, {61, 75}
        };
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                card[i] = new String[]{"B", "I", "N", "G", "O"};
                continue;
            }
            for (int j = 0; j < 5; j++) {
                if (j == 2 && i == 3) {
                    card[i][j] = "F";
                    continue;
                }
                card[i][j] = r.m(bounds[j][0], bounds[j][1]);
            }
        }

//                why not?
//                card = new String[][]{
//                    {"B", "I", "N", "G", "O"},
//                    {r.m(1, 15), r.m(16, 30), r.m(31, 45), r.m(46, 60), r.m(61, 75)},
//                    {r.m(1, 15), r.m(16, 30), r.m(31, 45), r.m(46, 60), r.m(61, 75)},
//                    {r.m(1, 15), r.m(16, 30), "F", r.m(46, 60), r.m(61, 75)},
//                    {r.m(1, 15), r.m(16, 30), r.m(31, 45), r.m(46, 60), r.m(61, 75)},
//                    {r.m(1, 15), r.m(16, 30), r.m(31, 45), r.m(46, 60), r.m(61, 75)}
//                };

        return card;
    }

    public void displayCard() {
        for (String[] i : card) {
            for (String j : i) {
                System.out.print(j + "\t");
            }
            System.out.print("\n");
        }
    }

    private static class Rando {

        HashSet<Integer> used = new HashSet<>();
        Random r = new Random();

        String m(int min, int max) {
            while (true) {
                int z = r.nextInt(max - min) + min;
                if (!used.contains(z)) {
                    used.add(z);
                    return String.valueOf(z);
                }
            }
        }

    }


}
