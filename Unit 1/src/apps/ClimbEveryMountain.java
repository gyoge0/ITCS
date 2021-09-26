// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;

import robots.SuperRobotV2;

public class ClimbEveryMountain {

    public static void main(String[] args) {
        Display.openWorld("maps/mountain.map");
        Display.setSize(16, 16);
        Display.setSpeed(10);

        SuperRobotV2 asdf = new SuperRobotV2(8, 1, Display.EAST, 1);
        SuperRobotV2 qwer = new SuperRobotV2(8, 1, Display.EAST, 0);

        // Make base camp
        asdf.putBeeper();

        // Position robots at base of hill
        asdf.move();
        qwer.move();

        /*
         * Climb to beeper Each climb is just one call, so unfortunately they climb
         * individually
         */
        asdf.climbUntil(14);
        qwer.climbUntil(14);

        // Pick up beeper
        asdf.pickBeeper();

        // Position robots correctly
        asdf.turnAround();
        qwer.turnAround();

        /*
         * Climb back to base Again, each climb is one call
         */
        asdf.climbUntil(9);
        qwer.climbUntil(9);

        // Position robots
        asdf.move();
        qwer.move();

        // Drop beeper
        asdf.putBeeper();

        // Move to show beepers
        asdf.turnRight();
        qwer.turnRight();
        asdf.move();
        qwer.move();

    }

}
