package edu.stevens.XDF._2dGraphics;
import java.awt.*;
/*
 * Draw rectangle
 */
import java.awt.geom.*;
public class Rect extends Shape {
    private double width,height;
    public Rect(double x,double y,Color c, double width,double height){
    	super(x,y,c);
    	this.width = width;
    	this.height = height;
    }
	public void paint(Graphics g) {
		Graphics2D graph2 = (Graphics2D)g;
		graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph2.setColor(c);
		graph2.draw(new Rectangle2D.Double(x, y, width, height));
		
	}
	

}
