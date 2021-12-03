// Yogesh Thambidurai ITCS

package frames;

import java.util.ArrayList;
import java.util.Arrays;

import java.awt.*;
import javax.swing.*;

public class HelloGraphics extends JPanel {

    @Override
    public void paintComponent(Graphics goon) {

        goon.setColor(Color.RED);
        goon.fillOval(100, 100, 100, 100);

        goon.setColor(new Color(69, 69, 69));
        goon.fillRect(420, 420, 69, 69);

        goon.setColor(Color.darkGray);
        goon.drawLine(0, 0, 500, 0);

        goon.setColor(Color.lightGray);
        goon.drawLine(0, 0, 0, 500);

        goon.setFont(new Font("JetBrains Mono", Font.BOLD, 75));
        goon.setColor(Color.BLACK);

        ArrayList<String> words = new ArrayList<>(Arrays.asList("ITS ABOUT DRIVE", "ITS ABOUT POWER",
                "WE STAY HUNGRY", "WE DEVOUR", "PUT IN THE WORK", "PUT IN THE HOURS", "AND TAKE WHATS OURS"));
        for (int i = 1; i < words.size(); i++) {
            goon.drawString(words.get(i), 10, (i + 1) * 100);
        }

        goon.setColor(new Color(123, 123, 123));
        for (int i = 0; i < 3; i++) {
            goon.fillOval(i * 10, i * 10, 10, 10);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Goon presents: HelloGraphics by Yogesh Thambidurai");
        frame.setSize(1000, 800);
        frame.setLocation(0, 0);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setContentPane(new HelloGraphics());
        frame.setVisible(true);
    }

}