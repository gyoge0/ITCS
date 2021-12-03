// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;

import robots.MultiTasker;

public class MakeAsterisk {

   public static void main(String[] args) {

      Display.openWorld(" ");
      Display.setSpeed(10);

      MultiTasker asdf = new MultiTasker();
      asdf.turnRight();

      // first beeper
      asdf.putBeeper();

      // first diagonal
      for (int i = 0; i < 8; i++) {
         asdf.move();
         asdf.turnLeft();
         asdf.moveAndDrop();
         asdf.turnRight();
      }

      // positioning
      asdf.turnRight();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.turnRight();

      // first beeper
      asdf.putBeeper();

      // first half of second diagonal
      for (int i = 0; i < 3; i++) {
         asdf.move();
         asdf.turnRight();
         asdf.moveAndDrop();
         asdf.turnLeft();
      }

      // skip center
      asdf.move();
      asdf.turnRight();
      asdf.move();
      asdf.turnLeft();

      // second half of second diagonal
      for (int i = 0; i < 4; i++) {
         asdf.move();
         asdf.turnRight();
         asdf.moveAndDrop();
         asdf.turnLeft();
      }

      // positioning
      asdf.turnLeft();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.turnLeft();

      // horizontal line
      asdf.dropAndMove();
      asdf.dropAndMove();
      asdf.dropAndMove();
      asdf.dropAndMove();
      asdf.move();
      asdf.dropAndMove();
      asdf.dropAndMove();
      asdf.dropAndMove();
      asdf.dropAndMove();

      // positioning
      asdf.turnLeft();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.turnLeft();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.turnLeft();

      // vertical line
      asdf.dropAndMove();
      asdf.dropAndMove();
      asdf.dropAndMove();
      asdf.dropAndMove();
      asdf.move();
      asdf.dropAndMove();
      asdf.dropAndMove();
      asdf.dropAndMove();
      asdf.dropAndMove();

   }

}
