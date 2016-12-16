package edu.stevens;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Text {
	private String text, font, x, y, fontsize, color;
	public Text (String text,String font,String x, String y,String fontsize, String color){
		this.text = text;
		this.font = font;
		this.x = x;
		this.y = y;
		this.color = color;
		this.fontsize = fontsize;
	}

	public void show() throws Exception {
		 try {
	         BufferedWriter out = new BufferedWriter(new FileWriter
	         ("printfile.ps",true));
	         out.write(color + " setrgbcolor\n"+
	        		   "/" + font +" findfont\n" +
	        		   fontsize + " scalefont setfont \n" +
	        		   x + " " + y + " moveto\n" +
	        		   "(" + text + ") show \n ");
	         out.close();
	      }
	      catch (IOException e) {
	         System.out.println("exception occoured"+ e);
	      }
	}
}
