package edu.stevens;

/*
 * @author: Bonan Chen
 * Zoom out SVG
 * when click left button two times, SVG will be zoomed out.
 */
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.gvt.InteractorAdapter;

public class SVGZoomOut extends InteractorAdapter {
	private CompoundShape cs;
    public SVGZoomOut(CompoundShape cs){
	    this.cs = cs;
	}
	protected boolean isDoubleClick(InputEvent ie) {
		if (ie instanceof MouseEvent) {
            MouseEvent me = (MouseEvent) ie;
            return me.getID() == MouseEvent.MOUSE_CLICKED 
            	&& me.getButton() == MouseEvent.BUTTON1
                && me.getClickCount() == 2;
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
            AffineTransform at = AffineTransform.getScaleInstance(1.1, 1.1);
            AffineTransform rt = (AffineTransform) displayCanvas.getRenderingTransform().clone();
            rt.preConcatenate(at);
            cs.setRenderingTransform(rt);
        }
    }

}
