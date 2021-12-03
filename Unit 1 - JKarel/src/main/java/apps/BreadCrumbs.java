// Yogesh Thambidurai ITCS

package apps;

import edu.fcps.karel2.Display;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import robots.Athlete;


public class BreadCrumbs {

    private static final ArrayList<int[]> coordinates = new ArrayList<>();

    public static void main(String[] args) {

        String[] choices = {"maze1", "maze2", "maze3", "maze4"};
        String mapChoice = (String) JOptionPane.showInputDialog(null, "Choose a map.",
            "Map Choices",
            JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);

        Display.openWorld("maps/" + mapChoice + ".map");
        Display.setSpeed(10);

        Athlete a = new Athlete(1, 1, Display.EAST, Display.INFINITY);
        pathFind(a);
        tracePath(a);

    }

    /*
     * pathFind
     *
     * @param a - The Athlete
     *
     * Follow the right wall to the end, while adding in coordinates to the end.
     */
    private static void pathFind(Athlete a) {
        // Follow wall
        while (!a.nextToABeeper()) {
            if (a.frontIsClear() && !a.rightIsClear()) {
                coordinates.add(new int[]{a.getX(), a.getY()});
                a.move();
            }
            // Right is open, move!!
            else if (a.rightIsClear()) {
                a.turnRight();
                coordinates.add(new int[]{a.getX(), a.getY()});
                a.move();
            }
            // turn left moment
            else if (a.leftIsClear() && !a.frontIsClear() && !a.rightIsClear()) {
                a.turnLeft();
                coordinates.add(new int[]{a.getX(), a.getY()});
                a.move();
            }
            // dead end moment
            else if (!a.leftIsClear() && !a.frontIsClear() && !a.rightIsClear()) {
                a.turnAround();
                coordinates.add(new int[]{a.getX(), a.getY()});
                a.move();
            }
        }
    }

    /*
     * lastIndexOf
     *
     * @param int[] - The element to find the last index of
     *
     * @return int - The last index of the element; -1 if not found
     *
     * a method that finds the last equal element in the array
     */
    private static int lastIndexOf(int[] element) {
        for (int i = coordinates.size() - 1; i >= 0; i--) {
            if (coordinates.get(i)[0] == element[0] && coordinates.get(i)[1] == element[1]) {
                return i;
            }
        }
        return -1;
    }

    /*
     * makeEfficient
     *
     * makes the coordinates list efficient by removing duplicates.
     */
    private static void makeEfficient() {
        int i = 0;
        while (i < coordinates.size()) {
            int lastIdx = lastIndexOf(coordinates.get(i));
            if (lastIdx != i) {
                for (int j = 0; j < lastIdx - i; j++) {
                    coordinates.remove(i);
                }
            }

            i++;
        }
    }

    /*
     * tracePath
     *
     * @param a - The Athlete
     *
     * follow the coordinates list and drop a beeper at each spot.
     */
    private static void tracePath(Athlete a) {
        makeEfficient();
        Collections.reverse(coordinates);
        for (int[] coord : coordinates) {
            if (coord[0] == a.getX() && coord[1] == a.getY() + 1) {
                while (a.getDirection() != Display.NORTH) {
                    a.turnLeft();
                }
                a.move();
                a.putBeeper();
            } else if (coord[0] == a.getX() && coord[1] == a.getY() - 1) {
                while (a.getDirection() != Display.SOUTH) {
                    a.turnLeft();
                }
                a.move();
                a.putBeeper();
            } else if (coord[0] == a.getX() + 1 && coord[1] == a.getY()) {
                while (a.getDirection() != Display.EAST) {
                    a.turnLeft();
                }
                a.move();
                a.putBeeper();
            } else if (coord[0] == a.getX() - 1 && coord[1] == a.getY()) {
                while (a.getDirection() != Display.WEST) {
                    a.turnLeft();
                }
                a.move();
                a.putBeeper();
            }
        }
    }
}
