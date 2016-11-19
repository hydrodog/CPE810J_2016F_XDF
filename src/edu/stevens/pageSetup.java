package edu.stevens.xpdf.xframe;
/*
@Author SihanWang
Create an interface that user can setup page style;
this class is to setup page in screen
Have 2 styles: 1: single page; 2: double page in hole screen
*/
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;


public class pageSetup extends JFrame {
	private Boolean b;
	private String t;
	public Container k;
	private final Border border = BorderFactory.createEmptyBorder(100, 100, 500, 100);
	public pageSetup() {
		super("PAGE SETUP");
		setSize(600, 600);
		Container ContentPane = getContentPane();
        setContentPane(ContentPane);
        setLocation(200, 50);  
      
        
        JLabel labelSinglePage = new JLabel();  
        JLabel labelDoublePage = new JLabel();  
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        labelSinglePage.setIcon(new ImageIcon("/image/SinglePage.jpg"));
        labelDoublePage.setIcon(new ImageIcon("/image/DoublePage.jpg"));

        // 把标签的大小位置设置为图片刚好填充整个面板  
        labelSinglePage.setBounds(0, 0, this.getWidth()/2, this.getHeight()/2);  
        labelDoublePage.setBounds(0, 0, this.getWidth()/2, this.getHeight()/2);  
	
        JPanel ContentPanelSingle = new JPanel(new GridBagLayout());
        ContentPanelSingle.setBorder(border);
        ContentPanelSingle.add(labelSinglePage);     
        
        JPanel ContentPanelDouble = new JPanel(new GridBagLayout());
        ContentPanelDouble.setBorder(border);
        ContentPanelDouble.add(labelDoublePage);
        
        JPanel ContentPanel = new JPanel();
        ContentPanel.setLayout(new GridLayout(1,2));
        ContentPanel.add(ContentPanelSingle);
        ContentPanel.add(ContentPanelDouble);
		
		JPanel ControlPanel = new JPanel();
		ControlPanel.setLayout(new GridLayout(1,2));
		JButton singlep = new JButton("singlePage");
		JButton doublep = new JButton("doublePage");
		ControlPanel.add(singlep);
		ControlPanel.add(doublep);
		ContentPane.add(ControlPanel, BorderLayout.SOUTH);
		ContentPane.add(ContentPanel, BorderLayout.NORTH);
		singlep.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
		//		pageSetupSingle(k, t) ;
			}
		});
		doublep.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
		//		pageSetupDouble(k, t) ;
			}
		});
		addWindowListener(new MyWindowListener());
		setVisible(true);
	}
	public static void main(String[] args) throws Exception{
		pageSetup p = new pageSetup();
	}
	
	//to setup single page in the panel can be linked
	//TODO:String t and it`s performed style should be provided by TEXTGruop
	//TODO:show whatever we got in the JPanel
/*	public void pageSetupSingle(Container c, String t){
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
*/
class MyWindowListener extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
}
