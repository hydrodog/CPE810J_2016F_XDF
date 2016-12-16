/*
 * @author Yingnan Zhang
 * This is the class to resize the Image by proportion and save the new image
 * also supports JPEG image. 
 */

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 

 // This class is to resize an PNG image.

public class ResizeImage {
 
    public static void resize(String inputPath,
            String outputPath, int newWidth, int newHeight)
            throws IOException {
        //load input image
        File inputFile = new File(inputPath);
        BufferedImage inputImage = ImageIO.read(inputFile);
 
        // creates output image
        BufferedImage outputImage = new BufferedImage(newWidth,
                newHeight, inputImage.getType());
 
        // resize the origin image to the output 
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();
 
        String formatName = outputPath.substring(outputPath
                .lastIndexOf(".") + 1);
 
        // make output file
        ImageIO.write(outputImage, formatName, new File(outputPath));
    }
 
    //
    public static void resize(String inputPath,
            String outputPath, double proportion) throws IOException {
        File inputFile = new File(inputPath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        int newWidth = (int) (inputImage.getWidth() * proportion);
        int newHeight = (int) (inputImage.getHeight() * proportion);
        resize(inputPath, outputPath, newWidth, newHeight);
    }
 
//Test class
    
    public static void main(String[] args) {
        String inputPath = "123.png";
        String outputPath1 = "Small.png";
        String outputPath2 = "Big.png";
 
        try {  
            //50% smaller
            double proportion = 0.5;
            ResizeImage.resize(inputPath, outputPath1, proportion);
 
            //150%  bigger
            proportion = 1.5;
            ResizeImage.resize(inputPath, outputPath2, proportion);
 
        } catch (IOException ex) {
            System.out.println("Can not resize image.");
            ex.printStackTrace();
        }
    }
 
}
