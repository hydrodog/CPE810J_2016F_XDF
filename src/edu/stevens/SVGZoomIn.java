package edu.stevens;
/*
 * 
 * @author: Bonan Chen
 * Zoom out SVG
 * when click right button one times, SVG will be zoomed in.
 *
 */
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.gvt.InteractorAdapter;

public class SVGZoomIn extends InteractorAdapter {
	private CompoundShape cs;
	public SVGZoomIn(CompoundShape cs){
		this.cs = cs;
	}
	protected boolean isDoubleClick(InputEvent ie) {
	    
		if (ie instanceof MouseEvent) {
            MouseEvent me = (MouseEvent) ie;
            return me.getID() == MouseEvent.MOUSE_CLICKED 
            	&& me.getButton() == MouseEvent.BUTTON3
                && me.getClickCount() == 1;
        }
        return false;
    }

    public boolean startInteraction(InputEvent ie) {
        return isDoubleClick(ie);
    }

    public boolean endInteraction() {
        return true;
    }
    public void mouseClicked(MouseEvent me) {
        if (isDoubleClick(me)) {
            JSVGCanvas displayCanvas = (JSVGCanvas) me.getSource();
            AffineTransform at = AffineTransform.getScaleInstance(0.9, 0.9);
            AffineTransform rt = (AffineTransform) displayCanvas.getRenderingTransform().clone();
            rt.preConcatenate(at);
            cs.setRenderingTransform(rt);
        }
    }
}
