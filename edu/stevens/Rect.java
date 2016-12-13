package edu.stevens.XDF._2dgraphics;

/*
 * @author:
 * Draw SVG rectangle
 */
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;
public class Rect extends Shape{
	private String width,height,rx,ry;
	public Rect(String x,String y,String width,String height,String rx,String ry,String color,String stroke, String strokeWidth,String strokeOpacity,String opacity,String fillOpacity,String style, String transform,SVGDocument doc){
		super(x,y,color,stroke,strokeWidth,opacity,strokeOpacity,fillOpacity,style,transform,doc);
		this.rx = rx;
		this.ry = ry;
		this.width = width;
		this.height = height;
	}	
	public Element paint() {
		// Create the rectangle
		Element rect = doc.createElementNS("http://www.w3.org/2000/svg", "rect");
		rect.setAttributeNS(null, "x", x);
		rect.setAttributeNS(null, "y", y);
		rect.setAttributeNS(null, "width", width);
		rect.setAttributeNS(null, "height", height);
		rect.setAttributeNS(null, "style", style);
		rect.setAttributeNS(null, "rx", rx);
		rect.setAttributeNS(null, "ry", ry);
		rect.setAttributeNS(null, "stroke", stroke);
		rect.setAttributeNS(null, "stroke-width", strokeWidth);
		rect.setAttributeNS(null, "fill", color);
		rect.setAttributeNS(null, "fill-opacity", fillOpacity);	
		rect.setAttributeNS(null, "opacity", opacity);
		rect.setAttributeNS(null, "stroke-opacity", strokeOpacity);	
		rect.setAttributeNS(null, "style", style);	
		rect.setAttributeNS(null, "transform", transform);	
		return rect;	
	}
}
