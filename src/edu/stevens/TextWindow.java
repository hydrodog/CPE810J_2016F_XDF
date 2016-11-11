package TextWindow; // Student - Chintan Patel

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout; // added code
import java.awt.Component; // added code

public class TextWindow {

public static void main(String[] args) {

    JFrame frame = new JFrame("XFrame");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLocation(430, 100);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // added code

    frame.add(panel);

    String[] choices = { "CHOICE 1", "CHOICE 2", "CHOICE 3", "CHOICE 4",
                         "CHOICE 5", "CHOICE 6" };

    final JComboBox<String> cb = new JComboBox<String>(choices);

    cb.setMaximumSize(cb.getPreferredSize()); // added code
    cb.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
    //cb.setVisible(true); // Not needed
    panel.add(cb);

    JButton btn = new JButton("OK");
    btn.setAlignmentX(Component.CENTER_ALIGNMENT); // added code
    panel.add(btn);

    frame.setVisible(true); // added code

    }
}
