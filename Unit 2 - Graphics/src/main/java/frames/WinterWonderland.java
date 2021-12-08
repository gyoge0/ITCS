// Yogesh Thambidurai ITCS

package frames;

import java.awt.*;
import java.awt.geom.*;
import java.net.URL;
import java.util.Random;
import javax.sound.sampled.*;
import javax.swing.*;
import objects.Imposter;
import objects.Rick;

public class WinterWonderland extends JPanel {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    private static final Random random = new Random();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Goon presents: WinterWonderland by Yogesh Thambidurai");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(0, 0);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        WinterWonderland wonderLand = new WinterWonderland();
        frame.setContentPane(wonderLand);
        playRickRoll(wonderLand);
        frame.setVisible(true);

    }

    /**
     * Play a rickroll.
     *
     * @see <a href=https://stackoverflow.com/a/20514020>https://stackoverflow.com/a/20514020</a>
     */
    public static void playRickRoll(JPanel panel) {
        try {
            // Open an audio input stream.
            URL url = panel
                .getClass()
                .getClassLoader()
                .getResource("sounds/rickroll.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);

            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();

            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            // Something went wrong with playing the audio, just don't play it.
        }
    }

    /**
     * Draw a snowflake.
     *
     * @param goon   The graphics object.
     * @param x      The x coordinate of the snowflake.
     * @param y      The y coordinate of the snowflake.
     */
    private void drawSnow(Graphics goon, int x, int y) {

        // Does this count as 55 different colors?
        int color = random.nextInt(55) + 200;
        goon.setColor(new Color(color, color, color));

        goon.drawLine(x - 3, y, x + 3, y);
        goon.drawLine(x, y - 3, x, y + 3);
        goon.drawLine(x - 3, y - 3, x + 3, y + 3);
        goon.drawLine(x + 3, y - 3, x - 3, y + 3);

        goon.drawPolygon(new Polygon(
            new int[]{x - 2, x + 2, x, x, x - 2, x + 2, x - 2, x - 2},
            new int[]{y, y, y - 2, y + 2, y - 2, y + 2, y + 2, y - 2},
            8
        ));
    }

    /**
     * Set background to light blue and white.
     *
     * @param goon The graphics object
     */
    private void setBackground(Graphics goon) {
        // Background
        goon.setColor(new Color(45, 90, 167));
        goon.fillRect(0, 0, WIDTH, HEIGHT / 2);

        goon.setColor(Color.WHITE);
        goon.fillRect(0, HEIGHT / 2, WIDTH, HEIGHT / 2);
    }

    /**
     * Draw a String centered in the middle of a Rectangle with a background.
     *
     * @param goon      The Graphics instance.
     * @param text      The String to draw.
     * @param rect      The Rectangle to center the text in.
     * @param textColor The color of the text.
     * @param bgColor   The color of the background.
     * @see <a href=https://stackoverflow.com/a/27740330>https://stackoverflow.com/a/27740330</a>
     * @see <a href=https://stackoverflow.com/a/6416215>https://stackoverflow.com/a/6416215</a>
     */
    public void drawCenteredBackgroundedString(
        Graphics goon,
        String text,
        Rectangle rect,
        Font font,
        Color textColor,
        Color bgColor
    ) {
        // Get the FontMetrics
        FontMetrics metrics = goon.getFontMetrics(font);

        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();

        // Get the Rectangle for the background
        Rectangle2D bg = metrics.getStringBounds(text, goon);

        // Fill the background
        goon.setColor(bgColor);
        goon.fillRect(x, y - (int) bg.getHeight(), (int) bg.getWidth(), (int) bg.getHeight());

        // Set the color
        goon.setColor(textColor);
        // Set the font
        goon.setFont(font);
        // Draw the String
        goon.drawString(text, x, y);
    }


    /**
     * Paints the panel.
     *
     * @param goon The graphics object.
     */
    @Override
    public void paintComponent(Graphics goon) {
        this.setBackground(goon);

        // Snow
        for (int i = 0; i < 500; i++) {
            this.drawSnow(goon, random.nextInt(WIDTH), random.nextInt(HEIGHT / 2));
        }

        // Rick
        for (int i = 100; i < 1000; i += 100) {
            new Rick(i, 250).draw(goon);
        }

        for (int i = 0; i < WIDTH; i += 100) {
            new Imposter(
                i,
                random.nextInt(HEIGHT / 2 + 110) + (HEIGHT / 2) - 110
            ).draw(goon);
        }

        // Text
        this.drawCenteredBackgroundedString(
            goon,
            "We're no strangers to love",
            new Rectangle(0, HEIGHT / 2, WIDTH, HEIGHT / 2),
            new Font("Comic Sans Ms", Font.BOLD, 70),
            new Color(0, 0, 0),
            new Color(24, 158, 204)
        );

    }

}