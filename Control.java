package Project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
public class Control extends JFrame{
	private String font;
	private Color color;
	
	public Control(String font, Color color){
		super("text editor");
		JPanel jp=new JPanel();
		Container c = getContentPane();
		JTextArea  text= new JTextArea(1,45);
		text.setFont(new Font(font, Font.ITALIC, 16));
		text.setForeground(color);
		JTextArea  text1= new JTextArea(1,45);
		text1.setFont(new Font(font, Font.ITALIC, 16));
		text1.setForeground(color);
		JButton button1=new JButton("CreateSignature");
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object source=e.getSource();
				String areatext=text.getText();
				if(source==button1){
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
		JButton button2=new JButton("VerifiedSignature");
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object source=e.getSource();
				String areatext=text.getText();
				if(source==button2){
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
				            	text1.setText(info);  
				            	jp.add(text1,BorderLayout.NORTH);
				                System.out.println("Signature is normal");  
				            } else  
				                System.out.println("Signature is abnormal");  
				        } catch (Exception e2) {  
				            e2.printStackTrace();  
				        }  
					 
				}
			}
		});
		jp.add(button1,BorderLayout.CENTER);
		jp.add(button2,BorderLayout.SOUTH);
		jp.add(text, BorderLayout.NORTH);
		jp.add(text1,BorderLayout.NORTH);
		c.add(jp, BorderLayout.CENTER);

		setSize(600,800);
		setVisible(true);
	}
	public static void main(String[] args){
		
		new Control("Comic Sans MS",Color.MAGENTA);
	}

}


