package edu.stevens;

/*
 * @author:Yujie Ren
 * Draw SVG polygon
 */
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;
public class Polygon {
	private String points,stroke,strokeWidth,color,fillRule,fillOpacity,strokeOpacity,opacity;
	private SVGDocument doc;
	public Polygon(String points,String color,String stroke, String strokeWidth,String strokeOpacity,String fillRule,String fillOpacity,String opacity,SVGDocument doc){
		this.points = points;
		this.color = color;
		this.stroke = stroke;
		this.strokeWidth = strokeWidth;
		this.fillRule = fillRule;
		this.opacity = opacity;
		this.fillOpacity = fillOpacity;
		this.strokeOpacity = strokeOpacity;
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
		polygon.setAttributeNS(null, "fill-opacity", fillOpacity);
		polygon.setAttributeNS(null, "stroke-opacity", strokeOpacity);
		polygon.setAttributeNS(null, "opacity", opacity);
		return polygon;	
	}
}
