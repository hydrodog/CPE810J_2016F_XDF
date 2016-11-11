package edu.stevens.xpdf.xframe;
/*
@Author SihanWang
Create a frame that user can setup page style;
Have 2 page styles: 1: single page; 2: double page in hole screen
*/
import java.awt.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class pageSetup extends JFrame {
	private Boolean b;
	private String t;
	public Container k;
	public pageSetup() {
		super("PAGE SETUP");
		setSize(100, 100);
		Container c = getContentPane();
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,2));
		JButton singlep = new JButton("singlePage");
		JButton doublep = new JButton("doublePage");
		p.add(singlep);
		p.add(doublep);
		c.add(p, BorderLayout.CENTER);
		singlep.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pageSetupSingle(k, t) ;
			}
		});
		doublep.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pageSetupDouble(k, t) ;
			}
		});
		addWindowListener(new MyWindowListener());
		setVisible(true);
	}
	public static void main(String[] args) throws Exception{
		
	}
	
	//to setup single page in the panel can be linked
	//TODO:String t and it`s performed style should be provided by TEXTGruop
	//TODO:show whatever we got in the JPanel
	public void pageSetupSingle(Container c, String t){
		JPanel firstPanel = new JPanel();
		firstPanel.add(t);//TODO
		c.add(firstPanel, BorderLayout.EAST);
	}
	
	//to setup double page in the panel can be linked
	//TODO:change size of what we got from TEXTGroup
	public void pageSetupDouble(Container c, String t){
		JPanel firstPanel = new JPanel();
		JPanel secondPanel = new JPanel();
		t.changeSize();
		firstPanel.add(t);//TODO
		c.add(firstPanel, BorderLayout.EAST);
		c.add(secondPanel, BorderLayout.EAST);
	}
	
	//TODO:change the text size, image size, space
	//public void changeTextSize(){
	//}
}
class MyWindowListener extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
