
/**
 * @author: Lei Tang， Sihan Wang, Jingting Zhang
 * 
 * add Menu to realize basic functions CREATE, OPEN, SAVE, EXIT. 
 * add Button to realize the basic functions above. 
 * In addition, add undo, cut, paste, searchButton,replaceButton if time permits.
 *
 */



 package edu.stevens;
 import java.awt.*;
 import java.awt.event.*;
 import java.awt.datatransfer.*;
 import javax.swing.*;
 import javax.swing.undo.*;
 import javax.swing.event.*;
 import java.util.*;
 import java.io.*;
 
// import java.text.*;
// import javax.swing.border.*;
// import javax.swing.text.*;
 
 
 

//define the external features of XDF(window/frame/UI)
public class XFrame extends JFrame implements ActionListener,DocumentListener
{	//define menu bar
	JMenu fileMenu,editMenu,formatMenu,viewMenu,helpMenu,pageMenu,setMenu;
	//Right click item 
	JPopupMenu popupMenu;
	JMenuItem popupMenu_Undo,popupMenu_Cut,popupMenu_Copy,popupMenu_Paste,popupMenu_Delete,popupMenu_SelectAll;
	//items of FILE
	JMenuItem fileMenu_New,fileMenu_Open,fileMenu_Save,fileMenu_SaveAs,fileMenu_Print,fileMenu_Exit;
	//items of EDIT
	JMenuItem editMenu_Undo,editMenu_Cut,editMenu_Copy,editMenu_Paste,editMenu_Delete,editMenu_Find,editMenu_FindNext,editMenu_Replace,editMenu_GoTo,editMenu_SelectAll,editMenu_TimeDate;
	//items of FORMAT
	JCheckBoxMenuItem formatMenu_LineWrap;
	JMenuItem formatMenu_Font;
	//item of VIEW
	JCheckBoxMenuItem viewMenu_Status;
	//item of HELP
	JMenuItem helpMenu_HelpTopics,helpMenu_AboutXFrame;
	//item of SET	
	JMenuItem C1,C2,C3,C4,C5,C6,I1,I2,I3,I4,I5,I6;
	//item of PAGE
	JMenuItem pageMenu_pageSetUp;
	//text area
	JTextArea editArea, editArea1, editArea2;
	//JPanel to contain the textarea in double page option
	JPanel doublePanel;
	//Pane to contain the textarea in single page option
	JScrollPane singlePane;
	//status label
	JLabel statusLabel;
	//default Pagesetup
	public pageSetup PageSetup;
	//clipboard
	Toolkit toolkit=Toolkit.getDefaultToolkit();
	Clipboard clipBoard=toolkit.getSystemClipboard();
	//Create undo manager 
	protected UndoManager undo=new UndoManager();
	protected UndoableEditListener undoHandler=new UndoHandler();
	//other things
	String oldValue,oldValue1,oldValue2;//store the original content of the edit area for comparing text changes 
	boolean isNewFile=true;//Whether the new file (not saved) 
	File currentFile;//Current file name 
	//Constructor start 
	public XFrame()
	{	
		super("eXtreme Document Format");
		//Change system default font 
		Font font = new Font("Dialog", Font.PLAIN, 14);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		//Create menu bar 
		JMenuBar menuBar=new JMenuBar();
		//Create the file menu and menu items and register the event listener
		fileMenu=new JMenu("FILE");
		fileMenu.setMnemonic('F');//shortcut keys 

		fileMenu_New=new JMenuItem("NEW");
		fileMenu_New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		fileMenu_New.addActionListener(this);

		fileMenu_Open=new JMenuItem("OPEN");
		fileMenu_Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		fileMenu_Open.addActionListener(this);

		fileMenu_Save=new JMenuItem("SAVE");
		fileMenu_Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		fileMenu_Save.addActionListener(this);

		fileMenu_SaveAs=new JMenuItem("SAVE AS");
		fileMenu_SaveAs.addActionListener(this);
		

		fileMenu_Print=new JMenuItem("PRINT");
		fileMenu_Print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK)); 
		fileMenu_Print.addActionListener(this);

		fileMenu_Exit=new JMenuItem("EXIT");
		fileMenu_Exit.addActionListener(this);

		//Create Edit menu and menu item and register the event listener 
		editMenu=new JMenu("EDIT");
		editMenu.setMnemonic('E');//shortcut key
		
		//When selecting the edit menu, set the availability of cut, copy, paste, delete and other functions 
		editMenu.addMenuListener(new MenuListener()
		{	public void menuCanceled(MenuEvent e)//Call to cancel the menu 
			{	checkMenuItemEnabled();//Set the availability of cut, copy, paste, delete and other functions 
			}
			public void menuDeselected(MenuEvent e)//Call to cancel the selection of a menu
			{	checkMenuItemEnabled();//Set the availability of cut, copy, paste, delete and other functions 
			}
			public void menuSelected(MenuEvent e)//Call when selecting a menu 
			{	checkMenuItemEnabled();//Set the availability of cut, copy, paste, delete and other functions 
			}
		});

		editMenu_Undo=new JMenuItem("UNDO");
		editMenu_Undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));
		editMenu_Undo.addActionListener(this);
		editMenu_Undo.setEnabled(false);

		editMenu_Cut=new JMenuItem("CUT");
		editMenu_Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
		editMenu_Cut.addActionListener(this);

		editMenu_Copy=new JMenuItem("COPY");
		editMenu_Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		editMenu_Copy.addActionListener(this);

		editMenu_Paste=new JMenuItem("PASTE");
		editMenu_Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
		editMenu_Paste.addActionListener(this);

		editMenu_Delete=new JMenuItem("DELETE");
		editMenu_Delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));
		editMenu_Delete.addActionListener(this);

		editMenu_Find=new JMenuItem("FIND");
		editMenu_Find.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));
		editMenu_Find.addActionListener(this);

		editMenu_FindNext=new JMenuItem("FIND NEXT");
		editMenu_FindNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3,0));
		editMenu_FindNext.addActionListener(this);

		editMenu_Replace = new JMenuItem("REPLACE",'R'); 
		editMenu_Replace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK)); 
		editMenu_Replace.addActionListener(this);

		editMenu_GoTo = new JMenuItem("GOTO",'G'); 
		editMenu_GoTo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK)); 
		editMenu_GoTo.addActionListener(this);

		editMenu_SelectAll = new JMenuItem("SELECT ALL",'A'); 
		editMenu_SelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK)); 
		editMenu_SelectAll.addActionListener(this);

		editMenu_TimeDate = new JMenuItem("TIME/DATE",'D');
		editMenu_TimeDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5,0));
		editMenu_TimeDate.addActionListener(this);

		//Create the format menu and menu item and register the event listener
		formatMenu=new JMenu("FORMAT");
		formatMenu.setMnemonic('O');//shortcut key ALT+O

		formatMenu_LineWrap=new JCheckBoxMenuItem("LINE WRAP");
		formatMenu_LineWrap.setMnemonic('W');//shortcut key ALT+W
		formatMenu_LineWrap.setState(true);
		formatMenu_LineWrap.addActionListener(this);

		formatMenu_Font=new JMenuItem("FONT");
		formatMenu_Font.addActionListener(this);

		//Create the view menu and menu item and register the event listener
		viewMenu=new JMenu("VIEW");
		viewMenu.setMnemonic('V');//shortcut key ALT+V

		viewMenu_Status=new JCheckBoxMenuItem("STATUS");
		viewMenu_Status.setMnemonic('S');//shortcut key ALT+S
		viewMenu_Status.setState(true);
		viewMenu_Status.addActionListener(this);

		//Create a help menu and menu item and register the event listener 
		helpMenu = new JMenu("HELP");
		helpMenu.setMnemonic('H');//shortcut key ALT+H

		helpMenu_HelpTopics = new JMenuItem("HELP DETAILS"); 
		helpMenu_HelpTopics.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0));
		helpMenu_HelpTopics.addActionListener(this);

		helpMenu_AboutXFrame = new JMenuItem("ABOUT"); 
		helpMenu_AboutXFrame.addActionListener(this);
		

		/****************************************/
		//Create a set menu and menu item and register the event listener
		setMenu = new JMenu("SETTINGS");
		setMenu.setMnemonic('s');//shortcut key
		
		JMenu setMenu_Color = new JMenu("BGCOLOR");
		JMenu setMenu_Image = new JMenu("BGIMAGE");
		setMenu_Color.addActionListener(this);
		setMenu_Image.addActionListener(this);
		
		C1 = new JMenuItem("Candy Pink");
		C1.setBackground(Color.pink);
		C1.addActionListener(this);//Haven't finished yet,tbc
		C2 = new JMenuItem("Sunny Orange");
		C2.setBackground(Color.getHSBColor(200,155,64));
		C2.addActionListener(this);
		C3 = new JMenuItem("Lemon Yellow");
		C3.setBackground(Color.getHSBColor(244,121,131));
		C3.addActionListener(this);
		C4 = new JMenuItem("Grass Green");
		C4.setBackground(Color.getHSBColor(238,238,238));
		C4.addActionListener(this);
		C5 = new JMenuItem("Tambac Brown");
		C5.setBackground(Color.getHSBColor(243,249,241));
		C5.addActionListener(this);
		C6 = new JMenuItem("Silver Gary");
		C6.setBackground(Color.getHSBColor(202,86,99));
		C6.addActionListener(this);
		
		//Haven't finished yet,tbc
		I1 = new JMenuItem("Classic1",new ImageIcon("images/1.jpg"));
		I1.addActionListener(this);
		I2 = new JMenuItem("Classic2",new ImageIcon("images/2.jpg"));
		I2.addActionListener(this);
		I3 = new JMenuItem("Classic3",new ImageIcon("images/3.jpg"));
		I3.addActionListener(this);
		I4 = new JMenuItem("Classic4",new ImageIcon("images/4.jpg"));
		I4.addActionListener(this);
		I5 = new JMenuItem("Classic5",new ImageIcon("images/5.jpg"));
		I5.addActionListener(this);
		I6 = new JMenuItem("Classic6",new ImageIcon("images/6.jpg"));
		I6.addActionListener(this);	
		/*****************************************************/
		

		//Create a Page menu
		pageMenu =new JMenu("PAGE");
		pageMenu.setMnemonic('p');//shortcut key
		pageMenu_pageSetUp=new JMenuItem("PAGE SET");
		pageMenu_pageSetUp.addActionListener(this);


		//Add the "file" menu and menu item to the menu bar 
		menuBar.add(fileMenu); 
		fileMenu.add(fileMenu_New); 
		fileMenu.add(fileMenu_Open); 
		fileMenu.add(fileMenu_Save); 
		fileMenu.add(fileMenu_SaveAs); 
		fileMenu.addSeparator();		//gap line
		fileMenu.add(fileMenu_Print); 
		fileMenu.addSeparator();		//gap line
		fileMenu.add(fileMenu_Exit); 

		//Add the "edit" menu and menu item to the menu bar
		menuBar.add(editMenu); 
		editMenu.add(editMenu_Undo);  
		editMenu.addSeparator();		//gap line
		editMenu.add(editMenu_Cut); 
		editMenu.add(editMenu_Copy); 
		editMenu.add(editMenu_Paste); 
		editMenu.add(editMenu_Delete); 
		editMenu.addSeparator(); 		//gap line
		editMenu.add(editMenu_Find); 
		editMenu.add(editMenu_FindNext); 
		editMenu.add(editMenu_Replace);
		editMenu.add(editMenu_GoTo); 
		editMenu.addSeparator();  		//gap line
		editMenu.add(editMenu_SelectAll); 
		editMenu.add(editMenu_TimeDate);

		//Add the "format" menu and menu item to the menu bar		
		menuBar.add(formatMenu); 
		formatMenu.add(formatMenu_LineWrap); 
		formatMenu.add(formatMenu_Font);

		//Add the "view" menu and menu item to the menu bar
		menuBar.add(viewMenu); 
		viewMenu.add(viewMenu_Status);

		//Add the "page" menu and menu item to the menu bar
		menuBar.add(pageMenu); 
		pageMenu.add(pageMenu_pageSetUp); 
		
		/****************************************************/
		//Add the "set" menu and menu item to the menu bar
		menuBar.add(setMenu);
		setMenu_Color.add(C1);
		setMenu_Color.add(C2);
		setMenu_Color.add(C3);
		setMenu_Color.add(C4);
		setMenu_Color.add(C5);
		setMenu_Color.add(C6);
		setMenu_Image.add(I1);
		setMenu_Image.add(I2);
		setMenu_Image.add(I3);
		setMenu_Image.add(I4);
		setMenu_Image.add(I5);
		setMenu_Image.add(I6);
		
		setMenu.add(setMenu_Color);
		setMenu.addSeparator();
		setMenu.add(setMenu_Image);
		/***************************************/	
		//Add the "help" menu and menu item to the menu bar
		menuBar.add(helpMenu);
		helpMenu.add(helpMenu_HelpTopics);
		helpMenu.addSeparator();
		helpMenu.add(helpMenu_AboutXFrame);
		
			


		//Add menu bar to window 				
		this.setJMenuBar(menuBar);
		
		//set single pane to contain single page
		editArea=new JTextArea(20,50);
		singlePane=new JScrollPane(editArea);	
		singlePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(singlePane, BorderLayout.CENTER);
		editArea.setWrapStyleWord(true);//set linewrap
		editArea.setLineWrap(true);//true for wrap
		oldValue=editArea.getText();//get the contents of the original text editing area
	
		//set doublePanel to contain double Page
		editArea1=new JTextArea(20,25);
		JScrollPane scroller1=new JScrollPane(editArea1);	
		scroller1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		editArea1.setWrapStyleWord(true);//set linewrap
		editArea1.setLineWrap(true);//true for wrap
		oldValue1=editArea1.getText();//get the contents of the original text editing area
	
		editArea2=new JTextArea(20,25);
		JScrollPane scroller2=new JScrollPane(editArea2);	
		scroller2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		doublePanel = new JPanel();
		doublePanel.setLayout(new GridLayout(1,2));
		doublePanel.add(scroller1);
		doublePanel.add(scroller2);
		editArea2.setWrapStyleWord(true);//set linewrap
		editArea2.setLineWrap(true);//true for wrap
		oldValue2=editArea2.getText();//get the contents of the original text editing area

		//default pageSetup
		PageSetup = new pageSetup();
		PageSetup.setVisible(false);

		//Edit area registered event listener (related to undo operation) 
		editArea.getDocument().addUndoableEditListener(undoHandler);
		editArea.getDocument().addDocumentListener(this);

		//Right click to create a pop-up menu 
		popupMenu=new JPopupMenu();
		popupMenu_Undo=new JMenuItem("UNDO");
		popupMenu_Cut=new JMenuItem("CUT");
		popupMenu_Copy=new JMenuItem("COPY");
		popupMenu_Paste=new JMenuItem("PASTE");
		popupMenu_Delete=new JMenuItem("DELETE");
		popupMenu_SelectAll=new JMenuItem("SELECTALL");

		popupMenu_Undo.setEnabled(false);

		//Add menu item and separator to the right click menu. 
		popupMenu.add(popupMenu_Undo);
		popupMenu.addSeparator();
		popupMenu.add(popupMenu_Cut);
		popupMenu.add(popupMenu_Copy);
		popupMenu.add(popupMenu_Paste);
		popupMenu.add(popupMenu_Delete);
		popupMenu.addSeparator();
		popupMenu.add(popupMenu_SelectAll);

		//Text edit area register event 
		popupMenu_Undo.addActionListener(this);
		popupMenu_Cut.addActionListener(this);
		popupMenu_Copy.addActionListener(this);
		popupMenu_Paste.addActionListener(this);
		popupMenu_Delete.addActionListener(this);
		popupMenu_SelectAll.addActionListener(this);

		//Text edit area register event 
		editArea.addMouseListener(new MouseAdapter()
		{	public void mousePressed(MouseEvent e)
			{	if(e.isPopupTrigger())//Returns whether the mouse event is a trigger event for the platform's pop-up menu
				{	popupMenu.show(e.getComponent(),e.getX(),e.getY());//post the menu at the calling location 
				}
				checkMenuItemEnabled();//Set the availability of cut, copy, paste, delete and other functions 
				editArea.requestFocus();//Edit area get focus 
			}
			public void mouseReleased(MouseEvent e)
			{	if(e.isPopupTrigger())//Returns whether the mouse event is a trigger event for the platform's pop-up menu
				{	popupMenu.show(e.getComponent(),e.getX(),e.getY());//post the menu at the calling location 
				}
				checkMenuItemEnabled();//Set the availability of cut, copy, paste, delete and other functions 
				editArea.requestFocus();//Edit area get focus 
			}
		});//Text editing area registered&& right click menu event /end 

		//Create and add status bar 
		statusLabel=new JLabel("　Get help information pressing F1!");
		this.add(statusLabel,BorderLayout.SOUTH);//Add status bar tab to window 
		
		//Create and add Toolbar
		JToolBar jToolBar1 = new JToolBar();
	    JButton jButton1 = new JButton();
	    JButton jButton2 = new JButton();
		JButton jButton3 = new JButton();
		JButton jButton4 = new JButton();
		JButton jButton5 = new JButton();
		JButton jButton6 = new JButton();
		
		ImageIcon imageIcon1;
		ImageIcon imageIcon2;
		ImageIcon imageIcon3;
		ImageIcon imageIcon4;
		ImageIcon imageIcon5;
		ImageIcon imageIcon6;
		  
		
		this.add(jToolBar1, BorderLayout.NORTH);
		
		jToolBar1.add(jButton1, null);
	    jToolBar1.add(jButton2, null);
	    jToolBar1.add(jButton3, null);
	    jToolBar1.add(jButton4, null);
	    jToolBar1.add(jButton5, null);
	    jToolBar1.add(jButton6, null);
		
		imageIcon1 = new ImageIcon(XFrame.class.getResource("new.png"));
	    imageIcon2 = new ImageIcon(XFrame.class.getResource("open.png"));
	    imageIcon3 = new ImageIcon(XFrame.class.getResource("save.png"));
	    imageIcon4 = new ImageIcon(XFrame.class.getResource("saveAs.png"));
	    imageIcon5 = new ImageIcon(XFrame.class.getResource("undo.png"));
	    imageIcon6 = new ImageIcon(XFrame.class.getResource("SinglePage.png"));
	    imageIcon6.setImage(imageIcon6.getImage().getScaledInstance(imageIcon5.getImage().getWidth(jButton5),imageIcon5.getImage().getHeight(jButton5),Image.SCALE_DEFAULT));
	    
	    jButton1.setToolTipText("new file");
	    jButton1.setIcon(null);
	    jButton1.setSelectedIcon(null);
	    jButton1.setText("");
	    jButton1.addActionListener(new Button1_actionAdapter(this));
	    jButton2.setToolTipText("open file");
	    jButton2.setVerifyInputWhenFocusTarget(true);
	    jButton2.setText("");
	    jButton2.addActionListener(new Button2_actionAdapter(this));
	    jButton3.setToolTipText("save");
	    jButton3.setText("");
	    jButton3.addActionListener(new Button3_actionAdapter(this));
	    jButton4.setToolTipText("save as");
	    jButton4.setText("");
	    jButton4.addActionListener(new Button4_actionAdapter(this));
	    jButton5.setToolTipText("undo");
	    jButton5.setText("");
	    jButton5.addActionListener(new Button5_actionAdapter(this));
	    jButton6.setToolTipText("page set");
	    jButton6.setText("");
	    jButton6.addActionListener(new Button6_actionAdapter(this));
	    
	    jButton1.setIcon(imageIcon1);
	    jButton2.setIcon(imageIcon2);
	    jButton3.setIcon(imageIcon3);
	    jButton4.setIcon(imageIcon4);
	    jButton5.setIcon(imageIcon5);
	    jButton6.setIcon(imageIcon6);

		
		//Set the location, size, and visibility of the window on the screen. 
		this.setLocation(100,50);//window size
		this.setSize(1000,600);
		this.setVisible(true);
		
		//Add the listener window 
		addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{
				exitWindowChoose();
			}
		});
		
		//Add the mouselistener to change pageset
		this.addMouseListener(new MouseListener() {
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setpage();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		
		});
		
		checkMenuItemEnabled();
		editArea.requestFocus();
	
	}//end of constructor
	
class Button1_actionAdapter implements ActionListener {
	  XFrame adaptee;

	  Button1_actionAdapter(XFrame adaptee) {
	    this.adaptee = adaptee;
	  }

	  public void actionPerformed(ActionEvent e) {
	    adaptee.jButton1_actionPerformed(e);
	  }
	}

class Button2_actionAdapter implements ActionListener {
	  XFrame adaptee;

	  Button2_actionAdapter(XFrame adaptee) {
	    this.adaptee = adaptee;
	  }

	  public void actionPerformed(ActionEvent e) {
	    adaptee.jButton2_actionPerformed(e);
	  }
	}

class Button3_actionAdapter implements ActionListener {
	  XFrame adaptee;

	  Button3_actionAdapter(XFrame adaptee) {
	    this.adaptee = adaptee;
	  }

	  public void actionPerformed(ActionEvent e) {
	    adaptee.jButton3_actionPerformed(e);
	  }
	}

class Button4_actionAdapter implements ActionListener {
	  XFrame adaptee;

	  Button4_actionAdapter(XFrame adaptee) {
	    this.adaptee = adaptee;
	  }

	  public void actionPerformed(ActionEvent e) {
	    adaptee.jButton4_actionPerformed(e);
	  }
	}

class Button5_actionAdapter implements ActionListener {
	  XFrame adaptee;

	  Button5_actionAdapter(XFrame adaptee) {
	    this.adaptee = adaptee;
	  }

	  public void actionPerformed(ActionEvent e) {
	    adaptee.jButton5_actionPerformed(e);
	  }
	}

class Button6_actionAdapter implements ActionListener {
	  XFrame adaptee;

	  Button6_actionAdapter(XFrame adaptee) {
	    this.adaptee = adaptee;
	  }

	  public void actionPerformed(ActionEvent e) {
	    adaptee.jButton6_actionPerformed(e);
	  }
	}
	
	void jButton1_actionPerformed(ActionEvent e) {
	    newFile();
	  }

	void jButton2_actionPerformed(ActionEvent e) {
	    open();
	  }

	void jButton3_actionPerformed(ActionEvent e) {
	    save();
	  }

	void jButton4_actionPerformed(ActionEvent e) {
	    saveas();
	  }
	
	void jButton5_actionPerformed(ActionEvent e) {
	    undo();
	  }
		
	void jButton6_actionPerformed(ActionEvent e) {
	    pagesetup();
	  }
	
	//Set menu item availability: cut, copy, paste, delete function 
	public void checkMenuItemEnabled()
	{
		String selectText=editArea.getSelectedText();
		if(selectText==null)
		{	editMenu_Cut.setEnabled(false);
			popupMenu_Cut.setEnabled(false);
			editMenu_Copy.setEnabled(false);
			popupMenu_Copy.setEnabled(false);
			editMenu_Delete.setEnabled(false);
			popupMenu_Delete.setEnabled(false);
		}
		else
		{	editMenu_Cut.setEnabled(true);
			popupMenu_Cut.setEnabled(true); 
			editMenu_Copy.setEnabled(true);
			popupMenu_Copy.setEnabled(true);
			editMenu_Delete.setEnabled(true);
			popupMenu_Delete.setEnabled(true);
		}
		//paste function availability judgment 
		Transferable contents=clipBoard.getContents(this);
		if(contents==null)
		{	editMenu_Paste.setEnabled(false);
			popupMenu_Paste.setEnabled(false);
		}
		else
		{	editMenu_Paste.setEnabled(true);
			popupMenu_Paste.setEnabled(true);	
		}
	}

	//Call when closing the window
	public void exitWindowChoose()
	{
		editArea.requestFocus();
		String currentValue=editArea.getText();
		if(currentValue.equals(oldValue)==true)
		{	System.exit(0);
		}
		else
		{	int exitChoose=JOptionPane.showConfirmDialog(this,"Your file has not been saved. Do you want to save it? ","Exit Alert",JOptionPane.YES_NO_CANCEL_OPTION);
			if(exitChoose==JOptionPane.YES_OPTION)
			{	//boolean isSave=false;
				if(isNewFile)
				{	
					String str=null;
					JFileChooser fileChooser=new JFileChooser();
					fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					fileChooser.setApproveButtonText("Confirm");
					fileChooser.setDialogTitle("Save As");
					
					int result=fileChooser.showSaveDialog(this);
					
					if(result==JFileChooser.CANCEL_OPTION)
					{	statusLabel.setText("You did not save the file!");
						return;
					}					
	
					File saveFileName=fileChooser.getSelectedFile();
				
					if(saveFileName==null||saveFileName.getName().equals(""))
					{	JOptionPane.showMessageDialog(this,"Illegal file name!","Illegal file name!",JOptionPane.ERROR_MESSAGE);
					}
					else 
					{	try
						{	FileWriter fw=new FileWriter(saveFileName);
							BufferedWriter bfw=new BufferedWriter(fw);
							bfw.write(editArea.getText(),0,editArea.getText().length());
							bfw.flush();
							fw.close();
							
							isNewFile=false;
							currentFile=saveFileName;
							oldValue=editArea.getText();
							
							this.setTitle(saveFileName.getName()+"  - File");
							statusLabel.setText("Open current file"+saveFileName.getAbsoluteFile());
							//isSave=true;
						}							
						catch(IOException ioException){					
						}				
					}
				}
				else
				{
					try
					{	FileWriter fw=new FileWriter(currentFile);
						BufferedWriter bfw=new BufferedWriter(fw);
						bfw.write(editArea.getText(),0,editArea.getText().length());
						bfw.flush();
						fw.close();
						//isSave=true;
					}							
					catch(IOException ioException){					
					}
				}
				System.exit(0);
				//if(isSave)System.exit(0);
				//else return;
			}
			else if(exitChoose==JOptionPane.NO_OPTION)
			{	System.exit(0);
			}
			else
			{	return;
			}
		}
	}

	//method of find word
	public void find(){}
	
	//method of replace word
	public void replace(){}

	//font method
	public void font(){}
	
	// The action of each button 
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==fileMenu_New)
		{	
			newFile();
		}
		
		else if(e.getSource()==fileMenu_Open)
		{	
			open();
		}
		
		else if(e.getSource()==fileMenu_Save)
		{	
			save();
		}
		
		else if(e.getSource()==fileMenu_SaveAs)
		{	
			saveas();
		}
		
		//page setup
		else if(e.getSource()==pageMenu_pageSetUp)
		{	editArea.requestFocus();
			pagesetup();
		}//finish page setup
		
		//print function begin
		else if(e.getSource()==fileMenu_Print)
		{	editArea.requestFocus();
			JOptionPane.showMessageDialog(this,"Sorry, this feature is not yet implemented! ","hint",JOptionPane.WARNING_MESSAGE);
		}//finish print function
		
		//exit function begin
		else if(e.getSource()==fileMenu_Exit)
		{	int exitChoose=JOptionPane.showConfirmDialog(this,"Are you sure? ( shuts down )","exit alert",JOptionPane.OK_CANCEL_OPTION);
			if(exitChoose==JOptionPane.OK_OPTION)
			{	System.exit(0);
			}
			else
			{	return;
			}
		}//finish exit function
		
		//undo function begin
		else if(e.getSource()==editMenu_Undo || e.getSource()==popupMenu_Undo)
		{	
		undo();
		}//finish undo function
		
		//cut function
		else if(e.getSource()==editMenu_Cut || e.getSource()==popupMenu_Cut)
		{	editArea.requestFocus();
			String text=editArea.getSelectedText();
			StringSelection selection=new StringSelection(text);
			clipBoard.setContents(selection,null);
			editArea.replaceRange("",editArea.getSelectionStart(),editArea.getSelectionEnd());
			checkMenuItemEnabled();//Set the availability of cut, copy, paste, and delete functions. 
		}//finish cut function				
				
		//copy function begin
				else if(e.getSource()==editMenu_Copy || e.getSource()==popupMenu_Copy)
				{	editArea.requestFocus();
					String text=editArea.getSelectedText();
					StringSelection selection=new StringSelection(text);
					clipBoard.setContents(selection,null);
					checkMenuItemEnabled();//Set the availability of cut, copy, paste, and delete functions. 
				}//finish copy function
		
				//paste function begin
				else if(e.getSource()==editMenu_Paste || e.getSource()==popupMenu_Paste)
				{	editArea.requestFocus();
					Transferable contents=clipBoard.getContents(this);
					if(contents==null)return;
					String text="";
					try
					{	text=(String)contents.getTransferData(DataFlavor.stringFlavor);
					}
					catch (Exception exception)
					{
					}
					editArea.replaceRange(text,editArea.getSelectionStart(),editArea.getSelectionEnd());
					checkMenuItemEnabled();
				}//finish paste function
		
				//delete function begin 
				else if(e.getSource()==editMenu_Delete || e.getSource()==popupMenu_Delete)
				{	editArea.requestFocus();
					editArea.replaceRange("",editArea.getSelectionStart(),editArea.getSelectionEnd());
					checkMenuItemEnabled();	//Set the availability of cut, copy, paste, and delete functions. 
				}//finish delete function
		
				//find function
				else if(e.getSource()==editMenu_Find)
				{	editArea.requestFocus();
					find();
				}//finish find function
		
				//findnext function
				else if(e.getSource()==editMenu_FindNext)
				{	editArea.requestFocus();
					find();
				}//finish findnext function
		
				//replace function
				else if(e.getSource()==editMenu_Replace)
				{	editArea.requestFocus();
					replace();
				}//finish replace function
		
				//goto function
				else if(e.getSource()==editMenu_GoTo)
				{	editArea.requestFocus();
					JOptionPane.showMessageDialog(this,"Sorry, this feature is not yet implemented! ","hint",JOptionPane.WARNING_MESSAGE);
				}//not implemented
		
				//time and date
				else if(e.getSource()==editMenu_TimeDate)
				{	editArea.requestFocus();
					//SimpleDateFormat currentDateTime=new SimpleDateFormat("HH:mmyyyy-MM-dd");
					//editArea.insert(currentDateTime.format(new Date()),editArea.getCaretPosition());
					Calendar rightNow=Calendar.getInstance();
					Date date=rightNow.getTime();
					editArea.insert(date.toString(),editArea.getCaretPosition());
				}//finish timedate
		
				//select all function
				else if(e.getSource()==editMenu_SelectAll || e.getSource()==popupMenu_SelectAll)
				{	editArea.selectAll();
				}//finish select all function
		
				//word Wrap (have set)
				else if(e.getSource()==formatMenu_LineWrap)
				{	if(formatMenu_LineWrap.getState())
						editArea.setLineWrap(true);
					else 
						editArea.setLineWrap(false);

				}
				//font set
				else if(e.getSource()==formatMenu_Font)
				{	editArea.requestFocus();
					font();
				}//finish font set
		
				//Set status bar visibility 
				else if(e.getSource()==viewMenu_Status)
				{	if(viewMenu_Status.getState())
						statusLabel.setVisible(true);
					else 
						statusLabel.setVisible(false);
				}//Set status bar visibility 
				
				//help menu
				else if(e.getSource()==helpMenu_HelpTopics)
				{	editArea.requestFocus();
					JOptionPane.showMessageDialog(this,"If you like something, say something!","help menu",JOptionPane.INFORMATION_MESSAGE);
				}
				//about
				else if(e.getSource()==helpMenu_AboutXFrame)
				{	editArea.requestFocus();
					JOptionPane.showMessageDialog(this,
						"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n"+
						" Author: XFrame team "+
						" Version: 1.0                          \n"+
						" Release time: 2016 fall                            \n"+
						" Description: basic functions and framework                \n"+
						" Development cycle : one month \n"+
						"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n",
						"XDF",JOptionPane.INFORMATION_MESSAGE);
				}
		

	}
	//newFile function begin
	public void newFile()
	{
		editArea.requestFocus();
		String currentValue=editArea.getText();
		boolean isTextChange=(currentValue.equals(oldValue))?false:true;
		if(isTextChange)
		{	int saveChoose=JOptionPane.showConfirmDialog(this,"Your file has not been saved. Do you want to save it? ","hint",JOptionPane.YES_NO_CANCEL_OPTION);
			if(saveChoose==JOptionPane.YES_OPTION)
			{	String str=null;
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
				fileChooser.setDialogTitle("save as");
				int result=fileChooser.showSaveDialog(this);
				if(result==JFileChooser.CANCEL_OPTION)
				{	statusLabel.setText("select no file");
					return;
				}
				File saveFileName=fileChooser.getSelectedFile();
				if(saveFileName==null || saveFileName.getName().equals(""))
				{	JOptionPane.showMessageDialog(this,"Illegal file name","Illegal file name",JOptionPane.ERROR_MESSAGE);
				}
				else 
				{	try
					{	FileWriter fw=new FileWriter(saveFileName);
						BufferedWriter bfw=new BufferedWriter(fw);
						bfw.write(editArea.getText(),0,editArea.getText().length());
						bfw.flush();//flushing the buffer
						bfw.close();
						isNewFile=false;
						currentFile=saveFileName;
						oldValue=editArea.getText();
						this.setTitle(saveFileName.getName()+" - XDF");
						statusLabel.setText("Current opened file："+saveFileName.getAbsoluteFile());
					}
					catch (IOException ioException)
					{
					}
				}
			}
			else if(saveChoose==JOptionPane.NO_OPTION)
			{	editArea.replaceRange("",0,editArea.getText().length());
				statusLabel.setText(" create new file");
				this.setTitle("no title - XDF");
				isNewFile=true;
				undo.discardAllEdits();	//discard all Undo operate
				editMenu_Undo.setEnabled(false);
				oldValue=editArea.getText();
			}
			else if(saveChoose==JOptionPane.CANCEL_OPTION)
			{	return;
			}
		}
		else
		{	editArea.replaceRange("",0,editArea.getText().length());
			statusLabel.setText(" create new file");
			this.setTitle("no title - XDF");
			isNewFile=true;
			undo.discardAllEdits();//discard all Undo operate
			editMenu_Undo.setEnabled(false);
			oldValue=editArea.getText();
		}
	}//finish new function
	

	//Open function
	public void open()
	{
		editArea.requestFocus();
		String currentValue=editArea.getText();
		boolean isTextChange=(currentValue.equals(oldValue))?false:true;
		if(isTextChange)
		{	int saveChoose=JOptionPane.showConfirmDialog(this,"Your file has not been saved. Do you want to save it? ","hint",JOptionPane.YES_NO_CANCEL_OPTION);
			if(saveChoose==JOptionPane.YES_OPTION)
			{	String str=null;
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				fileChooser.setDialogTitle("save as");
				int result=fileChooser.showSaveDialog(this);
				if(result==JFileChooser.CANCEL_OPTION)
				{	statusLabel.setText("select no file");
					return;
				}
				File saveFileName=fileChooser.getSelectedFile();
				if(saveFileName==null || saveFileName.getName().equals(""))
				{	JOptionPane.showMessageDialog(this,"Illegal file name","Illegal file name",JOptionPane.ERROR_MESSAGE);
				}
				else 
				{	try
					{	FileWriter fw=new FileWriter(saveFileName);
						BufferedWriter bfw=new BufferedWriter(fw);
						bfw.write(editArea.getText(),0,editArea.getText().length());
						bfw.flush();//flushing the buffer
						bfw.close();
						isNewFile=false;
						currentFile=saveFileName;
						oldValue=editArea.getText();
						this.setTitle(saveFileName.getName()+" - XDF");
						statusLabel.setText("Current opened file："+saveFileName.getAbsoluteFile());
					}
					catch (IOException ioException)
					{
					}
				}
			}
			else if(saveChoose==JOptionPane.NO_OPTION)
			{	String str=null;
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				fileChooser.setDialogTitle("Open file");
				int result=fileChooser.showOpenDialog(this);
				if(result==JFileChooser.CANCEL_OPTION)
				{	statusLabel.setText("select no file");
					return;
				}
				File fileName=fileChooser.getSelectedFile();
				if(fileName==null || fileName.getName().equals(""))
				{	JOptionPane.showMessageDialog(this,"Illegal file name","Illegal file name",JOptionPane.ERROR_MESSAGE);
				}
				else
				{	try
					{	FileReader fr=new FileReader(fileName);
						BufferedReader bfr=new BufferedReader(fr);
						editArea.setText("");
						while((str=bfr.readLine())!=null)
						{	editArea.append(str);
						}
						this.setTitle(fileName.getName()+" - XDF");
						statusLabel.setText(" Current opened file："+fileName.getAbsoluteFile());
						fr.close();
						isNewFile=false;
						currentFile=fileName;
						oldValue=editArea.getText();
					}
					catch (IOException ioException)
					{
					}
				}
			}
			else
			{	return;
			}
		}
		else
		{	String str=null;
			JFileChooser fileChooser=new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			fileChooser.setDialogTitle("Open file");
			int result=fileChooser.showOpenDialog(this);
			if(result==JFileChooser.CANCEL_OPTION)
			{	statusLabel.setText(" select no file ");
				return;
			}
			File fileName=fileChooser.getSelectedFile();
			if(fileName==null || fileName.getName().equals(""))
			{	JOptionPane.showMessageDialog(this,"Illegal file name","Illegal file name",JOptionPane.ERROR_MESSAGE);
			}
			else
			{	try
				{	FileReader fr=new FileReader(fileName);
					BufferedReader bfr=new BufferedReader(fr);
					editArea.setText("");
					while((str=bfr.readLine())!=null)
					{	editArea.append(str);
					}
					this.setTitle(fileName.getName()+" - XDF");
					statusLabel.setText(" Current opened file："+fileName.getAbsoluteFile());
					fr.close();
					isNewFile=false;
					currentFile=fileName;
					oldValue=editArea.getText();
				}
				catch (IOException ioException)
				{
				}
			}
		}
	}//finish open function
	//save function begin
	public void save()
	{
		editArea.requestFocus();
		if(isNewFile)
		{	String str=null;
			JFileChooser fileChooser=new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			fileChooser.setDialogTitle("save");
			int result=fileChooser.showSaveDialog(this);
			if(result==JFileChooser.CANCEL_OPTION)
			{	statusLabel.setText("select no file");
				return;
			}
			File saveFileName=fileChooser.getSelectedFile();
			if(saveFileName==null || saveFileName.getName().equals(""))
			{	JOptionPane.showMessageDialog(this,"Illegal file name","Illegal file name",JOptionPane.ERROR_MESSAGE);
			}
			else 
			{	try
				{	FileWriter fw=new FileWriter(saveFileName);
					BufferedWriter bfw=new BufferedWriter(fw);
					bfw.write(editArea.getText(),0,editArea.getText().length());
					bfw.flush();//flushing the buffer
					bfw.close();
					isNewFile=false;
					currentFile=saveFileName;
					oldValue=editArea.getText();
					this.setTitle(saveFileName.getName()+" - XDF");
					statusLabel.setText("Current opened file："+saveFileName.getAbsoluteFile());
				}
				catch (IOException ioException)
				{
				}
			}
		}
		else
		{	try
			{	FileWriter fw=new FileWriter(currentFile);
				BufferedWriter bfw=new BufferedWriter(fw);
				bfw.write(editArea.getText(),0,editArea.getText().length());
				bfw.flush();
				fw.close();
			}							
			catch(IOException ioException)
			{					
			}
		}
	}//finish the save function

	//save as function begin
	public void saveas()
	{
		editArea.requestFocus();
		String str=null;
		JFileChooser fileChooser=new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		fileChooser.setDialogTitle("save as");
		int result=fileChooser.showSaveDialog(this);
		if(result==JFileChooser.CANCEL_OPTION)
		{	statusLabel.setText("　select no file");
			return;
		}				
		File saveFileName=fileChooser.getSelectedFile();
		if(saveFileName==null||saveFileName.getName().equals(""))
		{	JOptionPane.showMessageDialog(this,"Illegal file name","Illegal file name",JOptionPane.ERROR_MESSAGE);
		}	
		else 
		{	try
			{	FileWriter fw=new FileWriter(saveFileName);
				BufferedWriter bfw=new BufferedWriter(fw);
				bfw.write(editArea.getText(),0,editArea.getText().length());
				bfw.flush();
				fw.close();
				oldValue=editArea.getText();
				this.setTitle(saveFileName.getName()+"  - XDF");
				statusLabel.setText("　Current opened file:"+saveFileName.getAbsoluteFile());
			}						
			catch(IOException ioException)
			{					
			}				
		}
	}//finish saveas function
	
	//when click the button call pagesetup frame
	public void pagesetup(){	
		oldValue = editArea.getText();
		oldValue1 = editArea1.getText();
		oldValue2 = editArea2.getText();
		PageSetup.setVisible(true);
		this.setpage();
	}
	
	//setup single page or double page of xpdf
	private boolean single = true;
	public void setpage(){
		if(PageSetup.SingleOrNot() == true && single==false){
			StringBuilder text = new StringBuilder();
			text.append(oldValue1);
			text.append("\r\n");
			text.append(oldValue2);
			if(oldValue1.equals("")&&oldValue2.equals("")){
				editArea.setText("");
			}else if(oldValue1.equals("")){
				editArea.setText(oldValue2);
			}else{
				editArea.setText(text.toString());
			}
			this.remove(doublePanel);
			this.add(singlePane, BorderLayout.CENTER);;
			this.validate();
			this.repaint();
			System.out.println("SinglePage");
			single=true;
		}else if(PageSetup.SingleOrNot() == false && single==true){
			if(oldValue.equals("")){
				editArea1.setText("");
				editArea2.setText("");
			}else{
				String []s = oldValue.split("\\r?\\n");
				if(s.length > 32){
					StringBuilder text1 = new StringBuilder();
					StringBuilder text2 = new StringBuilder();
					for(int i = 0; i < s.length/2;i++){
						text1.append(s[i]).append("\r\n");
						text2.append(s[i + s.length/2]).append("\r\n");
					}
					editArea1.setText(text1.toString());
					editArea2.setText(text2.toString());
				}else{
					StringBuilder text1 = new StringBuilder();
					for(int i = 0; i < s.length;i++){
						text1.append(s[i]).append("\r\n");
					}
					editArea1.setText(text1.toString());
					editArea2.setText("");
				}
			}
			this.remove(singlePane);
			this.add(doublePanel, BorderLayout.CENTER);
			this.validate();		
			this.repaint();
			System.out.println("DoublePage");
			single = false; 
		}
	}
	
	//undo function begin
	public void undo()
	{
		editArea.requestFocus();
		if(undo.canUndo())
		{	try
			{	undo.undo();
			}
			catch (CannotUndoException ex)
			{	System.out.println("Unable to undo:" + ex);
				//ex.printStackTrace();
			}
		}
		if(!undo.canUndo())
			{	editMenu_Undo.setEnabled(false);
			}
	}//undo function finished
	
	//Method to implement the "documentlistener" interface (related to undo operation) 
	public void removeUpdate(DocumentEvent e)
	{
		editMenu_Undo.setEnabled(true);
	}
	public void insertUpdate(DocumentEvent e)
	{
		editMenu_Undo.setEnabled(true);
	}
	public void changedUpdate(DocumentEvent e)
	{
		editMenu_Undo.setEnabled(true);
	}

	//Implementation of the interface undoableeditlistener class undohandler (related to undo operation)
	class UndoHandler implements UndoableEditListener
	{	public void undoableEditHappened(UndoableEditEvent uee)
	{
		undo.addEdit(uee.getEdit());
	}
	}

}
