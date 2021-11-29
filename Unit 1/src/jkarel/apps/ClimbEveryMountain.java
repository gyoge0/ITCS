// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;

import robots.SuperClimber;

public class ClimbEveryMountain {

    public static void main(String[] args) {
        Display.openWorld("lib/Jkarel Start Files/maps/mountain.map");
        Display.setSize(16, 16);
        Display.setSpeed(10);

        SuperClimber asdf = new SuperClimber(8, 1, Display.EAST, 1);
        SuperClimber qwer = new SuperClimber(8, 1, Display.EAST, 0);

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
