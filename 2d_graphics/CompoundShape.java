package edu.stevens.XDF._2dGraphics;

import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.apache.batik.swing.JSVGCanvas;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;
/*
  @Author Yujie Ren
 * According to shape information of parsed SVG file, compound all shapes. 
 * Draw the compound shapes.
 */
public class CompoundShape extends JSVGCanvas {
	private SVGDocument doc;
	public CompoundShape(){
		
		DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
		String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
		doc = (SVGDocument) impl.createDocument(svgNS, "svg", null);
		
		// Get the root element (the SVG element)
		Element svgRoot = doc.getDocumentElement();
		
		// set the width and height attribute on the svg root element
		svgRoot.setAttributeNS(null, "width", "800");
		svgRoot.setAttributeNS(null, "height", "800");

		// Attach the shapes to the SVG root element
		svgRoot.appendChild(new Circle("200","250","100","green","red","10",doc).paint());
		svgRoot.appendChild(new Rect("100","100","50","80","3","2","green","red","10","0.5","0.5",doc).paint());
		svgRoot.appendChild(new Path("M50,50 L30,50 A20,20 0 0,1 50,30 z","black","red","2",doc).paint());
		
		// Draw the document.
		setSVGDocument(doc);
	}
}
