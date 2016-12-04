/*
	Author - Chintan Patel
	TextWrapping code.
*/

package WordWrap;  // Package name

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import java.awt.*;

public class WordWrap extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;   //   Auto-Generated

	public WordWrap() {
        initializeUI();
    }

    private void initializeUI() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(400, 200));

        JTextArea textArea = new JTextArea(600, 600);
        
        textArea.setMargin( new Insets(50,50,50,50) );   // Insets will make gaps between text window and outer window. Top, Right, Down, Left

        textArea.setOpaque(true);      // Opacity is set True. So we can see the 
        textArea.setBackground(Color.white);
        textArea.setBorder(
            BorderFactory.createTitledBorder("Type Below"));
        JTextField tfield1 = new JTextField(100);   
        tfield1.setBorder(
            BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.black, Color.red), "JTextField"));
                
        String text = "I believe that we are who we choose to be. Nobody’s going to come and save you, you’ve got to save yourself. Nobody’s going to give you anything. You’ve got to go out and fight for it. Nobody knows what you want except for you. And nobody will be as sorry as you if you don’t get it. So don’t give up on your dreams.";
        
        textArea.setText(text);
        textArea.setFont(new Font("Calibri", Font.ITALIC, 18));
       
        textArea.setLineWrap(true);      
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea); //  Take out this code if it is already in the Application.

        this.add(scrollPane, BorderLayout.CENTER); //  Take out this code if it is already in the Application.
    }

    public static void showFrame() {
        JPanel panel = new WordWrap();
        panel.setOpaque(true);

        JFrame frame = new JFrame("JTextArea Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WordWrap.showFrame();
            }
        });
    }  
}  
