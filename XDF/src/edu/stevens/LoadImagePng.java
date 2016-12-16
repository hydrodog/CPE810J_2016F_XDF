import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
 

 //This class is how to load a PNG Image 
 
public class LoadImage extends Component {
           
    BufferedImage image;
 
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
    
  //read PNG image from external file
    public LoadImage() {
       try {
           image = ImageIO.read(new File("123.png"));
       } catch (IOException e) {
    	   System.out.println("Can not load image.");
       }
 
    }
 //get preferred size 
    public Dimension getPreferredSize() {
        if (image == null) {
             return new Dimension(0,200);
        } else {
           return new Dimension(image.getWidth(null), image.getHeight(null));
       }
    }
 
 //test class
    public static void main(String[] args) {
 
        JFrame f = new JFrame("123");         
        f.add(new LoadImage());
        f.pack();
        f.setVisible(true);
    }
}
