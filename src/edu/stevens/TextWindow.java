<<<<<<< HEAD
package TextWindow; // Student Name - Chintan Patel

import javax.swing.*; 
import java.awt.*;
=======
package TextWindow;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout; // added code
import java.awt.Component; // added code
>>>>>>> eedb50f9ec7f496564c438aaa856377349cbbdce

public class TextWindow {

public static void main(String[] args) {

    JFrame frame = new JFrame("XFrame");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
<<<<<<< HEAD
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
=======
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
>>>>>>> eedb50f9ec7f496564c438aaa856377349cbbdce
