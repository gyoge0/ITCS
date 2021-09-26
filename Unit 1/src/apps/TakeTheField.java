// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;

import robots.SuperRobotV2;

public class TakeTheField {

    public static void enterField(SuperRobotV2 player) {

        player.moveX(4);
        player.turnRight();
        player.moveX(2);

    }

    public static void main(String[] args) {

        Display.openWorld("maps/arena.map");
        Display.setSize(10, 10);

        SuperRobotV2 uselessCoach = new SuperRobotV2(2, 7, Display.EAST);

        /*
         * I spent forever here trying to create a list to hold these guys so I could
         * just loop over it but I forgot my Java lists so I ended up wasting ~30 min on
         * this. Enjoy!
         */
        SuperRobotV2 one = new SuperRobotV2(1, 1, Display.NORTH);
        SuperRobotV2 two = new SuperRobotV2(1, 1, Display.NORTH);
        SuperRobotV2 three = new SuperRobotV2(1, 1, Display.NORTH);
        SuperRobotV2 four = new SuperRobotV2(1, 1, Display.NORTH);
        SuperRobotV2 five = new SuperRobotV2(1, 1, Display.NORTH);
        SuperRobotV2 six = new SuperRobotV2(1, 1, Display.NORTH);

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