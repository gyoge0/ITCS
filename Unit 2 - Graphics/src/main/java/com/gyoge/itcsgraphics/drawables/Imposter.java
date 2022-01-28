package com.gyoge.itcsgraphics.drawables;

import java.awt.*;

/**
 * Class that draws an imposter from Among Us.
 */
public class Imposter implements Drawable {

    private int x;
    private int y;

    /**
     * Constructor.
     *
     * @param x The x coordinate of the imposter (approximately the top left corner).
     * @param y The y coordinate of the imposter (approximately the top left corner).
     */
    public Imposter(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
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
        goon.fillRoundRect(x - 5, y - 5, 60, 90, 60, 60);
        // Feet
        goon.fillRoundRect(x - 5, y + 40, 30, 65, 30, 30);
        goon.fillRoundRect(x + 25, y + 40, 30, 65, 30, 30);
    }

    /**
     * Draws the darker body of the imposter.
     *
     * @param goon The graphics object.
     */
    private void drawBody(Graphics goon) {
        goon.setColor(new Color(122, 2, 55));
        goon.fillRoundRect(x, y, 51, 80, 51, 50);
    }

    /**
     * Draws the lighter body of the imposter.
     *
     * @param goon The graphics object.
     */
    private void drawLit(Graphics goon) {
        goon.setColor(new Color(199, 11, 0));
        for (int i = 0; i < 8; i++) {
            goon.fillRoundRect(x + 11 + i, y + (i / 3), 30, 60, 30, 30);
        }
        for (int i = 0; i < 4; i++) {
            goon.fillRoundRect(x + 18 + i, y + 5 + (i / 2), 30, 60, 30, 30);
        }
    }

    /**
     * Draws the feet/legs of the imposter.
     *
     * @param goon The graphics object.
     */
    private void drawFeet(Graphics goon) {
        goon.setColor(new Color(122, 2, 55));

        goon.fillRoundRect(x, y + 40, 20, 60, 20, 20);
        goon.fillRoundRect(x + 31, y + 40, 20, 60, 20, 20);
    }

    /**
     * Draws the "backpack" of the imposter. Draws its own outline.
     *
     * @param goon The graphics object.
     */
    private void drawBackpack(Graphics goon) {
        // This needs to go under the other outlines, so I'm just going to draw it here.
        goon.setColor(new Color(0, 0, 0));
        goon.fillRoundRect(x - 20, y + 15, 50, 60, 50, 30);

        goon.setColor(new Color(122, 2, 55));
        goon.fillRoundRect(x - 15, y + 20, 40, 50, 40, 20);
    }

    /**
     * Draws the "visor" of the imposter. Draws its own outline.
     *
     * @param goon The graphics object.
     */
    private void drawVisor(Graphics goon) {
        // This needs to go over the other outlines, so I'm just going to draw it here.
        goon.setColor(new Color(0, 0, 0));
        goon.fillRoundRect(x + 20, y + 5, 45, 32, 45, 25);

        goon.setColor(new Color(143, 201, 220));
        goon.fillRoundRect(x + 25, y + 8, 35, 24, 35, 17);
    }

    /**
     * Draws the imposter.
     *
     * @param goon The graphics object.
     */
    public void draw(Graphics goon) {
        this.drawBackpack(goon);
        this.drawOutline(goon);
        this.drawBody(goon);
        this.drawFeet(goon);
        this.drawLit(goon);
        this.drawVisor(goon);
    }

}
