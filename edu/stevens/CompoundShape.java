package edu.stevens;
/*
 * @author:
 * According to shape information of parsed SVG file, compound all shapes. 
 * Draw the compound shapes.
 */

import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.apache.batik.swing.JSVGCanvas;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGDocument;

public class CompoundShape extends JSVGCanvas {
	private SVGDocument doc;
	public CompoundShape(){
		importSVG i1 = new importSVG();
//		DOMImplementation impl = SVGDOMImplementation.getDOMImplementation();
//		String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
//		doc = (SVGDocument) impl.createDocument(svgNS, "svg", null);
//		
//		// Get the root element (the SVG element)
//		Element svgRoot = doc.getDocumentElement();
//		
//		// set the width and height attribute on the svg root element
//		svgRoot.setAttributeNS(null, "width", "1000");
//		svgRoot.setAttributeNS(null, "height", "1000");
//		svgRoot.setAttributeNS(null, "viewBox", "0 0 1000 1000");

		// Attach the shapes to the SVG root element
		//svgRoot.appendChild(new Circle("200","250","100","green","#FFFFFF","10",doc).paint());
//		svgRoot.appendChild(new Rect("500","100","50","80","3","2","green","#000000","1","0.9","0.8","1",doc).paint());
		//svgRoot.appendChild(new Path("M200 161c-165                 -37 -200 -131 -73-195 18 -9 38 -16 46 -16 8 0 27 -16 42 -36 49 -64 118 -77 185 -36 70 43 130 124 130 175 0 54 -99 105 -217 112 -43 2 -94 0 -113 -4z","RGb(0,0,255)","red","2",doc).paint());
		//svgRoot.appendChild(new Polyline("1000,10 40,198 190,78 10,78 160,198","black","red", "5","1",doc).paint());
		
		// Draw the document.
		setSVGDocument(i1.getDoc());
	}
}