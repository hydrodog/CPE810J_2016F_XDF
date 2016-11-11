package ImageTest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Cropping extends JPanel{

	public static void main(String[] args) {
		try {
			BufferedImage originalImgage = ImageIO.read(new File("abc.jpg"));
			
			System.out.println("Original Image Dimension: "+originalImgage.getWidth()+"x"+originalImgage.getHeight());

			BufferedImage SubImgage = originalImgage.getSubimage(0, 0, 200, 200);
			System.out.println("Cropped Image Dimension: "+SubImgage.getWidth()+"x"+SubImgage.getHeight());

			File outputfile = new File("abc_new.jpg");
			ImageIO.write(SubImgage, "jpg", outputfile);

			System.out.println("Image cropped successfully: "+outputfile.getPath());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}