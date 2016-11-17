package edu.stevens;
/*
 * @author: Ashutosh Gajankush 
 * This File is responsible for Font Extraction.
*/
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.text.PDFTextStripper;

//This class will Print out the fonts used in the Document
public class FontExtraction {
	   private PDFParser parser; // Parser for reading the file
	   private PDFTextStripper pdfStripper; // Extraction of text.
	   private PDDocument pdDoc ; // Set the no of pages to parse through.
	   private COSDocument cosDoc ; // Combining the parser along with the document.
	   private File file;
	   public FontExtraction(){
		   
	   }
	   //This Method will Extract font from the PDF FIle text
	   public void getFont() throws IOException{
		   this.pdfStripper = null;
	       this.pdDoc = null;
	       this.cosDoc = null;
	       file = new File("file.pdf");//Loading file
	       parser = new PDFParser(new RandomAccessFile(file,"r"));// Opening the file for reading.
	       
	       parser.parse();
	       cosDoc = parser.getDocument(); // Get the document.
	       pdfStripper = new PDFTextStripper(); 
	       pdDoc = new PDDocument(cosDoc);
	       //PDPage page = ((page) pdDoc).getAllPage(); // Error in calling getAllPages method working on it.
	       //PDResources res = page.getResources(); //Calling resources on pages.
	       //Since we cannot access all pages at once we will try to go through every page using loop.
	       for(int i=0; i<pdDoc.getNumberOfPages();i++){
	    	   //In this loop we will try to find to parse through every single page and extract font from every page. 
	    	   PDPage page = pdDoc.getPage(i); // Accessing each page.
	    	   PDResources res = page.getResources(); //Getting the resources.
	    	   // Initialising COSName to get the fonts from resources.
	    	   for (COSName fontName : res.getFontNames())
		    	{
		        	PDFont font = res.getFont(fontName); // Obtaining specific Font Name written in the PDF File.
		        	System.out.println(font);
		    	}
	       }
		   //System.out.println("Font type"); 
	   }

}
