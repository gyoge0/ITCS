// Yogesh Thambidurai ITCS

package frames;

import java.util.ArrayList;
import java.util.Arrays;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class WinterWonderland extends JPanel {

    private static int WIDTH;
    private static int HEIGHT;

    public WinterWonderland (int width, int height) {
        super();
        WIDTH = width;
        HEIGHT = height;
    }

    @Override
    public void paintComponent(Graphics goon) {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Goon presents: WinterWonderland by Yogesh Thambidurai");
        frame.setSize(1000, 800);
        frame.setLocation(0, 0);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setContentPane(new WinterWonderland(600, 800));
        frame.setVisible(true);
    }

}