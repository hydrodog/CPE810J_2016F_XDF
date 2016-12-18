package edu.stevens;
/*
 * @author: Bonan Chen
 * rotate SVG file
 * when drag mouse to right, the SVG will be anti-clockwise
 * when drag mouse to left, the SVG will be clockwise
 */

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.gvt.InteractorAdapter;

public class Rotation extends InteractorAdapter {
	private CompoundShape cs;
	private AffineTransform at;
	private int X,LastX;
	public Rotation(CompoundShape cs){
		this.cs = cs;
	}
	protected boolean isDoubleClick(InputEvent ie) {
		if (ie instanceof MouseEvent) {
            MouseEvent me = (MouseEvent) ie;
            if(me.getID() == MouseEvent.MOUSE_PRESSED){
            	X = me.getX();
            }
            if(me.getID() == MouseEvent.MOUSE_RELEASED){
            	LastX = me.getX();
            }
            return true;
        }
        return false;
    }
    //start rotate
    public boolean startInteraction(InputEvent ie) {
        return isDoubleClick(ie);
    }
    //end rotate
    public boolean endInteraction() {
        return true;
    }
    public void mouseReleased(MouseEvent me) {
    	JSVGCanvas displayCanvas = (JSVGCanvas) me.getSource();
    	
    	if(LastX < X){
            //clockwise rotate SVG file
           at = AffineTransform.getRotateInstance(0.1);
          }
        if(LastX > X){
          //anti-clockwise rotate SVG file
           at = AffineTransform.getRotateInstance(-0.1);
        }
        //clone SVG file
        AffineTransform rt = (AffineTransform) displayCanvas.getRenderingTransform().clone();
        rt.preConcatenate(at);
        //draw the clone one
        cs.setRenderingTransform(rt);
    	

    }
}
