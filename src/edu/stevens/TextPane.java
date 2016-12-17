package home1;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestPane extends JPanel {

    public TestPane() {
        setLayout(new GridBagLayout());
        JLabel label = new JLabel("Hello");
        label.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(label, gbc);
        //checking the font names.
        String fonts[]
                = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (int i = 0; i < fonts.length; i++) {
            System.out.println(fonts[i]);
        }
       
        label = new JLabel("Hello");
        // set different font 
        label.setFont(new Font("Calibri", Font.PLAIN, 24));
        add(label, gbc);

        label = new JLabel("Hello");
        Font font = label.getFont();
        label.setFont(font.deriveFont(Font.PLAIN, 24f));
        add(label, gbc);
        label = new JLabel("Hello");
        Font font1 = label.getFont();
        label.setFont(font1.deriveFont(Font.ITALIC,24f));
        add(label, gbc);
        setVisible(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }
public static void main(String[] arg){
	TestPane t= new TestPane();
}
}
