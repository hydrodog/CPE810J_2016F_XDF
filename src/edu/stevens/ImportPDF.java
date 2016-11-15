package edu.stevens;
/*
 * @author: Ashutosh Gajankush 
 * Before running this file make sure you have the PDFBox library included in you project.
 * Got to Readme file for more Information.
*/


import java.io.File;   
import java.io.IOException;

import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
 // This class contains the to Text method which will extract the text from the PDF file.
public class ImportPDF {
    
   private PDFParser parser; // Parser for reading the file
   private PDFTextStripper pdfStripper; // Extraction of text.
   private PDDocument pdDoc ; // Set the no of pages to parse through.
   private COSDocument cosDoc ; // Combining the parser along with the document.
   
   private String Text ;
   private String filePath;
   private File file;

    public ImportPDF() {
        
    }
   public String ToText() throws IOException{ // THis method returns a String.
	   
       this.pdfStripper = null;
       this.pdDoc = null;
       this.cosDoc = null;
       
       file = new File("file.pdf");
       parser = new PDFParser(new RandomAccessFile(file,"r"));// Opening the file for reading.
       
       parser.parse();
       cosDoc = parser.getDocument(); // Get the document.
       pdfStripper = new PDFTextStripper(); 
       pdDoc = new PDDocument(cosDoc);
       int n = pdDoc.getNumberOfPages();
       System.out.println(n);
       pdfStripper.setStartPage(1); //Setting the start page
       pdfStripper.setEndPage(5); // Setting the end page
       
       // if you want to get text from full pdf file use this code
       // pdfStripper.setEndPage(pdDoc.getNumberOfPages());
       
       Text = pdfStripper.getText(pdDoc); // Extracting Text and converting into a string.
       return Text;
   }

   
}