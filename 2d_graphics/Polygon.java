package edu.stevens.XDF._2dGraphics;

/*
 * @author: Yujie Ren
 * Draw SVG polygon
 */
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;
public class Polygon {
	private String points,stroke,strokeWidth,color,fillRule;
	private SVGDocument doc;
	public Polygon(String points,String color,String stroke, String strokeWidth,String fillRule,SVGDocument doc){
		this.points = points;
		this.color = color;
		this.stroke = stroke;
		this.strokeWidth = strokeWidth;
		this.fillRule = fillRule;
		this.doc = doc;
	}	
	public Element paint() {
		// Create the polygon
		Element polygon = doc.createElementNS("http://www.w3.org/2000/svg", "polygon");
		polygon.setAttributeNS(null, "points", points);
		polygon.setAttributeNS(null, "stroke", stroke);
		polygon.setAttributeNS(null, "stroke-width", strokeWidth);
		polygon.setAttributeNS(null, "fill", color);
		polygon.setAttributeNS(null, "fill-rule", fillRule);
		return polygon;	
	}
}
