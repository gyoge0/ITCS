package com.gyoge.itcsgraphics.frames;

import java.awt.*;
import java.util.Random;
import javax.swing.*;
import com.gyoge.itcsgraphics.objects.Snowflake;

public class Snowflakes extends JPanel {

    private static final Random random = new Random();
    private static final int HEIGHT = 600;
    private static final int WIDTH = 600;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Goon presents: Snowflakes by Yogesh Thambidurai");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Snowflakes snowflakes = new Snowflakes();
        frame.setContentPane(snowflakes);
        frame.setVisible(true);
    }

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
