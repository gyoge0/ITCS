// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;

import robots.Miner;

public class Goldmine {

    public static void main(String[] args) {

        Display.openWorld("lib/Jkarel Start Files/maps/mine.map");
        Display.setSize(10, 10);
        Display.setSpeed(10);

        Miner one = new Miner(3, 6, Display.EAST, 0);
        Miner two = new Miner(8, 6, Display.SOUTH, 0);
        Miner three = new Miner(8, 1, Display.WEST, 0);
        Miner four = new Miner(1, 1, Display.NORTH, 0);
        Miner five = new Miner(1, 8, Display.EAST, 0);

        one.move();
        for (int i = 0; i < 6; i++) {
            one.pickBeeper();
        }
        for (int i = 0; i < 4; i++) {
            one.move();
        }
        for (int i = 0; i < 6; i++) {
            one.putBeeper();
            two.pickBeeper();
        }
        for (int i = 0; i < 4; i++) {
            two.move();
        }
        for (int i = 0; i < 7; i++) {
            two.pickBeeper();
        }
        two.move();
        for (int i = 0; i < 13; i++) {
            two.putBeeper();
            three.pickBeeper();
        }
        for (int i = 0; i < 4; i++) {
            three.move();
        }
        for (int i = 0; i < 8; i++) {
            three.pickBeeper();
        }
        for (int i = 0; i < 3; i++) {
            three.move();
        }
        for (int i = 0; i < 21; i++) {
            three.putBeeper();
            four.pickBeeper();
        }
        for (int i = 0; i < 6; i++) {
            four.move();
        }
        for (int i = 0; i < 9; i++) {
            four.pickBeeper();
        }
        four.move();
        for (int i = 0; i < 30; i++) {
            four.putBeeper();
            five.pickBeeper();
        }
        for (int i = 0; i < 9; i++) {
            five.move();
        }
        for (int i = 0; i < 30; i++) {
            five.putBeeper();
        }
        five.move();

        one.explode();
        two.explode();
        three.explode();
        four.explode();

    }
}
