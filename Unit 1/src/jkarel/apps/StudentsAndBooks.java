// Yogesh Thambidurai ITCS
package apps;

import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class StudentsAndBooks {

   public static void main(String[] args) {

      Display.openWorld("maps/ACL.map");
      Display.setSize(10, 10);
      Display.setSpeed(10);

      Robot lisa = new Robot();
      Robot pete = new Robot(4, 5, 3, 0);

      // lisa being an idiot and taking up 65+ lines because she is poorly implemented

      lisa.move();
      lisa.move();

      lisa.turnLeft();

      lisa.move();

      lisa.turnLeft();

      lisa.move();

      lisa.pickBeeper();

      lisa.turnLeft();
      lisa.turnLeft();

      lisa.move();

      lisa.turnLeft();
      lisa.turnLeft();
      lisa.turnLeft();

      lisa.move();

      lisa.turnLeft();

      lisa.move();
      lisa.move();
      lisa.move();

      lisa.turnLeft();

      for (int robotClassIsPoorlyImplemented = 0; robotClassIsPoorlyImplemented < 5; robotClassIsPoorlyImplemented++) {
         lisa.move();
      }

      lisa.turnLeft();
      lisa.turnLeft();
      lisa.turnLeft();

      lisa.move();
      lisa.move();

      lisa.pickBeeper();

      lisa.turnLeft();

      lisa.move();

      lisa.turnLeft();

      lisa.move();
      lisa.move();

      lisa.turnLeft();
      lisa.turnLeft();
      lisa.turnLeft();

      lisa.move();
      lisa.move();

      lisa.turnLeft();
      lisa.move();

      lisa.putBeeper();
      lisa.putBeeper();

      lisa.turnLeft();
      lisa.turnLeft();

      lisa.move();

      lisa.turnLeft();
      lisa.turnLeft();
      lisa.turnLeft();

      lisa.move();

      // here comes the pete (doo doo doo do doo)

      pete.turnLeft();
      pete.turnLeft();
      pete.turnLeft();

      pete.move();

      pete.turnLeft();

      pete.move();

      pete.pickBeeper();
      pete.pickBeeper();

      pete.turnLeft();

      pete.move();
      pete.move();
      pete.move();

      pete.turnLeft();

      pete.move();
      pete.move();

      pete.turnLeft();
      pete.turnLeft();
      pete.turnLeft();

      pete.move();
      pete.move();

      pete.turnLeft();

      pete.move();

      pete.turnLeft();

      pete.move();
      pete.move();

      pete.turnLeft();
      pete.turnLeft();
      pete.turnLeft();

      pete.move();
      pete.move();

      pete.turnLeft();

      pete.move();

      pete.putBeeper();

      pete.turnLeft();
      pete.turnLeft();

      pete.move();

      pete.turnLeft();
      pete.turnLeft();
      pete.turnLeft();

      pete.move();
      pete.move();

      // introducing the librarian (because of course we need one)

      Robot myJobIsPointless = new Robot(6, 9, 1, 0);

      myJobIsPointless.turnLeft();
      myJobIsPointless.turnLeft();
      myJobIsPointless.turnLeft();

      myJobIsPointless.move();

      myJobIsPointless.pickBeeper();
      myJobIsPointless.pickBeeper();
      myJobIsPointless.pickBeeper();

      myJobIsPointless.move();

      myJobIsPointless.pickBeeper();
      myJobIsPointless.pickBeeper();
      myJobIsPointless.pickBeeper();

      myJobIsPointless.turnLeft();
      myJobIsPointless.turnLeft();

      myJobIsPointless.move();
      myJobIsPointless.move();
      myJobIsPointless.move();

      myJobIsPointless.pickBeeper();
      myJobIsPointless.pickBeeper();
      myJobIsPointless.pickBeeper();

      myJobIsPointless.move();

      myJobIsPointless.pickBeeper();
      myJobIsPointless.pickBeeper();

      myJobIsPointless.move();

      myJobIsPointless.pickBeeper();
      myJobIsPointless.pickBeeper();
      myJobIsPointless.pickBeeper();

      myJobIsPointless.move();

      for (int beepBeep = 0; beepBeep < 10; beepBeep++) {
         myJobIsPointless.putBeeper();
      }

      // fun stuff

      myJobIsPointless.turnLeft();
      myJobIsPointless.turnLeft();

      for (int butWhyTho = 0; butWhyTho < 4; butWhyTho++) {
         myJobIsPointless.move();
      }

      myJobIsPointless.turnLeft();
      myJobIsPointless.turnLeft();
      myJobIsPointless.turnLeft();

      // dance

      for (int danceLikeYourLifeDependsOnIt = 0; danceLikeYourLifeDependsOnIt < 100; danceLikeYourLifeDependsOnIt++) {
         myJobIsPointless.turnLeft();
      }

      lisa.explode();
      pete.explode();
      myJobIsPointless.explode();

   }

}
