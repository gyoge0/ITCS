// Yogesh Thambidurai ITCS

package frames;

import objects.Rick;

import java.util.ArrayList;
import java.util.Arrays;

import java.awt.*;
import javax.swing.*;

public class WinterWonderland extends JPanel {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    @Override
    public void paintComponent(Graphics goon) {

        // Background
        goon.setColor(new Color(45, 90, 167));
        goon.fillRect(0, 0, WIDTH, HEIGHT / 2);

        goon.setColor(Color.WHITE);
        goon.fillRect(0, HEIGHT / 2, WIDTH, HEIGHT / 2);

        new Rick().draw(goon, 100, 100);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Goon presents: WinterWonderland by Yogesh Thambidurai");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setContentPane(new WinterWonderland());
        frame.setVisible(true);
    }

}