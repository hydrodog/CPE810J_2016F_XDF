/*
 * @author Haoyue Bai
 * This can be used to implement the function of read, rotate and scale JPEG image. And it
 * also supports PNG image. 
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Used JPanel to test my code in visual.
 */
public class ImageJpg extends JPanel {
	public static void main(String[] args){
		JFrame F = new JFrame();
		F.add(new ImageJpg());
		F.setSize(600, 600);//This is a test size of window.
		F.setVisible(true);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paintComponent(Graphics g){
		BufferedImage owl = LoadImage("free.jpg");//Use LoadImage to read image file.
		AffineTransform at = AffineTransform.getTranslateInstance(100, 100);
		at.rotate(Math.toRadians(45), owl.getWidth()/2, owl.getHeight()/2);//Rotate image according to its center.
		at.scale(0.5, 0.75);//Scale image so that it can be displayed appropriately.
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(owl, at, null);
		repaint();
		
	}
	
	/*
	 * Use LoadImage in here to read JPEG and PNG format image.
	 */
	BufferedImage LoadImage(String Filename){
		BufferedImage img = null;
		
		try{
			img = ImageIO.read(new File(Filename));
		}catch(IOException e){
			
		}
		
		return img;
		
	}

}
