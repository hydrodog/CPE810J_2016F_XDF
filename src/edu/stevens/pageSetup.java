package edu.stevens;

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
	public Container k;
	private final Border border = BorderFactory.createEmptyBorder(100, 100, 500, 100);
	public pageSetup() {
		super("PAGE SETUP");
		setSize(600, 600);
		Container ContentPane = getContentPane();
        setContentPane(ContentPane);
        setLocation(200, 50);  
        b = true;
        JLabel labelSinglePage = new JLabel();  
        JLabel labelDoublePage = new JLabel();  
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        ImageIcon Icons = new ImageIcon(pageSetup.class.getResource("SinglePage.png"));
	    ImageIcon Icond = new ImageIcon(pageSetup.class.getResource("DoublePage.png"));
	    Icons.setImage(Icons.getImage().getScaledInstance(this.getWidth()/2,this.getHeight()/2,Image.SCALE_DEFAULT));
	    Icond.setImage(Icond.getImage().getScaledInstance(this.getWidth()/2,this.getHeight()/2,Image.SCALE_DEFAULT));
	    labelSinglePage.setIcon(Icons);
        labelDoublePage.setIcon(Icond);

        labelSinglePage.setBounds(0, 0, this.getWidth()/4, this.getHeight()/4);  
        labelDoublePage.setBounds(0, 0, this.getWidth()/4, this.getHeight()/4);  
	
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
		singlep.setPreferredSize(new Dimension(300,100));
		doublep.setPreferredSize(new Dimension(300,100));
		Font font = new Font("Default",Font.PLAIN,16);
		singlep.setFont(font);
		doublep.setFont(font);
		ControlPanel.add(singlep);
		ControlPanel.add(doublep);
		ContentPane.add(ControlPanel, BorderLayout.SOUTH);
		ContentPane.add(ContentPanel, BorderLayout.NORTH);
		singlep.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int choose=JOptionPane.showConfirmDialog(doublep,"Setup Page to SinglePage Style?","hint",JOptionPane.OK_CANCEL_OPTION);
				if(choose == JOptionPane.OK_OPTION){
					b = true;
					setVisible(false);
				}
			}
		});
		doublep.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int choose=JOptionPane.showConfirmDialog(doublep,"Setup Page to DoublePage Style? ","hint",JOptionPane.OK_CANCEL_OPTION);
				if(choose == JOptionPane.OK_OPTION){
					b = false;
					setVisible(false);
				}
			}
		});
		addWindowListener(new MyWindowListener());
		setVisible(true);
	}
	public boolean SingleOrNot(){
		return b;
	}
	
	class MyWindowListener extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			setDefaultCloseOperation(HIDE_ON_CLOSE);		
		}
	}
	
//	public static void main(String[] args) throws Exception{
//		pageSetup p = new pageSetup();
//	}
	
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

}
