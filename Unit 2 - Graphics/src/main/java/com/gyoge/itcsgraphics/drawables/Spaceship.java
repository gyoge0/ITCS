package com.gyoge.itcsgraphics.drawables;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Spaceship implements Drawable {

    private int x = 0;
    private int y = 0;
    public static int UPPER_BOUND = -5;


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics goon) {
        goon.setColor(new Color(186, 181, 169));
        goon.fillRect(x, y, 50, 100);

        // fill triangle
        goon.setColor(new Color(255, 255, 255));
        goon.fillPolygon(new int[]{x, x + 25, x + 50}, new int[]{y, y - 50, y}, 3);

        goon.drawImage(
            new ImageIcon("src/main/resources/images/rock.jpg").getImage(),
            x + 5,
            y+5,
            40,
            40,
            null
        );


    }

}
