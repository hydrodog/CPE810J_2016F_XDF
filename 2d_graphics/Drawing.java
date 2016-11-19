package test;
/*
 * @author:
 * Create a JFrame to display shapes.
 */
import javax.swing.*;

import org.apache.batik.swing.JSVGCanvas;

import java.awt.*;

public class Drawing extends JFrame{
	public Drawing(){
		super("SVG");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JPanel p1 = new JPanel();
		p1.setSize(800,800);
		c.add(p1, BorderLayout.CENTER);
		
		// Display the document.
		p1.add(new CompoundShape());
	    pack();
	    setVisible(true);
	}
	public static void main(String[] args){
		new Drawing();
	}

}
