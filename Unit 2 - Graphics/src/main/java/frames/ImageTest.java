// Yogesh Thambidurai ITCS

package frames;

import java.awt.*;
import java.io.File;
import javax.imageio.*;
import javax.swing.*;

public class ImageTest extends JPanel {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Goon presents: ImageTest by Yogesh Thambidurai");
        frame.setSize(1000, 800);
        frame.setLocation(0, 0);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setContentPane(new ImageTest());
        frame.setVisible(true);
    }

    /**
     * Paints the panel.
     *
     * @param goon The graphics object.
     */
    @Override
    public void paintComponent(Graphics goon) {

        try {
            String filepath = "rock.jpg";
            this.add(new JLabel(new ImageIcon(ImageIO.read(new File(filepath)))));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
