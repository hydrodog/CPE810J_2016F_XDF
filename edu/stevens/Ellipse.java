package edu.stevens.XDF._2dgraphics;

/*
 * @author:
 * Draw SVG ellipse
 */
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;
public class Ellipse extends Shape{
	private String rx,ry;
	public Ellipse(String cx,String cy,String rx,String ry,String color,String stroke, String strokeWidth,String fillOpacity,String strokeOpacity,String opacity,String style,String transform,SVGDocument doc){
		super(cx,cy,color,stroke,strokeWidth,opacity,strokeOpacity,fillOpacity,style,transform,doc);
		this.rx = rx;
		this.ry = ry;
	}	
	public Element paint() {
		// Create the ellipse
		Element ellipse = doc.createElementNS("http://www.w3.org/2000/svg", "ellipse");
		ellipse.setAttributeNS(null, "cx", x);
		ellipse.setAttributeNS(null, "cy", y);
		ellipse.setAttributeNS(null, "rx", rx);
		ellipse.setAttributeNS(null, "ry", ry);
		ellipse.setAttributeNS(null, "stroke", stroke);
		ellipse.setAttributeNS(null, "stroke-width", strokeWidth);
		ellipse.setAttributeNS(null, "stroke-opacity", strokeOpacity);
		ellipse.setAttributeNS(null, "fill-opacity", fillOpacity);
		ellipse.setAttributeNS(null, "opacity", opacity);
		ellipse.setAttributeNS(null, "fill", color);
		ellipse.setAttributeNS(null, "style",style);
		ellipse.setAttributeNS(null, "transform",transform);

		return ellipse;	
	}
}
