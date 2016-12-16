package FlifImage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * 
 * 
 * 
 * 
 * @author Chen Xi
 * This class is designed to check file 
 *
 */

class CheckFile {
	//check whether file is exist
    public boolean FileExist(BufferedImage image) throws IOException{
    	image = ImageIO.read(new File("衣服.jpg"));
    	return true;
    }
    //check whether file if flif type
    public boolean FileIsFlif(){
    	
    	return true;
    }
    //check file's format
    public boolean extension(){
    	return true;
    }
}
