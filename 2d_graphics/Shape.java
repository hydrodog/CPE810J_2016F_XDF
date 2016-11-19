package edu.stevens.XDF._2dGraphics;

/*
 * @author:Jiahui Zhang
 * Create more shapes(such as circle, line, rectangle...)
 * TODO: create linear class, text class...
 */
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

public abstract class Shape {
    protected String x,y,color;
    protected SVGDocument doc;
	public Shape(String x,String y,String color,SVGDocument doc){
		this.x = x;
		this.y = y;
		this.color = color;
		this.doc = doc;    
	}
	public abstract Element paint();
}