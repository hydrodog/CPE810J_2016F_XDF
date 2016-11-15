package edu.stevens;

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
	       
		   System.out.println("Font type");// 
	   }

}
