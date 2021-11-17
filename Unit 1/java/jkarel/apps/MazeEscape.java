// Yogesh Thambidurai ITCS

package apps;

import javax.swing.JOptionPane;

import edu.fcps.karel2.Display;
import robots.Athlete;

public class MazeEscape {

    public static void main(String[] args) {

        String[] choices = { "maze1", "maze2", "maze3", "maze4" };
        String mapChoice = (String) JOptionPane.showInputDialog(null, "Choose a map.", "Map Choices",
                JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);

        Display.openWorld("Unit 1/lib/Jkarel Start Files/maps/" + mapChoice + ".map");
        Display.setSpeed(10);

        pathFind(new Athlete(1, 1, Display.EAST, Display.INFINITY));

    }

    /*
     * pathFind
     * 
     * @param a - The Athlete
     * 
     * Follow the right wall to the end.
     */
    private static void pathFind(Athlete a) {
        // Follow wall
        while (!a.nextToABeeper()) {
            if (a.frontIsClear() && !a.rightIsClear()) {
                a.move();
            }
            // Right is open, move!!
            else if (a.rightIsClear()) {
                a.turnRight();
                a.move();
            }
            // turn left moment
            else if (a.leftIsClear() && !a.frontIsClear() && !a.rightIsClear()) {
                a.turnLeft();
                a.move();
            }
            // dead end moment
            else if (!a.leftIsClear() && !a.frontIsClear() && !a.rightIsClear()) {
                a.turnAround();
                a.move();
            }
        }
    }
}
