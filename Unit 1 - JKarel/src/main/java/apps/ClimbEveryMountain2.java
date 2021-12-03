// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;
import robots.SuperClimber;

public class ClimbEveryMountain2 {

    public static void main(String[] args) {
        Display.openWorld("maps/mountain3.map");
        Display.setSize(16, 16);
        Display.setSpeed(10);

        SuperClimber asdf = new SuperClimber(8, 1, Display.EAST, 1);

        // Positioning
        asdf.move();

        // Climb the mountain
        asdf.climbUntil(10);

        /*
         * Return I haven't implemented climb down. That's something for later.
         */
        asdf.pickBeeper();
        asdf.turnAround();
        asdf.move();
        asdf.turnLeft();
        asdf.move();
        asdf.move();
        asdf.turnRight();
        asdf.move();
        asdf.putBeeper();

        // new robot
        SuperClimber qwer = new SuperClimber(8, 1, Display.WEST, 1);
        qwer.pickBeeper();

        qwer.move();
        qwer.climbUntil(2);
        qwer.putBeeper();
        qwer.turnAround();

        // Again, now climb down
        for (int i = 0; i < 5; i++) {
            qwer.move();
            qwer.turnRight();
            qwer.move();
            qwer.move();
            qwer.turnLeft();
        }

    }

}