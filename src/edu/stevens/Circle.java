package edu.stevens;

/*
 * @author: Jiahui Zhang
 * Draw SVG circle
 */
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;
public class Circle extends Shape{
	private String r;
	public Circle(String cx,String cy,String r, String color, String stroke, String strokeWidth, String strokeOpacity, String fillOpacity, String opacity,String style,String transform ,SVGDocument doc){
		super(cx,cy,color,stroke,strokeWidth,opacity,strokeOpacity,fillOpacity,style,transform,doc);
		this.r = r;
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
		circle.setAttributeNS(null, "fill-opacity", fillOpacity);
		circle.setAttributeNS(null, "stroke-opacity", strokeOpacity);
		circle.setAttributeNS(null, "opacity", opacity);
		circle.setAttributeNS(null, "style", style);
		circle.setAttributeNS(null, "transform", transform);
		return circle;	
	}
}
	