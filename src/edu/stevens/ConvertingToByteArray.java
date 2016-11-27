package edu.stevens;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
/*
 * Converting Image into a byte array. 
 */
public class ConvertingToByteArray {
	
	public static void main(String[] args) throws IOException{
		File file = new File("example.jpg");
		
		FileInputStream imageInFile = new FileInputStream(file);
		byte imageData[] = new byte[(int) file.length()];
		imageInFile.read(imageData);
		
		String imageDataString = encodeImage(imageData);
		System.out.println(imageDataString);
	}
	
	public static String encodeImage(byte[] imageByteArray){
		return Base64.encodeBase64URLSafeString(imageByteArray);
	}
	

}
