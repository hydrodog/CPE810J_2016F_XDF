package edu.stevens.XDF._2dGraphics;

/*
 * @author:Bonan Chen
 * Draw SVG path
 */
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;
public class Path {
	private String d,stroke,strokeWidth,color;
	private SVGDocument doc;
	public Path(String d,String color,String stroke, String strokeWidth,SVGDocument doc){
		this.d = d;
		this.color = color;
		this.stroke = stroke;
		this.strokeWidth = strokeWidth;
		this.doc = doc;
	}	
	public Element paint() {
		// create path
		Element path = doc.createElementNS("http://www.w3.org/2000/svg", "path");
		path.setAttributeNS(null, "d", d);
		path.setAttributeNS(null, "stroke", stroke);
		path.setAttributeNS(null, "stroke-width", strokeWidth);
		path.setAttributeNS(null, "fill", color);
		return path;	
	}
}
