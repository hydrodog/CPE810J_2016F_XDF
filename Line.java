package edu.stevens.XDF._2dGraphics;

import java.awt.*;
import java.awt.geom.*;
/*
 * Draw line
 */
public class Line extends Shape {
	private double LastX,LastY;
	public Line(double x, double y,double LastX, double LastY, Color c){
		super(x,y,c);
		this.LastX = LastX;
		this.LastY = LastY;
	}
	@Override
	public void paint(Graphics g) {
		Graphics2D graph2 = (Graphics2D)g;
		graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graph2.setColor(c);
		graph2.draw(new Line2D.Double(x, y, LastX, LastY));
		
	}

}
