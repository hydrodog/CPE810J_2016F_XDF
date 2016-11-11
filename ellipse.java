package edu.stevens.XDF._2dGraphics;
import java.awt.*;
/*
 *@author Jiahui Zhang
 * Draw ellipse
 */
import java.awt.geom.*;
public class ellipse extends Shape{
	private double r1,r2;
	public ellipse(double x,double y,Color c,double r1, double r2){
		super(x,y,c);
		this.r1 = r1;
		this.r2 = r2;
	}

	
	public void paint(Graphics g) {
		final double d1 = 2*r1;
		final double d2 = 2*r2;
		Graphics2D graph2 = (Graphics2D)g;
		graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph2.setColor(c);
		graph2.draw(new Ellipse2D.Double(x, y, d1, d2));
		
	}

}
