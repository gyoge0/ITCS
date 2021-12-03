// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;
import javax.swing.JOptionPane;
import robots.MultiTasker;

public class MakePyramid2 {

    public static void main(String[] args) {

        Display.openWorld(" ");
        Display.setSize(8, 8);
        Display.setSpeed(1);

        MultiTasker asdf = new MultiTasker(1, 1, Display.EAST, 10);

        // One
        asdf.dropAndMove();

        // Two
        asdf.turnLeft();
        asdf.dropAndMove();
        asdf.dropAndMove();
        asdf.turnAround();
        asdf.move();
        asdf.move();
        asdf.turnLeft();
        asdf.move();

        // Three
        asdf.turnLeft();
        asdf.dropAndMove();
        asdf.dropAndMove();
        asdf.dropAndMove();
        asdf.turnAround();
        asdf.move();
        asdf.move();
        asdf.move();
        asdf.turnLeft();
        asdf.move();

        // Four
        asdf.turnLeft();
        asdf.dropAndMove();
        asdf.dropAndMove();
        asdf.dropAndMove();
        asdf.dropAndMove();
        asdf.turnAround();
        asdf.move();
        asdf.move();
        asdf.move();
        asdf.move();
        asdf.turnLeft();
        asdf.move();

        // Ending message
        printFinishMessage("ew shell code");

    }

    // Prints the message to a dialog box
    private static void printFinishMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

}
