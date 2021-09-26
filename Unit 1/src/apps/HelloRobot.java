// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class HelloRobot {

    public static void main(String[] args) {

        Display.openWorld("lib/Jkarel Start Files/maps/first.map");
        Display.setSize(10, 10);

        Robot bob = new Robot();

        bob.move();
        bob.pickBeeper();
        bob.move();
        bob.turnLeft();
        bob.move();
        bob.putBeeper();
        bob.move();
        bob.turnLeft();
        bob.turnLeft();

    }

}