package edu.stevens;

public abstract class Shape {
	protected String x, y, color, stroke;
	
	public Shape(String x, String y, String color){
		this.x = x;
		this.y = y;
		this.color = color;	
	}
	
	public abstract void paint() throws Exception;
}