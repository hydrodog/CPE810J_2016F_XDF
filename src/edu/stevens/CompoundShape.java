package edu.stevens;
/*
 * @author: Yujie Ren
 * According to shape information of parsed SVG file, compound all shapes. 
 * Draw the compound shapes.
 */

import org.apache.batik.swing.JSVGCanvas;

public class CompoundShape extends JSVGCanvas {
	private importSVG i1;
	public CompoundShape(importSVG i1){
		this.i1 = i1;
		// Draw the document.
		setSVGDocument(i1.getDoc());
	}
}