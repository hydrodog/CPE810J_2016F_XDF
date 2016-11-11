import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * This class is to load an PNG Image from a file
 */

public class LoadImage {
          
    BufferedImage img;
    private String filename;

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public LoadImage() {
       try {
           img = ImageIO.read(new File(filename));
       } catch (IOException e) {
    	   System.out.println("this is not a image");//print this if not load an image
       }

    }

    public Dimension getSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));//draw the image with its heights and width
       }
    }

