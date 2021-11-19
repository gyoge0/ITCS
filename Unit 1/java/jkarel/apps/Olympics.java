// Yogesh Thambidurai ITCS

package apps;

import edu.fcps.karel2.Display;
import javax.swing.JOptionPane;

import robots.TrackStar;

public class Olympics {

    private static final String[] mapChoices = { "track1", "track2", "track3" };

    public static void main(String[] args) {

        String mapChoice = (String) JOptionPane.showInputDialog(null, "Choose an map.", "Map Choices",
                JOptionPane.PLAIN_MESSAGE, null, mapChoices, mapChoices[0]);

        Display.openWorld("Unit 1/java/lib/Jkarel Start Files/maps/" + mapChoice + ".map");
        Display.setSize(12, 12);
        Display.setSpeed(10);

        TrackStar itsAboutDriveItsAboutPowerWeStayHungryWeDevourPutInTheWorkPutInTheHoursAndTakeWhatsOurs = new TrackStar(
                "ITS ABOUT DRIVE ITS ABOUT POWER WE STAY HUNGRY WE DEVOUR PUT IN THE WORK PUT IN THE HOURS AND TAKE WHATS OURS");

        itsAboutDriveItsAboutPowerWeStayHungryWeDevourPutInTheWorkPutInTheHoursAndTakeWhatsOurs.runLap();
        itsAboutDriveItsAboutPowerWeStayHungryWeDevourPutInTheWorkPutInTheHoursAndTakeWhatsOurs.runLap();
        System.out.println(itsAboutDriveItsAboutPowerWeStayHungryWeDevourPutInTheWorkPutInTheHoursAndTakeWhatsOurs
                .getName() + " took "
                + itsAboutDriveItsAboutPowerWeStayHungryWeDevourPutInTheWorkPutInTheHoursAndTakeWhatsOurs.getSteps()
                + " steps.");
        System.out.println("Laps: "
                + itsAboutDriveItsAboutPowerWeStayHungryWeDevourPutInTheWorkPutInTheHoursAndTakeWhatsOurs.getLaps()
                + "\n");

        itsAboutDriveItsAboutPowerWeStayHungryWeDevourPutInTheWorkPutInTheHoursAndTakeWhatsOurs.resetCount();
        itsAboutDriveItsAboutPowerWeStayHungryWeDevourPutInTheWorkPutInTheHoursAndTakeWhatsOurs.warmUp(4);
        System.out.println(itsAboutDriveItsAboutPowerWeStayHungryWeDevourPutInTheWorkPutInTheHoursAndTakeWhatsOurs
                .getName()
                + " finished warming up while listening to auditory protein, AKA ITS ABOUT DRIVE ITS ABOUT POWER WE STAY HUNGRY WE DEVOUR PUT IN THE WORK PUT IN THE HOURS AND TAKE WHATS HOURS.\n");
        System.out.println(
                "While listening to auditory protein AKA ITS ABOUT DRIVE ITS ABOUT POWER WE STAY HUNGRY WE DEVOUR PUT IN THE WORK PUT IN THE HOURS AND TAKE WHATS HOURS, "
                        + itsAboutDriveItsAboutPowerWeStayHungryWeDevourPutInTheWorkPutInTheHoursAndTakeWhatsOurs
                                .getName()
                        + " ran "
                        + itsAboutDriveItsAboutPowerWeStayHungryWeDevourPutInTheWorkPutInTheHoursAndTakeWhatsOurs
                                .getLaps()
                        + " laps and "
                        + itsAboutDriveItsAboutPowerWeStayHungryWeDevourPutInTheWorkPutInTheHoursAndTakeWhatsOurs
                                .calculateMiles()
                        + " miles.");

    }

}
