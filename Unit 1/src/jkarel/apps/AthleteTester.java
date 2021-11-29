// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;

import robots.Athlete;

public class AthleteTester {

   public static void main(String[] args) {

      Display.openWorld(" ");

      Athlete usainBolt = new Athlete();

      usainBolt.move();
      usainBolt.move();
      usainBolt.move();
      usainBolt.turnRight();

      Athlete michaelPhelps = new Athlete(3, 2, Display.NORTH, 0);

      michaelPhelps.move();
      michaelPhelps.move();
      michaelPhelps.turnAround();

   }

}
