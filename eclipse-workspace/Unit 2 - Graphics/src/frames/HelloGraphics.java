// Yogesh Thambidurai ITCS

package frames;

import java.util.ArrayList;
import java.util.Arrays;

import java.awt.*;
import javax.swing.*;

public class HelloGraphics extends JPanel {

    @Override
    public void paintComponent(Graphics goon) {

        JLabel

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