package xdf;
import java.net.URL;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.*;
import java.util.*;

public class font extends JPanel {
 

private static ClassLoader loader;  
 private JList style;               //style
 private JList font;                //font
 private JList size;                //size
 private JList color;              //color
 private JColorChooser colorChooser;   
 private JDialog colorDialog;       
 private JScrollPane jsp1;           
 private JScrollPane jsp2;           
 private JScrollPane jsp3;          
 private JScrollPane jsp4;           
 private JTextField jtf1;            
 private JTextField jtf2;           
 private JTextField jtf3;            
 private JTextField jtf4;            
 private JTextField jtf5;            
 private JLabel jLabel1;            
 private JLabel jLabel2;             
 private JLabel jLabel3;                    
 private JLabel jLabel4;             
 private JLabel jLabel5;                  
 private JPanel jPanel2;            
 private JButton jButton;          
 
 public font() {
  setLayout(null);
  setPreferredSize(new Dimension(450, 375));
  initComponent();
 }
 
 private void initComponent() {
  
  loader = this.getClass().getClassLoader();
  
  jLabel1 = new JLabel("(F):");                                  // jlabel of the type of font                       
  jLabel1.setBounds(20, 15, 80, 17);
  this.add(jLabel1);
  
  jtf1 = new JTextField("Fixedsys");                                    //add textfield of fixedsys to jlabel1
  jtf1.setBounds(20, 32, 150, 18);
  this.add(jtf1);
  
  style = new JList(getFontStyle());                                    //add the type or the style of the font                                                      
  style.addListSelectionListener(new ListSelectionListener() {
   public void valueChanged(ListSelectionEvent e) {
    jtf1.setText(style.getSelectedValue().toString());
    jLabel5.setFont(new Font(jtf1.getText(), getCharFont(jtf2.getText()), Integer.parseInt(jtf3.getText())));
   }
  });
  jsp1 = new JScrollPane(style);                                           // add the scrollpane to add the style of the font                              
  jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
  jsp1.setBounds(20, 50, 150, 140);
  this.add(jsp1);
  
  jLabel2 = new JLabel("(Y):");                                                          //font
  jLabel2.setBounds(180, 15, 80, 17);
  this.add(jLabel2);
  
  jtf2 = new JTextField("Normal");
  jtf2.setBounds(180, 32, 110, 18);
  this.add(jtf2);
  
  font = new JList(getCharFont());
  font.addListSelectionListener(new ListSelectionListener() {
   public void valueChanged(ListSelectionEvent e) {
    jtf2.setText(font.getSelectedValue().toString());
    jLabel5.setFont(new Font(jtf1.getText(), getCharFont(jtf2.getText()), Integer.parseInt(jtf3.getText())));
   }
  });
  jsp2 = new JScrollPane(font);
  jsp2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
  jsp2.setBounds(180, 50, 110, 140);
  this.add(jsp2);
  
  jLabel3 = new JLabel("(S):");
  jLabel3.setBounds(300, 15, 50, 17);
  this.add(jLabel3);
  
  jtf3 = new JTextField("12");
  jtf3.setBounds(300, 32, 50, 18);
  this.add(jtf3);
  
  size = new JList(getCharSize());
  size.addListSelectionListener(new ListSelectionListener() {
   public void valueChanged(ListSelectionEvent e) {
    jtf3.setText(size.getSelectedValue().toString());
    jLabel5.setFont(new Font(jtf1.getText(), getCharFont(jtf2.getText()), Integer.parseInt(jtf3.getText())));
   }
  });
  jsp3 = new JScrollPane(size);
  jsp3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
  jsp3.setBounds(300, 50, 50, 140);
  this.add(jsp3); 
  
  jLabel4 = new JLabel("Color(C)");
  jLabel4.setBounds(20, 210, 70, 17);
  this.add(jLabel4);
  
  jtf4 = new JTextField("black");
  jtf4.setBounds(20, 227, 150, 18);
  this.add(jtf4);
  
  colorChooser = new JColorChooser();
  colorDialog = JColorChooser.createDialog(
   this,
   "colorChooser",
   false,
   colorChooser,
   new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     jLabel5.setForeground(colorChooser.getColor());
    }
   },
   new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     colorDialog.setVisible(false);
    }
   });
  color = new JList(getColor());
  color.addListSelectionListener(new ListSelectionListener() {
   public void valueChanged(ListSelectionEvent e) {
    if(color.getSelectedIndex() != 5) {  
     jtf4.setText(color.getSelectedValue().toString());
     jLabel5.setForeground(getColor(jtf4.getText()));
     return ;
    }
    colorDialog.setVisible(true);
   }
  });
  jsp4 = new JScrollPane(color);
  jsp4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
  jsp4.setBounds(20, 245, 150, 65);
  this.add(jsp4);
  jPanel2 = new JPanel();
  jPanel2.setLayout(null);
  jPanel2.setBorder(BorderFactory.createTitledBorder("example"));
  jPanel2.setBounds(180, 210, 170, 120);
  this.add(jPanel2);
  jLabel5 = new JLabel("<html>test");
  jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
  jLabel5.setBounds(5, 15, 160, 90);
  jPanel2.add(jLabel5);
  jtf5 = new JTextField();
  jtf5.setBounds(181, 330, 90, 20);
  this.add(jtf5);
  File file = new File("");
	File outfile = new File("");
	
JButton b1= new JButton("creat");                                                                     //button1: creat the signature
  b1.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
	   Object source=e.getSource();
		String areatext=jtf5.getText();
		if(source==b1){
			try {  
		         ObjectInputStream in = new ObjectInputStream(new FileInputStream("myprikey.dat"));  
		         PrivateKey myprikey = (PrivateKey) in.readObject();  
		         in.close();  
			         
		         // use private key to create signature
		         Signature signat = Signature.getInstance("DSA");  
		         signat.initSign(myprikey);  
		         signat.update(areatext.getBytes());  
		         // the created digital signature  
		         byte[] signed = signat.sign(); 

		         
		         // saving my signature information and digital signature in the same file "myinfo.dat"
		         ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("myinfo.dat"));  
		         out.writeObject(areatext);  
		         out.writeObject(signed);  
		         out.close();  
		  
		         
		         System.out.println("successfully creating signature and saving in file ");  
		     } catch (java.lang.Exception e1) {  
		         e1.printStackTrace();  
		         System.out.println("failed to create signature and save info in file");  
		     }  
		} 
	   }
   });
  JButton b2=new JButton("Verify");                                                                                                                                      //bbutton2:verify the signature and print
  b2.addActionListener(new ActionListener(){
	 public void actionPerformed(ActionEvent e){
		 Object source=e.getSource();
			String areatext=jtf5.getText();
			if(source==b2){
				 try {  
			            ObjectInputStream in = new ObjectInputStream(new FileInputStream("mypubkey.dat"));  
			            PublicKey pubkey = (PublicKey) in.readObject();  
			            in.close();  
			        //    System.out.println(pubkey.getFormat());  
			            in = new ObjectInputStream(new FileInputStream("myinfo.dat"));  
			            String info = (String) in.readObject();  
			            byte[] signed = (byte[]) in.readObject();  
			            in.close();  
			            Signature signetcheck = Signature.getInstance("DSA");  
			            signetcheck.initVerify(pubkey);  
			            signetcheck.update(info.getBytes());  
			            if (signetcheck.verify(signed)) {  
			            	jLabel5.setText("<html>"+jtf5.getText()); 
			                System.out.println("Signature is normal");  
			            } else  
			                System.out.println("Signature is abnormal");  
			        } catch (Exception e2) {  
			            e2.printStackTrace();  
			        }  
				 
			}
		}
  });
  b1.setBounds(270, 330, 80, 20);
  b2.setBounds(230,350,80,20);
  this.add(b1);
  this.add(b2);
 }
 
 
 public String[] getFontStyle() {
  
  Font[] systemFont = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
  String[] systemFontString = new String[systemFont.length];
  for(int i=0; i<systemFontString.length; i++) {
   systemFontString[i] = systemFont[i].getName();
  }
  
  return systemFontString;
 }
 
 
 public String[] getCharFont() {
  
  String[] font = {"plain", "bold", "italic", "else"};                                                                                                  //select different font
  return font;
 }
 
 public int getCharFont(String str) {
  
  if(str.equals("plain")) {
   return Font.PLAIN;
  }
  else if(str.equals("bold")) {
   return Font.BOLD;
  }
  else if(str.equals("italic")){
   return Font.ITALIC;
  }
  else {
   return Font.ITALIC + Font.BOLD;
  }
 }
 
 
 public String[] getCharSize() {
  
  String[] size = new String[70];
  for(int i=0; i<size.length; i++) {
   size[i] = Integer.toString(i+8);
  }
  return size;
 }
 
   
 public String[] getColor() {                                                                                                    // select   color  
  
  String[] color = {"black", "red", "blue", "yellow", "green", "user-defined"};
  return color;
 }
 
 public Color getColor(String str) {
  
  if(str.equals("black")) {
   return Color.BLACK;
  }
  else if(str.equals("red")) {
   return Color.RED;
  }
  else if(str.equals("blue")) {
   return Color.BLUE;
  }
  else if(str.equals("yellow")) {
   return Color.YELLOW;
  }
  else {
   return Color.GREEN;
  }
 }
 public static void main(String[] args) {
  
  font fsDialog = new font();
       JFrame jf = new JFrame();
       URL iconURL = loader.getResource("font/pic/icon.png");
       if (iconURL != null) {
           ImageIcon icon = new ImageIcon(iconURL);
           jf.setIconImage(icon.getImage());
       }
       
       jf.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {
            System.exit(0);
           }
       });
       jf.getContentPane().add(fsDialog);
       jf.setResizable(false);
       jf.setSize(450, 375);
       jf.setTitle("font");
       jf.pack();
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  Dimension frameSize = jf.getSize();
  jf.setLocation(
   (screenSize.width - frameSize.width) / 2,
   (screenSize.height - frameSize.height) / 2
   );
       jf.setVisible(true);
      
   }
 }
