package edu.stevens;
/*
 * @author:
 * Create more shapes(such as circle, line, rectangle...)
 * TODO: create linear class, text class...
 */
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

public abstract class Shape {
    protected String x,y,color,fillOpacity,opacity,strokeOpacity,stroke,strokeWidth;
    protected SVGDocument doc;
	public Shape(String x,String y,String color,String stroke,String strokeWidth,String opacity,String strokeOpacity,String fillOpacity,SVGDocument doc){
		this.x = x;
		this.y = y;
		this.color = color;
		this.opacity = opacity;
		this.stroke = stroke;
		this.strokeWidth = strokeWidth;
		this.fillOpacity = fillOpacity;
		this.strokeOpacity = strokeOpacity;
		this.doc = doc;    
	}
	public abstract Element paint();
}