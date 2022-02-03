package com.gyoge.itcsgraphics.drawables;

import java.awt.*;

/**
 * Class that draws an imposter from Among Us.
 */
public class Imposter implements Drawable {

    private int intX;
    private int intY;
    private double x;
    private double y;

    /**
     * Constructor.
     *
     * @param x The x coordinate of the imposter (approximately the top left corner).
     * @param y The y coordinate of the imposter (approximately the top left corner).
     */
    public Imposter(double x, double y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }

    /**
     * Draws most of the outline of the imposter.
     *
     * @param goon The graphics object.
     */
    private void drawOutline(Graphics goon) {
        goon.setColor(new Color(0, 0, 0));
        // Body
        goon.fillRoundRect(intX - 5, intY - 5, 60, 90, 60, 60);
        // Feet
        goon.fillRoundRect(intX - 5, intY + 40, 30, 65, 30, 30);
        goon.fillRoundRect(intX + 25, intY + 40, 30, 65, 30, 30);
    }

    /**
     * Draws the darker body of the imposter.
     *
     * @param goon The graphics object.
     */
    private void drawBody(Graphics goon) {
        goon.setColor(new Color(122, 2, 55));
        goon.fillRoundRect(intX, intY, 51, 80, 51, 50);
    }

    /**
     * Draws the lighter body of the imposter.
     *
     * @param goon The graphics object.
     */
    private void drawLit(Graphics goon) {
        goon.setColor(new Color(199, 11, 0));
        for (int i = 0; i < 8; i++) {
            goon.fillRoundRect(intX + 11 + i, intY + (i / 3), 30, 60, 30, 30);
        }
        for (int i = 0; i < 4; i++) {
            goon.fillRoundRect(intX + 18 + i, intY + 5 + (i / 2), 30, 60, 30, 30);
        }
    }

    /**
     * Draws the feet/legs of the imposter.
     *
     * @param goon The graphics object.
     */
    private void drawFeet(Graphics goon) {
        goon.setColor(new Color(122, 2, 55));

        goon.fillRoundRect(intX, intY + 40, 20, 60, 20, 20);
        goon.fillRoundRect(intX + 31, intY + 40, 20, 60, 20, 20);
    }

    /**
     * Draws the "backpack" of the imposter. Draws its own outline.
     *
     * @param goon The graphics object.
     */
    private void drawBackpack(Graphics goon) {
        // This needs to go under the other outlines, so I'm just going to draw it here.
        goon.setColor(new Color(0, 0, 0));
        goon.fillRoundRect(intX - 20, intY + 15, 50, 60, 50, 30);

        goon.setColor(new Color(122, 2, 55));
        goon.fillRoundRect(intX - 15, intY + 20, 40, 50, 40, 20);
    }

    /**
     * Draws the "visor" of the imposter. Draws its own outline.
     *
     * @param goon The graphics object.
     */
    private void drawVisor(Graphics goon) {
        // This needs to go over the other outlines, so I'm just going to draw it here.
        goon.setColor(new Color(0, 0, 0));
        goon.fillRoundRect(intX + 20, intY + 5, 45, 32, 45, 25);

        goon.setColor(new Color(143, 201, 220));
        goon.fillRoundRect(intX + 25, intY + 8, 35, 24, 35, 17);
    }

    /**
     * Draws the imposter.
     *
     * @param goon The graphics object.
     */
    public void draw(Graphics goon) {
        this.intX = (int) this.x;
        this.intY = (int) this.y;
        this.drawBackpack(goon);
        this.drawOutline(goon);
        this.drawBody(goon);
        this.drawFeet(goon);
        this.drawLit(goon);
        this.drawVisor(goon);
    }

}
