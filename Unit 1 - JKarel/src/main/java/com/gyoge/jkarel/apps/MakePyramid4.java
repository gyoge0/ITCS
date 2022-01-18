// Yogesh Thambidurai ITCS
package com.gyoge.jkarel.apps;

import com.gyoge.jkarel.robots.MultiTasker;

import edu.fcps.karel2.Display;
import javax.swing.JOptionPane;

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
    private static int getNumColumns() {

        String value = JOptionPane.showInputDialog("Enter the number of columns for the pyramid");

        return Integer.parseInt(value);

    }

    // Creates a pyramid with a MultiTasker robot numColumns high
    private static void createPyramid(MultiTasker temp, int numColumns) {

        for (int i = 1; i <= numColumns; i++) {
            goUp(temp, i);
            goBack(temp, i);
            moveOver(temp);
        }
    }

    private static void goUp(MultiTasker worker, int numBeepers) {
        for (int i = 0; i < numBeepers; i++) {
            worker.dropAndMove();
        }

    }

    private static void goBack(MultiTasker worker, int numBeepers) {
        worker.turnAround();
        for (int i = 0; i < numBeepers; i++) {
            worker.move();
        }
        worker.turnLeft();
    }

    private static void moveOver(MultiTasker worker) {
        worker.move();
        worker.turnLeft();
    }

    private static void printFinishMessage(String message) {

        JOptionPane.showMessageDialog(null, message);
    }

}