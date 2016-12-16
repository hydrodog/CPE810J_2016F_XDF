import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*Create a new BufferedImage with the desired width and height.
*Get hold of it's Graphics object
*Load the original .jpg image 
*Paint the desired part of that, onto the BufferedImage
*Write the buffered image out to file using ImageIO.
*/

public class Crop {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Image src = ImageIO.read(new File("/Users/chenxi/Desktop/衣服.jpg"));

		int x = 30, y = 20, w = 40, h = 50;

		BufferedImage dst = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		dst.getGraphics().drawImage(src, 0, 0, w, h, x, y, x + w, y + h, null);

		ImageIO.write(dst, "png", new File("/Users/chenxi/Desktop/cropped.png"));
	}

}
