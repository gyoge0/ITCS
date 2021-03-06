// Yogesh Thambidurai ITCS

package com.gyoge.jkarel.apps;

import com.gyoge.jkarel.robots.Climber;
import com.gyoge.jkarel.robots.HillClimber;
import com.gyoge.jkarel.robots.StepClimber;

import edu.fcps.karel2.Display;
import javax.swing.JOptionPane;

public class Exploration {

    // declare and initialize array of map choices for the dialogue drop-down
    // options
    private static final String[] choices = {"mountain1", "mountain2", "mountain3", "hill1",
        "hill2", "hill3", "step1",
        "step2", "step3"};

    public static void main(String[] args) {
        // open dialogue box and request user input of map choices
        String mapChoice = (String) JOptionPane.showInputDialog(null, "Choose an map.",
            "Map Choices",
            JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);

        // open selected map and set size and speed
        Display.openWorld("maps//" + mapChoice + ".map");
        Display.setSize(17, 15);
        Display.setSpeed(10);

        // When did we learn this :eyes:
        Climber george;

        // Wanted a switch here but switch true seems like bad code
        if (mapChoice.contains("hill")) {
            george = new HillClimber(10);
        } else if (mapChoice.contains("step")) {
            george = new StepClimber(12);
        } else { // Either "mountain" or invalid entry
            george = new Climber(8);
        }

        Mountain.explore(george);

    }
}