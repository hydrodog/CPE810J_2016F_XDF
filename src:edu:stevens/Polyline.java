package edu.stevens.XDF._2dGraphics;

/*
 * @author:Jiahui Zhang
 * Draw SVG polyline
 */

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

public class Polyline {
	private String points,stroke,strokeWidth,color;
	private SVGDocument doc;
	public Polyline(String points,String color,String stroke, String strokeWidth,String fillRule,SVGDocument doc){
		this.points = points;
		this.color = color;
		this.stroke = stroke;
		this.strokeWidth = strokeWidth;
		this.doc = doc;
	}	
	public Element paint() {
		// Create the polyline
		Element polyline = doc.createElementNS("http://www.w3.org/2000/svg", "polyline");
		polyline.setAttributeNS(null, "points", points);
		polyline.setAttributeNS(null, "stroke", stroke);
		polyline.setAttributeNS(null, "stroke-width", strokeWidth);
		polyline.setAttributeNS(null, "fill", color);
		return polyline;	
	}
}
