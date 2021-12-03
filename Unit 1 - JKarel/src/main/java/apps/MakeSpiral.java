// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;
import robots.MultiTasker;

public class MakeSpiral {

    public static void main(String[] args) {

        Display.openWorld(" ");
        Display.setSpeed(10);

        MultiTasker asdf = new MultiTasker();
        asdf.turnRight();

        asdf.putBeeper();

        // First for loop does 8 and has 3 iterations
        for (int i = 0; i < 3; i++) {
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.turnLeft();
        }

        // Now do 2 iterations with moves decreasing by 2 each time
        for (int i = 0; i < 2; i++) {
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.turnLeft();
        }
        for (int i = 0; i < 2; i++) {
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.turnLeft();
        }
        for (int i = 0; i < 2; i++) {
            asdf.moveAndDrop();
            asdf.moveAndDrop();
            asdf.turnLeft();
        }

    }

}
