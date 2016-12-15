import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class DSAFrame extends JFrame{   //generate frame for users
	public DSAFrame(){
		super("text editor");
		JPanel jp=new JPanel();
		Container c = getContentPane();
		JTextArea  text= new JTextArea(1,45);   //this text area if for generating signature
		JTextArea  text1= new JTextArea(1,45);  ////this text area if for verifying signature
		
		JButton button1=new JButton("CreateSignature");
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object source=e.getSource();
				String areatext=text.getText();
				if(source==button1){
					DSAGenerate a1=new DSAGenerate();
					a1.generate(areatext);
				}
		     }  
		});
		JButton button2=new JButton("VerifiedSignature");
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Object source=e.getSource();
				if(source==button2){
					DSAVerify a2=new DSAVerify();
					a2.verify();
					text1.setText("signed information = "+a2.getInfo());  
	            	jp.add(text1,BorderLayout.NORTH);
				}
		     }  
		});
		jp.add(button1,BorderLayout.CENTER);
		jp.add(button2,BorderLayout.SOUTH);
		jp.add(text, BorderLayout.NORTH);
		jp.add(text1,BorderLayout.NORTH);
		c.add(jp, BorderLayout.CENTER);

		setSize(600,200);
		setVisible(true);
	}
}
