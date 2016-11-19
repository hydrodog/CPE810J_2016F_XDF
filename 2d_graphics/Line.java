package edu.stevens.XDF._2dGraphics;

/*
 * @author:Jiahui Zhang
 * Draw SVG line
 */

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

public class Line extends Shape{
	private String LastX,LastY,strokeWidth;
	public Line(String x,String y,String LastX, String LastY,String stroke,String strokeWidth, SVGDocument doc){
		super(x,y,stroke,doc);
		this.LastX = LastX;
		this.LastY = LastY;
		this.strokeWidth = strokeWidth;
    }
	
    public Element paint() {
		// Create the line
		Element line = doc.createElementNS("http://www.w3.org/2000/svg", "line");
		line.setAttributeNS(null, "x1", x);
		line.setAttributeNS(null, "y1", y);
		line.setAttributeNS(null, "x2", LastX);
		line.setAttributeNS(null, "y2", LastY);
		line.setAttributeNS(null, "stroke", color);
		line.setAttributeNS(null, "stroke-width", strokeWidth);
		return line;
	}
}



	