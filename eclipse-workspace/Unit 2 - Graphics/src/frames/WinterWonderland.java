// Yogesh Thambidurai ITCS

package frames;

import objects.*;

import java.util.ArrayList;
import java.util.Arrays;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import org.apache.batik.swing.JSVGCanvas;

public class WinterWonderland extends JPanel {

    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    @Override
    public void paintComponent(Graphics goon) {

        drawRick(goon, 100, 100);
    }

    /*
     * Draw an image of Rick Astley at x and y
     * 
     * @param x - The x coordinate of the image
     * 
     * @param y - The y coordinate of the image
     */
    private void drawRick(Graphics goon, int x, int y) {
        try {
            goon.drawImage(ImageIO.read(new File(
                    "eclipse-workspace\\Unit 2 - Graphics\\assets\\rick.png")), x,
                    y, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
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