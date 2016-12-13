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
		// Draw the document.
		setSVGDocument(i1.getDoc());
	}
}