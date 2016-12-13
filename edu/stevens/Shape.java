package edu.stevens.XDF._2dgraphics;
/*
 * @author:
 * Create more shapes(such as circle, line, rectangle...)
 * TODO: create linear class, text class...
 */
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

public abstract class Shape {
    protected String x,y,color,fillOpacity,opacity,strokeOpacity,stroke,strokeWidth,style,transform;
    protected SVGDocument doc;
	public Shape(String x,String y,String color,String stroke,String strokeWidth,String opacity,String strokeOpacity,String fillOpacity,String style,String transform,SVGDocument doc){
		this.x = x;
		this.y = y;
		this.color = color;
		this.opacity = opacity;
		this.stroke = stroke;
		this.strokeWidth = strokeWidth;
		this.fillOpacity = fillOpacity;
		this.strokeOpacity = strokeOpacity;
		this.doc = doc;    
		this.style = style;
		this.transform = transform;
	}
	public abstract Element paint();
}