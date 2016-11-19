package edu.stevens.XDF._2dGraphics;

/*
 * @author:Jiahui Zhang
 * Draw SVG rectangle
 */

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

public class Rect extends Shape{
	private String width,height,stroke,strokeWidth,fillOpacity,opacity,rx,ry;
	public Rect(String x,String y,String width,String height,String rx,String ry,String color,String stroke, String strokeWidth,String opacity,String fillOpacity, SVGDocument doc){
		super(x,y,color,doc);
		this.rx = rx;
		this.ry = ry;
		this.width = width;
		this.height = height;
		this.stroke = stroke;
		this.strokeWidth = strokeWidth;
		this.opacity = opacity;
		this.fillOpacity = fillOpacity;
	}	
	public Element paint() {
		// Create the rectangle
		Element rect = doc.createElementNS("http://www.w3.org/2000/svg", "rect");
		rect.setAttributeNS(null, "x", x);
		rect.setAttributeNS(null, "y", y);
		rect.setAttributeNS(null, "width", width);
		rect.setAttributeNS(null, "height", height);
		rect.setAttributeNS(null, "rx", rx);
		rect.setAttributeNS(null, "ry", ry);
		rect.setAttributeNS(null, "stroke", stroke);
		rect.setAttributeNS(null, "stroke-width", strokeWidth);
		rect.setAttributeNS(null, "fill", color);
		rect.setAttributeNS(null, "fill-opacity", fillOpacity);	
		rect.setAttributeNS(null, "opacity", opacity);	
		return rect;	
	}
}
