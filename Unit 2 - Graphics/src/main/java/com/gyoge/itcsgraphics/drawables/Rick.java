package com.gyoge.itcsgraphics.drawables;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Draw an image of Rick Astley.
 *
 * @author Yogesh Thambidurai
 * @see Drawable
 */
public class Rick implements Drawable {

    private int intX;
    private int intY;
    private double x;
    private double y;

    /**
     * Constructor.
     *
     * @param x Rick's x position (Approximately the top left corner of the image)
     * @param y Rick's y position (approximately the top left corner of the image)
     */
    public Rick(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }


    /**
     * Draws the legs of Rick.
     *
     * @param goon The graphics object.
     */
    private void drawLegs(Graphics goon) {
        // Pant color
        goon.setColor(new Color(115, 119, 127));

        // Hip
        goon.fillRect(this.intX - 30, this.intY + 160, 60, 20);

        // Left Leg
        goon.fillRect(this.intX - 30, this.intY + 180, 28, 75);

        // Right Leg
        goon.fillRect(this.intX + 2, this.intY + 180, 28, 75);
    }

    /**
     * Draws the feet of Rick.
     *
     * @param goon The graphics object.
     */
    public void drawFeet(Graphics goon) {
        // Foot color
        goon.setColor(new Color(45, 44, 39));

        // smaller and smaller rects?
        for (int i = 0; i < 5; i++) {
            goon.fillRect(this.intX - 31 - i, this.intY + 255 + i, 29, 21 - i);
            goon.fillRect(this.intX + 2 + i, this.intY + 255 + i, 29, 21 - i);
        }
    }

    /**
     * Draws the left arm of Rick.
     *
     * @param goon The graphics object.
     */
    private void drawLeftArm(Graphics goon) {
        // Upper Left Arm
        goon.setColor(new Color(29, 29, 29));
        for (int i = 0; i < 10; i++) {
            goon.fillOval(this.intX - (32 + i), this.intY + (82 + (i * 4)), 16, 16);
        }

        // Lower Left Arm
        for (int i = 0; i < 19; i++) {
            goon.fillOval(this.intX - (32 - i), this.intY + 120, 16, 16);
        }

        // Left Hand
        goon.setColor(new Color(246, 175, 147));
        goon.fillOval(this.intX - 12, this.intY + 120, 16, 16);
    }

    /**
     * Draws the right arm of Rick.
     *
     * @param goon The graphics object.
     */
    private void drawRightArm(Graphics goon) {
        // Upper Right Arm
        goon.setColor(new Color(29, 29, 29));
        for (int i = 0; i < 14; i++) {
            goon.fillOval(this.intX + 16 + i, this.intY + 80 + (i * 2), 16, 16);
        }

        // Lower Right Arm
        for (int i = 0; i < 14; i++) {
            goon.fillOval(this.intX + 30 - i, this.intY + 108 - i / 2, 16, 16);
        }

        // Right Hand
        goon.setColor(new Color(246, 175, 147));
        goon.fillOval(this.intX + 17, this.intY + 102, 16, 16);
    }

    /**
     * Draw's the microphone.
     *
     * @param goon The graphics object.
     */
    private void drawMic(Graphics goon) {
        goon.setColor(new Color(160, 160, 160));

        // Shiny Mic
        goon.fillRect(this.intX - 1, this.intY + 80, 10, 20);

        // Dull Mic/Stand
        goon.setColor(new Color(63, 62, 61));
        goon.fillRect(this.intX + 2, this.intY + 100, 4, 176);
    }

    /**
     * Draws the face of Rick.
     *
     * @param goon The graphics object.
     */
    private void drawFace(Graphics goon) {
        // Neck
        goon.setColor(new Color(181, 135, 123));
        goon.fillOval(this.intX - 10, this.intY + 50, 20, 40);

        // Face
        goon.setColor(new Color(246, 175, 147));
        goon.fillOval(this.intX - 15, this.intY + 25, 30, 50);

        // Hair
        goon.setColor(new Color(226, 113, 57));
        goon.fillOval(this.intX - 15, this.intY + 25, 30, 10);
    }

    /**
     * Draws the body of Rick.
     *
     * @param goon The graphics object.
     */
    private void drawBody(Graphics goon) {
        // Body
        goon.setColor(new Color(0, 1, 2));
        goon.fillRoundRect(this.intX - 30, this.intY + 80, 60, 85, 60, 15);
    }

    @Override
    public void draw(Graphics goon) {
        this.intX = (int) this.x;
        this.intY = (int) this.y;
        this.drawLegs(goon);
        this.drawFeet(goon);
        this.drawFace(goon);
        this.drawBody(goon);
        this.drawLeftArm(goon);
        this.drawRightArm(goon);
        this.drawMic(goon);
    }

}
