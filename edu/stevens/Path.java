package edu.stevens;

/*
 * @author:
 * Draw SVG path
 */
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;
public class Path {
	private String d,stroke,strokeWidth,color,strokeOpacity,fillOpacity,opacity;
	private SVGDocument doc;
	public Path(String d,String color,String stroke, String strokeWidth,String strokeOpacity,String fillOpacity,String opacity,SVGDocument doc){
		this.d = d;
		this.color = color;
		this.stroke = stroke;
		this.strokeWidth = strokeWidth;
		this.doc = doc;
		this.strokeOpacity = strokeOpacity;
		this.fillOpacity = fillOpacity;
		this.opacity = opacity;
	}	
	public Element paint() {
		// create path
		Element path = doc.createElementNS("http://www.w3.org/2000/svg", "path");
		path.setAttributeNS(null, "d", d);
		path.setAttributeNS(null, "stroke", stroke);
		path.setAttributeNS(null, "stroke-width", strokeWidth);
		path.setAttributeNS(null, "fill", color);
		path.setAttributeNS(null, "stroke-opacity", strokeOpacity);
		path.setAttributeNS(null, "fill-opacity", fillOpacity);
		path.setAttributeNS(null, "opacity", opacity);
		return path;	
	}
}
