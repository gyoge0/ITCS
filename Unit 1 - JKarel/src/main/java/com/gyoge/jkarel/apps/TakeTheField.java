// Yogesh Thambidurai ITCS
package com.gyoge.jkarel.apps;

import com.gyoge.jkarel.robots.SuperRobot;

import edu.fcps.karel2.Display;

public class TakeTheField {

    private static void enterField(SuperRobot player) {

        player.moveX(4);
        player.turnRight();
        player.moveX(2);

    }

    public static void main(String[] args) {

        Display.openWorld("maps/arena.map");
        Display.setSize(10, 10);

        new SuperRobot(2, 7, Display.EAST);

        /*
         * I spent forever here trying to create a list to hold these guys so I could
         * just loop over it but I forgot my Java lists so I ended up wasting ~30 min on
         * this. Enjoy!
         */
        SuperRobot one = new SuperRobot(1, 1, Display.NORTH);
        SuperRobot two = new SuperRobot(1, 1, Display.NORTH);
        SuperRobot three = new SuperRobot(1, 1, Display.NORTH);
        SuperRobot four = new SuperRobot(1, 1, Display.NORTH);
        SuperRobot five = new SuperRobot(1, 1, Display.NORTH);
        SuperRobot six = new SuperRobot(1, 1, Display.NORTH);

        enterField(one);
        enterField(two);
        enterField(three);
        enterField(four);
        enterField(five);
        enterField(six);

        one.moveX(1);
        two.moveX(2);
        three.moveX(3);
        four.moveX(4);
        five.moveX(5);
        six.moveX(6);

        one.turnRight();
        two.turnRight();
        three.turnRight();
        four.turnRight();
        five.turnRight();
        six.turnRight();

    }

}