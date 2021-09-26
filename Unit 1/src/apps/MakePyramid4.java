// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;
import javax.swing.JOptionPane;

import robots.MultiTasker;

public class MakePyramid4 {

    public static void main(String[] args) {

        int numColumns = getNumColumns();

        Display.setSize(numColumns, numColumns);

        Display.setSpeed(10);

        MultiTasker worker = new MultiTasker();

        createPyramid(worker, numColumns);

        printFinishMessage("Pyramid complete.");

    }

    // Prompts and returns the number of columns to build
    public static int getNumColumns() {

        String value = JOptionPane.showInputDialog("Enter the number of columns for the pyramid");

        return Integer.parseInt(value);

    }

    // Creates a pyramid with a MultiTasker robot numColumns high
    public static void createPyramid(MultiTasker temp, int numColumns) {

        for (int i = 1; i <= numColumns; i++) {
            goUp(temp, i);
            goBack(temp, i);
            moveOver(temp);
        }
    }

    public static void goUp(MultiTasker worker, int numBeepers) {
        for (int i = 0; i < numBeepers; i++) {
            worker.dropAndMove();
        }

    }

    public static void goBack(MultiTasker worker, int numBeepers) {
        worker.turnAround();
        for (int i = 0; i < numBeepers; i++) {
            worker.move();
        }
        worker.turnLeft();
    }

    public static void moveOver(MultiTasker worker) {
        worker.move();
        worker.turnLeft();
    }

    public static void printFinishMessage(String message) {

        JOptionPane.showMessageDialog(null, message);
    }

}