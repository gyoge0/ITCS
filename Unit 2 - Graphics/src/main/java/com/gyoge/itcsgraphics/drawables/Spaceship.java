package com.gyoge.itcsgraphics.drawables;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

/**
 * Spaceship
 * <p>
 * A spaceship with a rock in it.
 *
 * @author Yogesh Thambidurai
 * @see com.gyoge.itcsgraphics.animators.SpaceshipAnimator
 */
public class Spaceship implements Drawable {

    private double x = 0;
    private double y = 0;

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

    public void draw(Graphics goon) {
        int intX = (int) x;
        int intY = (int) y;
        goon.setColor(new Color(186, 181, 169));
        goon.fillRect(intX, intY, 50, 100);

        // fill triangle
        goon.setColor(new Color(255, 255, 255));
        goon.fillPolygon(
            new int[]{intX, intX + 25, intX + 50},
            new int[]{intY, intY - 50, intY},
            3
        );

        goon.drawImage(
            new ImageIcon("src/main/resources/images/rock.jpg").getImage(),
            intX + 5,
            intY + 5,
            40,
            40,
            null
        );


    }

}
