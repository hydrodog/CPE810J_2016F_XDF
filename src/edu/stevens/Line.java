package edu.stevens;

import java.io.*;

public class Line extends Shape{
	private String LastX, LastY, strokeWidth;
	public Line (String x,String y,String LastX, String LastY,String color,String strokeWidth){
		super(x,y,color);
		this.LastX = LastX;
		this.LastY = LastY;
		this.strokeWidth = strokeWidth;
	}

	public void paint() throws Exception {
		 try {
	         BufferedWriter out = new BufferedWriter(new FileWriter
	         ("printfile.ps",true));
	         out.write(strokeWidth + " setlinewidth %set the line's strokewide\n" +
	        		   x + " " + y +" moveto %put the start point \n" +
	        		   LastX + " " + LastY + " lineto %construct the line \n" +
	        		   color + "  setgray %set the color of the line \n"+
	        		   "stroke \n");
	         out.close();
	      }
	      catch (IOException e) {
	         System.out.println("exception occoured"+ e);
	      }
	}
	public void paintColor() throws Exception {
		 try {
	         BufferedWriter out = new BufferedWriter(new FileWriter
	         ("printfile.ps",true));
	         out.write(strokeWidth + " setlinewidth %set the line's strokewide\n" +
	        		   x + " " + y +" moveto %put the start point \n" +
	        		   LastX + " " + LastY + " lineto %construct the line \n" +
	        		   color + "  setrgbcolor %set the color of the line \n"+
	        		   "stroke \n");
	         out.close();
	      }
	      catch (IOException e) {
	         System.out.println("exception occoured"+ e);
	      }
	}
}
