// Yogesh Thambidurai ITCS
package com.gyoge.jkarel.apps;

import edu.fcps.karel2.Display;
import com.gyoge.jkarel.robots.MultiTasker;

public class MakeInitials {

    public static void main(String[] args) {

        Display.openWorld(" ");
        Display.setSize(15, 15);
        Display.setSpeed(10);

        MultiTasker asdf = new MultiTasker();

        asdf.turnRight();

        asdf.move();
        asdf.move();
        asdf.move();
        asdf.turnLeft();
        asdf.dropAndMove();
        asdf.dropAndMove();
        asdf.dropAndMove();

        // Y
        asdf.turnLeft();
        asdf.moveAndDrop();
        asdf.move();
        asdf.turnRight();
        asdf.moveAndDrop();
        asdf.turnRight();
        asdf.move();
        asdf.move();
        asdf.move();
        asdf.move();
        asdf.turnRight();
        asdf.dropAndMove();
        asdf.turnRight();
        asdf.moveAndDrop();

        // Positioning
        asdf.turnAround();
        asdf.move();
        asdf.move();
        asdf.move();
        asdf.turnLeft();

        // T
        asdf.moveAndDrop();
        asdf.turnRight();
        asdf.moveAndDrop();
        asdf.moveAndDrop();
        asdf.moveAndDrop();
        asdf.moveAndDrop();
        asdf.turnAround();
        asdf.move();
        asdf.move();
        asdf.turnLeft();
        asdf.moveAndDrop();
        asdf.moveAndDrop();
        asdf.moveAndDrop();
        asdf.moveAndDrop();

    }

}
