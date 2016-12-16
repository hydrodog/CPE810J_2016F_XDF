package edu.stevens;

/*
 * @author: Jiahui Zhang
 * draw g element in the SVG file
 */
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

public class drawG {
	private String transform,fill,stroke;
	private SVGDocument doc;
	public drawG(String transform,String fill,String stroke,SVGDocument doc){
		this.transform = transform;
		this.stroke = stroke;
		this.fill = fill;
		this.doc = doc;
		
	}	
	public Element paint() {
		// create g element
		Element g = doc.createElementNS("http://www.w3.org/2000/svg", "g");
		g.setAttributeNS(null, "transform", transform);
		g.setAttributeNS(null, "stroke", stroke);
		g.setAttributeNS(null, "fill", fill);
		return g;	
	}
}
