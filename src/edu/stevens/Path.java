package edu.stevens;

/*
 * @author: Jiahui Zhang
 * Draw SVG path
 */
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;
public class Path {
	private String d,stroke,strokeWidth,color,strokeOpacity,fillOpacity,opacity,transform,style;
	private SVGDocument doc;
	public Path(String d,String color,String stroke, String strokeWidth,String strokeOpacity,String fillOpacity,String opacity,String style,String transform,SVGDocument doc){
		this.d = d;
		this.color = color;
		this.stroke = stroke;
		this.strokeWidth = strokeWidth;
		this.doc = doc;
		this.strokeOpacity = strokeOpacity;
		this.fillOpacity = fillOpacity;
		this.transform = transform;
		this.opacity = opacity;
		this.style = style;
	}	
	public Element paint() {
		// create path
		Element path = doc.createElementNS("http://www.w3.org/2000/svg", "path");
		path.setAttributeNS(null, "d", d);
		path.setAttributeNS(null, "transform", transform);
		path.setAttributeNS(null, "stroke", stroke);
		path.setAttributeNS(null, "stroke-width", strokeWidth);
		path.setAttributeNS(null, "fill", color);
		path.setAttributeNS(null, "stroke-opacity", strokeOpacity);
		path.setAttributeNS(null, "fill-opacity", fillOpacity);
		path.setAttributeNS(null, "opacity", opacity);
		path.setAttributeNS(null, "style", style);
		return path;	
	}
}
