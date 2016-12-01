package edu.stevens;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Circle extends Shape{
	private String r,strokeWidth;
	public Circle(String x,String y,String r, String color, String strokeWidth){
		super(x,y,color);
		this.r = r;
		this.strokeWidth = strokeWidth;
	}
	
	public void paint() throws Exception {
		 try {
	         BufferedWriter out = new BufferedWriter(new FileWriter
	         ("printfile.ps",true));
	         out.write("newpath\n" +
	        		   x + " " + y + " " + r + " 0 360 arc close\n" +
	        		   color + "  setrgbcolor %set the color of the rect \n"+
	        		   "fill\n" +
	        		   strokeWidth + " setlinewidth %set the line's strokewide\n" +
	        		   color + "  setrgbcolor %set the color of the line \n"+
	        		   "stroke \n");
	         out.close();
	      }
	      catch (IOException e) {
	         System.out.println("exception occoured"+ e);
	      }
	}
}
