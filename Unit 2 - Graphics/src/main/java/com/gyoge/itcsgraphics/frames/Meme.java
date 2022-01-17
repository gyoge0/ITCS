package com.gyoge.itcsgraphics.frames;

import java.awt.*;
import java.awt.font.*;
import java.awt.image.*;
import javax.swing.*;

public class Meme extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;

    /** The buffered image to draw stuff onto. */
    private final BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT,
        BufferedImage.TYPE_INT_RGB);

    public static void main(String[] args) {
        JFrame frame = new JFrame("Goon presents: A Meme by Yogesh Thambidurai");
        frame.setSize(1000, 800);
        frame.setLocation(0, 0);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setContentPane(new Meme());
        frame.setVisible(true);
    }


    /**
     * The constructor to draw stuff onto the buffered image.
     */
    public Meme() {
        //retrieve the graphics object from the bufferedImage object
        Graphics goon = bufferedImage.getGraphics();

        //draw the background to fill the entire frame
        goon.setColor(Color.GRAY);
        goon.fillRect(0, 0, WIDTH, HEIGHT);

        goon.drawImage(new ImageIcon("src/main/resources/images/rock.jpg").getImage(), 0, 0, WIDTH,
            HEIGHT, null);

        drawCenteredOutlinedString(
            goon,
            "WHEN ITS ABOUT DRIVE",
            new Rectangle(0, 0, WIDTH, HEIGHT / 4),
            new Font("Impact", Font.BOLD, 75),
            Color.WHITE,
            Color.BLACK
        );
        drawCenteredOutlinedString(
            goon,
            "BOTTOM TEXT",
            new Rectangle(0, HEIGHT / 4 * 2, WIDTH, HEIGHT / 4),
            new Font("Impact", Font.BOLD, 75),
            Color.WHITE,
            Color.BLACK
        );

    }

    /**
     * Draw a String centered in the middle of a Rectangle.
     * <p>
     * Made using a bunch of stackoverflow/random website Graphics2D code.
     *
     * @param goon         The Graphics instance.
     * @param text         The String to draw.
     * @param rect         The Rectangle to center the text in.
     * @param textColor    The color of the text.
     * @param outlineColor The color of the outline.
     */
    public static void drawCenteredOutlinedString(
        Graphics goon,
        String text,
        Rectangle rect,
        Font font,
        Color textColor,
        Color outlineColor
    ) {
        Graphics2D g2d = (Graphics2D) goon;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        TextLayout tl = new TextLayout(text, font, g2d.getFontRenderContext());

        Shape shape = tl.getOutline(null);
        double shapeWidth = shape.getBounds().getWidth();
        double shapeHeight = shape.getBounds().getHeight();
        int x = (int) (rect.x + ((rect.width - shapeWidth) / 2));
        int y = (int) (rect.y + (((rect.height - shapeHeight) / 2) + tl.getAscent()));

        g2d.translate(x, y);

        g2d.setColor(outlineColor);
        g2d.draw(shape);
        g2d.setColor(textColor);
        g2d.fill(shape);
    }


    /**
     * Paint the frame.
     *
     * @param goon The graphics object.
     */
    @Override
    public void paintComponent(Graphics goon) {
        goon.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
    }
}
