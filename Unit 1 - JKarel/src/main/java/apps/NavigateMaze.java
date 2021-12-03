// Yogesh Thambidurai ITCS

package apps;

import edu.fcps.karel2.Display;
import javax.swing.JOptionPane;
import robots.Athlete;

public class NavigateMaze {

    private static final String[] choices = {"Move", "Go Left", "Go Right", "Turn Around", "Quit"};

    public static void main(String[] args) {

        Display.openWorld("maps//maze5.map");
        Display.setSize(8, 8);
        Display.setSpeed(7);

        Athlete navigator = new Athlete();

        navigateMaze(navigator);

        printFinishedMessage("Maze Complete");

    }

    // The robot will move through the map until it gets to the beeper
    private static void navigateMaze(Athlete temp) {

        while (!temp.nextToABeeper()) {
            chooseNextAction(temp);
        }

    }

    // Moves the robot based upon the next action chosen.
    private static void chooseNextAction(Athlete temp) {

        String mapChoice = (String) JOptionPane.showInputDialog(null, "Choose an action.",
            "Maze Choices",
            JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);

        // the user clicked the cancel button, so just exit
        switch (mapChoice) {
            case "Move":
                if (temp.frontIsClear()) {
                    temp.move();
                }
                break;

            case "Go Left":
                if (temp.leftIsClear()) {
                    temp.turnLeft();
                    temp.move();
                }
                break;

            case "Go Right":
                if (temp.rightIsClear()) {
                    temp.turnRight();
                    temp.move();
                }
                break;

            case "Turn Around":
                temp.turnAround();
                break;

            // the user clicked the cancel button, so just exit
            default:
                System.exit(0);
                break;
        }

    }

    private static void printFinishedMessage(String message) {

        JOptionPane.showMessageDialog(null, message);
    }
}

class SafeAthlete extends Athlete {

    public SafeAthlete() {
        super(1, 1, Display.NORTH, Display.INFINITY);
    }

    public SafeAthlete(int x, int y, int dir, int beepers) {
        super(x, y, dir, beepers);
    }

    public void safeMove() {
        if (frontIsClear()) {
            move();
        }
    }
}