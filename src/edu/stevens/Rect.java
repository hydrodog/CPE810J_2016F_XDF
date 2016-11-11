package edu.stevens;

import java.awt.Graphics;

public class Rect extends Shape {
	private double width, height;
	public Rect(double x, double y, double width, double height) {
		super(x,y);
		this.width = width;
		this.height = height;
	}
	
	public void paint(Graphics g) {
		g.drawRect((int)x, (int)y, (int)width, (int)height);
	}
}