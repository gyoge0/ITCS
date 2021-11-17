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

        Athlete a = new Athlete(1, 1, Display.EAST, Display.INFINITY);

        int[] end = pathFind(a);
        a.turnAround();
        backTrack(a);
        a.turnAround();
        a.putBeeper();
        backTrackRedux(a, end);

    }

    /*
     * path Find
     * 
     * @param a - The Athlete
     * 
     * @return int[] - The coordinates of the end of the maze
     * 
     * Follow the right wall to the end.
     */
    private static int[] pathFind(Athlete a) {
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
        return new int[] { a.getX(), a.getY() };
    }

    /*
     * backTrack
     * 
     * @param a - The Athlete
     * 
     * @precondition - The athlete is at the end of the maze
     * 
     * pathFind, but conditions are adjusted to reach 1, 1 and directions are
     * reversed (since we start at the end and go to start)
     */
    private static void backTrack(Athlete a) {
        // DeMorgan's Law moment
        while (a.getX() != 1 || a.getY() != 1) {
            if (a.frontIsClear() && !a.leftIsClear()) {
                a.move();
            } else if (a.leftIsClear()) {
                a.turnLeft();
                a.move();
            } else if (a.rightIsClear() && !a.frontIsClear() && !a.leftIsClear()) {
                a.turnRight();
                a.move();
            } else if (!a.rightIsClear() && !a.frontIsClear() && !a.leftIsClear()) {
                a.turnAround();
                a.move();
            }
        }
    }

    /*
     * backTrackRedux
     * 
     * @param a- The Athlete
     * 
     * @param coords - The coordinates of the end of the maze
     * 
     * @precondition - The athlete is at the start of the maze
     * 
     * pathFind, but we place beepers as we go and check for coordinates instead of
     * beeper.
     */
    private static void backTrackRedux(Athlete a, int[] coords) {
        // DeMorgan's Law moment
        while (a.getX() != coords[0] || a.getY() != coords[1]) {
            if (a.frontIsClear() && !a.rightIsClear()) {
                a.move();
                a.putBeeper();
            } else if (a.rightIsClear()) {
                a.turnRight();
                a.move();
                a.putBeeper();
            } else if (a.leftIsClear() && !a.frontIsClear() && !a.rightIsClear()) {
                a.turnLeft();
                a.move();
                a.putBeeper();
            } else if (!a.leftIsClear() && !a.frontIsClear() && !a.rightIsClear()) {
                a.turnAround();
                a.move();
                a.putBeeper();
            }
        }
    }

}
