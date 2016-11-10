/**
 * @author: Lei Tang
 * 
 * add Menu to realize basic functions CREATE, OPEN, SAVE, EXIT. 
 * add Button to realize the basic functions above. 
 * In addition, add undo, cut, paste, searchButton,replaceButton if time permits.
 *
 */



package edu.stevens;
 import java.awt.*;
 import java.awt.event.*;
 import java.text.*;
 import java.util.*;
 import java.io.*;
 import javax.swing.undo.*;
 import javax.swing.border.*;
 import javax.swing.*;
 import javax.swing.text.*;
 import javax.swing.event.*;
 import java.awt.datatransfer.*;

//define the external features of XDF(window/frame/UI)
public class XFrame extends JFrame implements ActionListener,DocumentListener
{	//define menu bar
	JMenu fileMenu,editMenu,formatMenu,viewMenu,helpMenu;
	//Right click item 
	JPopupMenu popupMenu;
	JMenuItem popupMenu_Undo,popupMenu_Cut,popupMenu_Copy,popupMenu_Paste,popupMenu_Delete,popupMenu_SelectAll;
	//items of FILE
	JMenuItem fileMenu_New,fileMenu_Open,fileMenu_Save,fileMenu_SaveAs,fileMenu_PageSetUp,fileMenu_Print,fileMenu_Exit;
	//items of EDIT
	JMenuItem editMenu_Undo,editMenu_Cut,editMenu_Copy,editMenu_Paste,editMenu_Delete,editMenu_Find,editMenu_FindNext,editMenu_Replace,editMenu_GoTo,editMenu_SelectAll,editMenu_TimeDate;
	//items of FORMAT
	JCheckBoxMenuItem formatMenu_LineWrap;
	JMenuItem formatMenu_Font;
	//item of VIEW
	JCheckBoxMenuItem viewMenu_Status;
	//item of HELP
	JMenuItem helpMenu_HelpTopics,helpMenu_AboutXFrame;
	//text area
	JTextArea editArea;
	//status label
	JLabel statusLabel;
	//clipboard
	Toolkit toolkit=Toolkit.getDefaultToolkit();
	Clipboard clipBoard=toolkit.getSystemClipboard();
	//Create undo manager 
	protected UndoManager undo=new UndoManager();
	protected UndoableEditListener undoHandler=new UndoHandler();
	//other things
	String oldValue;//store the original content of the edit area for comparing text changes 
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

		fileMenu_PageSetUp=new JMenuItem("PAGE SET");
		fileMenu_PageSetUp.addActionListener(this);

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

		//Add the "file" menu and menu item to the menu bar 
		menuBar.add(fileMenu); 
		fileMenu.add(fileMenu_New); 
		fileMenu.add(fileMenu_Open); 
		fileMenu.add(fileMenu_Save); 
		fileMenu.add(fileMenu_SaveAs); 
		fileMenu.addSeparator();		//gap line
		fileMenu.add(fileMenu_PageSetUp); 
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

		//Add the "help" menu and menu item to the menu bar
		menuBar.add(helpMenu);
		helpMenu.add(helpMenu_HelpTopics);
		helpMenu.addSeparator();
		helpMenu.add(helpMenu_AboutXFrame);
				
		//Add menu bar to window 				
		this.setJMenuBar(menuBar);

		//Create a text edit area and add a scroll bar
		editArea=new JTextArea(20,50);
		JScrollPane scroller=new JScrollPane(editArea);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scroller,BorderLayout.CENTER);//
		editArea.setWrapStyleWord(true);//set linewrap
		editArea.setLineWrap(true);//true for wrap
		oldValue=editArea.getText();//get the contents of the original text editing area

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

		//Set the location, size, and visibility of the window on the screen. 
		this.setLocation(200,50);
		this.setSize(1050,650);
		this.setVisible(true);
		//Add the listener window 
		addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{	exitWindowChoose();
			}
		});

		checkMenuItemEnabled();
		editArea.requestFocus();
	}//end of constructor
	
	//Set menu item availability: cut, copy, paste, delete function 
	public void checkMenuItemEnabled(){}

	//Call when closing the window
	public void exitWindowChoose(){}

	//method of find word
	public void find(){}
	
	//method of replace word
	public void replace(){}

	//font method
	public void font(){}
	
	// The action of each button 
	public void actionPerformed(ActionEvent e){}

	//Method to implement the "documentlistener" interface (related to undo operation) 
	public void removeUpdate(DocumentEvent e){}
	public void insertUpdate(DocumentEvent e){}
	public void changedUpdate(DocumentEvent e){}

	//Implementation of the interface undoableeditlistener class undohandler (related to undo operation)
	class UndoHandler implements UndoableEditListener
	{	public void undoableEditHappened(UndoableEditEvent uee){}
	}

}
