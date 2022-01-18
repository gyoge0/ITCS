package com.gyoge.jkarel.apps;

import edu.fcps.karel2.Display;
import com.gyoge.jkarel.robots.Dancer;

public class DanceParty {

    public static void main(String[] args) {
        Display.setSize(110, 5);
        Display.setSpeed(10);

        for (int i = 6; i <= 16; i++) {
            new Thread(new Spinner(i * 3)).start();
            new Thread(new Snaker(i * 3 - 1)).start();
            new Thread(new TwoForwardOneBack(i * 3 - 2)).start();
        }
    }

}

/*
 * The classes that extend dancer
 *
 * In this file because I don't feel like making 3 more for a super niche
 * purpose
 */
class Spinner extends Dancer {

    public Spinner(int x) {
        super(x);
    }

    @Override
    public void dance() {

        for (int i = 0; i < 15; i++) {
            this.move();
        }
        for (int i = 0; i < 15; i++) {
            this.turnAround();
        }
        for (int i = 0; i < 15; i++) {
            this.move();
        }

    }

}

class Snaker extends Dancer {

    public Snaker(int x) {
        super(x);
    }

    @Override
    public void dance() {

        for (int i = 0; i < 3; i++) {
            this.move();
        }
        this.turnLeft();
        for (int i = 0; i < 3; i++) {
            this.move();
        }
        this.turnRight();
        for (int i = 0; i < 3; i++) {
            this.move();
        }
        this.turnRight();
        for (int i = 0; i < 3; i++) {
            this.move();
        }
        this.turnLeft();
    }

}

class TwoForwardOneBack extends Dancer {

    public TwoForwardOneBack(int x) {
        super(x);
    }

    @Override
    public void dance() {
        this.move();
        this.move();
        this.turnAround();
        this.move();
        this.turnAround();
    }
}