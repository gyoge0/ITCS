package objects;

import java.awt.*;

public class Rick {

    public void draw(Graphics goon, int x, int y) {

        // Neck
        goon.setColor(new Color(181, 135, 123));
        goon.fillOval(x - 10, y + 50, 20, 40);

        // Face
        goon.setColor(new Color(246, 175, 147));
        goon.fillOval(x - 15, y + 25, 30, 50);

        // Hair
        goon.setColor(new Color(226, 113, 57));
        goon.fillOval(x - 15, y + 25, 30, 10);

        // Body
        goon.setColor(new Color(0, 1, 2));
        goon.fillRoundRect(x - 30, y + 80, 60, 70, 60, 15);


        // Upper Left Arm
        goon.setColor(new Color(29, 29, 29));
        for (int i = 0; i < 10; i++) {
            goon.fillOval(x - (32 + i), y + (82 + (i * 4)), 16, 16);
        }

        // Lower Left Arm
        for (int i = 0; i < 19; i++) {
            goon.fillOval(x - (32 - i), y + (120 - i), 16, 16);
        }

        // Left Hand
        goon.setColor(new Color(246, 175, 147));
        goon.fillOval(x - 12, y + 100, 16, 16);

    }
}
