package edu.stevens;


import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

/**
 * This class demonstrates how to load an Image from an external file.
 */
public class LoadImageJpeg  {
          
    BufferedImage img;
    /*
     * The fileName is the name you want to read from the computer, 
     * it can be a root name or just the file name which is under the source of the package.
     */
    static String fileName; 
    
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public LoadImageJpeg() {
       try {
           img = ImageIO.read(new File(fileName));
       } catch (IOException e) {
       }

    }

    /*
     * This will paint the image in its original width and height.
     */
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }

    
    /*
     * This is a test main function. When you want to test it separately, you need to 
     * import the two following thing:
     *  import java.awt.event.*
     *  import javax.swing.*
     * 
     * public static void main(String[] args) {
     *
     *   JFrame f = new JFrame("Load Image Sample");
     *      
     *   f.addWindowListener(new WindowAdapter(){
     *           public void windowClosing(WindowEvent e) {
     *               System.exit(0);
     *           }
     *       });
     *
     *   fileName = "cat.jpg";
     *   f.add(new LoadImageJpeg());
     *   f.pack();
     *   f.setVisible(true);
     * }
     */
    
    
}

