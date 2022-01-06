// Yogesh Thambidurai ITCS

package fundamentals;

import java.util.Random;

public class RandomNumbers {

    private RandomNumbers() {
        throw new IllegalStateException("Utility class");
    }


    private static final Random random = new Random();

    public static void main(String[] args) {
        diceGame();
        coinFlipper(10);
        coinGame();
    }

    public static void diceGame() {
        int result = random.nextInt(6) + 1 + random.nextInt(6) + 1;
        System.out.println(
            "You " + (result == 7 ? "win a special prize!" : result < 7 ? "lose." : "win!")
        );
    }

    public static void coinFlipper(int num) {
        int heads = 0;
        int tails = 0;
        for (int i = 0; i < num; i++) {
            if (random.nextBoolean()) {
                heads++;
            } else {
                tails++;
            }
        }
        System.out.println("Heads: " + heads + ", Tails: " + tails);
    }


    public static void coinGame() {
        int c1 = 0;
        int c2 = 0;

        while ((c1 != 3) && (c2 != 3)) {
            if (random.nextBoolean()) {
                c1++;
            } else {
                c1 = 0;
            }
            if (random.nextBoolean()) {
                c2++;
            } else {
                c2 = 0;
            }
            System.out.println(
                "Coin 1: " + (c1 != 0 ? "heads" : "tails") +
                    ", Coin 2: " + (c2 != 0 ? "heads" : "tails")
            );
        }
        System.out.println((c1 == 3 ? "Coin 1" : "Coin 2") + " wins!");
    }

}
