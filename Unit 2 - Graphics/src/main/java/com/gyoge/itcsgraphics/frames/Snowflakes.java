package com.gyoge.itcsgraphics.frames;

import com.gyoge.itcsgraphics.drawables.Snowflake;

import java.util.Random;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Draw some snowflakes.
 *
 * @author Yogesh Thambidurai
 */
public class Snowflakes extends JPanel {

    /** Random object to use. */
    private static final Random random = new Random();
    /** The height of the drawing. */
    private static final int HEIGHT = 600;
    /** The width of the drawing. */
    private static final int WIDTH = 600;

    /**
     * Main method.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Goon presents: Snowflakes by Yogesh Thambidurai");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Snowflakes snowflakes = new Snowflakes();
        frame.setContentPane(snowflakes);
        frame.setVisible(true);
    }

    /**
     * Paint the frame.
     *
     * @param goon The graphics object.
     */
    @Override
    public void paintComponent(Graphics goon) {
        goon.setColor(Color.BLUE);
        goon.fillRect(0, 0, getWidth(), getWidth());

        Snowflake[] snowflakes = new Snowflake[100];
        for (int i = 0; i < snowflakes.length; i++) {
            snowflakes[i] = new Snowflake(random.nextInt(getWidth()), random.nextInt(getHeight()));
        }
        for (Snowflake s : snowflakes) {
            s.draw(goon);
        }
    }

}
