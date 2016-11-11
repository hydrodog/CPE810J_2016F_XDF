package edu.stevens.XDF._2dGraphics;
import java.awt.*;
import java.awt.Graphics2D;
/*
 * Define attributes of shapes
 */
public abstract class Shape {
	protected double x,y;
	protected Color c;
	public Shape(double x,double y,Color c){
		this.x = x;
		this.y = y;
		this.c = c;
		
	}
	
	public abstract void paint(Graphics g);

}
