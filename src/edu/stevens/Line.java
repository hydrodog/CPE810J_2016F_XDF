package edu.stevens;

/*
 * @author: Jiahui Zhang
 * Draw SVG line
 */
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;
public class Line {
	private String x,y,stroke,LastX,LastY,strokeWidth,style,transform;
	private SVGDocument doc;
	public Line(String x,String y,String LastX, String LastY,String stroke,String strokeWidth,String style,String transform, SVGDocument doc){
		this.x = x;
		this.y = y;
		this.stroke = stroke;
		this.LastX = LastX;
		this.LastY = LastY;
		this.strokeWidth = strokeWidth;
		this.doc = doc;
		this.style = style;
		this.transform = transform;
    }
	
    public Element paint() {
		// Create the line
		Element line = doc.createElementNS("http://www.w3.org/2000/svg", "line");
		line.setAttributeNS(null, "x1", x);
		line.setAttributeNS(null, "y1", y);
		line.setAttributeNS(null, "x2", LastX);
		line.setAttributeNS(null, "y2", LastY);
		line.setAttributeNS(null, "stroke", stroke);
		line.setAttributeNS(null, "stroke-width", strokeWidth);
		line.setAttributeNS(null, "style", style);
		line.setAttributeNS(null, "transform", transform);
		return line;
	}
}



	