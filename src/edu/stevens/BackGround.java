package edu.stevens;

/*
  @Author Jingting Zhang
  this class is to set the apperence of the window
*/

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*; 
import java.awt.Container;
  
//to show the background color and image of the frame
//to click the right-hand button to change the background color
//TODO:add buttons to change colors of the titlebar

public class BackGround extends JFrame {  
   JRadioButtonMenuItem items[];  
   Color[] colors={Color.getHSBColor(244,121,131),Color.pink,Color.getHSBColor(238,238,238),
		   Color.getHSBColor(202,86,99),Color.getHSBColor(200,155,64),Color.getHSBColor(243,249,241)}; //color array
   JPopupMenu popupMenu;  
  
   public BackGround()  
   {  
      super( "" ); 
      ChangeColorAction action = new ChangeColorAction();  
      String[] str = {"Lemon Yellow","Candy Pink","Grass Green","Silver Gary","Sunny Orange","Tambac Brown"}; //name of the color button  
      ButtonGroup colorGroup=new ButtonGroup();  
      popupMenu=new JPopupMenu();   
      items=new JRadioButtonMenuItem[6]; 
      for (int i=0;i<items.length;i++) {   
         items[i]=new JRadioButtonMenuItem(str[i]);
         popupMenu.add(items[i]);  
         colorGroup.add(items[i]);   
        items[i].addActionListener(action); 
      }       
  
      addMouseListener(new MouseAdapter(){  //MouseListener 
        public void mousePressed( MouseEvent event ) {  
           triggerEvent(event);   
        }   
  
        public void mouseReleased( MouseEvent event ) { 
           triggerEvent(event);   
        }   
  
        private void triggerEvent(MouseEvent event) {  
           if (event.isPopupTrigger())   
              popupMenu.show(event.getComponent(),event.getX(),event.getY());   
        }  
    });   
    
    ImageIcon img = new ImageIcon("2.jpg");//set the default background image
    JLabel imgLabel = new JLabel(img);
    imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
    Container cp = getContentPane();
    ((JPanel)cp).setOpaque(true); 
    getLayeredPane().setLayout(null);
    getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
    
    getContentPane().setBackground(Color.white); //set white as the default background color
    setSize(400,400); 
    setVisible(true);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE ); 
   }  
   }  
  
   class ChangeColorAction implements ActionListener { 
      public void actionPerformed(ActionEvent event)   {  
         for (int i=0;i<items.length;i++)  
            if (event.getSource()==items[i]) { 
               getContentPane().setBackground(colors[i]); 
               repaint(); //repaint the window 
               return;  
         }  
      }  
   }    
     
   public static void main( String args[])   {  
      new BackGround();        
   }  
}
