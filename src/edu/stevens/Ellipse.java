package edu.stevens;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ellipse extends Shape {
	private String x1, x2, x3, y1, y2, y3, strokeWidth;
	public Ellipse(String x, String y, String x1, String y1, String x2, String y2, String x3, String y3, String color, String strokeWidth) {
		super(x, y, color);
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.strokeWidth = strokeWidth;
		
	}

	public void paint() throws Exception {
		try {
	         BufferedWriter out = new BufferedWriter(new FileWriter
	         ("printfile.ps",true));
	         out.write("newpath\n"+
	        		   x + y + x1 + y1 + x3 + y3 + " curve %the up part of the ellipse \n" +
	        		   x + y + x2 + y2 + x3 + y3 + " curve %the bottom part of the ellipse \n" +
	        		   "closepath \n"+
	        		   color + "  setrgbcolor %set the color of the rect \n"+
	        		   "fill\n" +
	        		   strokeWidth + " setlinewidth %set the line's strokewide\n" +
	        		   "stroke \n");
	         out.close();
	      }
	      catch (IOException e) {
	         System.out.println("exception occoured"+ e);
	      }
	}

}
