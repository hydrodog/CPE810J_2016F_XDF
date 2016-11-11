package edu.stevens;

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
//click right-hand button to change the background color 
  
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
  
    getContentPane().setBackground(Color.white); //set white as the default background color 
    setSize(400,400); 
    setVisible(true);  
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE ); 
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
