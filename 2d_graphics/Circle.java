package edu.stevens.XDF._2dGraphics;

/*
 * @author:Jiahui Zhang
 * Draw SVG circle
 */

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

public class Circle extends Shape{
	private String r,stroke,strokeWidth;
	public Circle(String cx,String cy,String r, String color, String stroke, String strokeWidth, SVGDocument doc){
		super(cx,cy,color,doc);
		this.r = r;
		this.stroke = stroke;
		this.strokeWidth = strokeWidth;
	}	
	public Element paint() {
		// Create the circle
		Element circle = doc.createElementNS("http://www.w3.org/2000/svg", "circle");
		circle.setAttributeNS(null, "cx", x);
		circle.setAttributeNS(null, "cy", y);
		circle.setAttributeNS(null, "r", r);
		circle.setAttributeNS(null, "fill", color);	
		circle.setAttributeNS(null, "stroke", stroke);
		circle.setAttributeNS(null, "stroke-width", strokeWidth);
		return circle;	
	}
}
	