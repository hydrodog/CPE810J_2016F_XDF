package TextWindow; // Student Name - Chintan Patel

import javax.swing.*; 
import java.awt.*;

public class TextWindow {

public static void main(String[] args) {

    JFrame frame = new JFrame("XFrame");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1000, 1000);
    frame.setLocation(500, 200);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 

    frame.add(panel);

    String[] choices = { "Option 1", "Option 2", "Option 3", "Option 4",
                         "Option 5", "Option 6" };

    final JComboBox<String> cb = new JComboBox<String>(choices);

    cb.setMaximumSize(cb.getPreferredSize()); 
    cb.setAlignmentX(Component.CENTER_ALIGNMENT);
    cb.setVisible(true);
    panel.add(cb);

    JButton btn = new JButton("OK");
    btn.setAlignmentX(Component.CENTER_ALIGNMENT); 
    panel.add(btn);

    frame.setVisible(true); 
    }
}
