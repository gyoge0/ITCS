// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;

import robots.Athlete;

public class MakePyramid {

   public static void main(String[] args) {

      Display.openWorld(" ");

      Athlete asdf = new Athlete(1, 1, Display.EAST, 10);

      asdf.putBeeper();
      asdf.move();

      asdf.turnLeft();
      for (int i = 0; i < 2; i++) {
         asdf.putBeeper();
         asdf.move();
      }
      asdf.turnAround();
      asdf.move();
      asdf.move();
      asdf.turnLeft();
      asdf.move();

      asdf.turnLeft();
      for (int i = 0; i < 3; i++) {
         asdf.putBeeper();
         asdf.move();
      }
      asdf.turnAround();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.turnLeft();
      asdf.move();

      asdf.turnLeft();
      for (int i = 0; i < 4; i++) {
         asdf.putBeeper();
         asdf.move();
      }
      asdf.turnAround();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.move();
      asdf.turnLeft();
      asdf.move();

   }

}
