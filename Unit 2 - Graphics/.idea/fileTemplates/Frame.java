// Yogesh Thambidurai ITCS

package frames;

import java.awt.*;
import javax.swing.*;

public class ${NAME} extends JPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Goon presents: ${NAME} by Yogesh Thambidurai");
        frame.setSize(1000, 800);
        frame.setLocation(0, 0);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setContentPane(new ${NAME}());
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics goon) {

    }

}
