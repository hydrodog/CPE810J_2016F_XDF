package edu.stevens;

import java.awt.Image;  
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
//read text from pdf; 
public class pdfExtract {

	public String importPDF() {
		   private PDFParser parser; // Parser for reading the file
		   private PDFTextStripper pdfStripper; // Extraction of text.
		   private PDDocument pdDoc ; // Set the no of pages to parse through.
		   private COSDocument cosDoc ; // Combining the parser along with the document.	   
		   private String Text ;
		   private String filePath;
		   private File file;

		    public importPDF() {
		        
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
//extract images from pdf; return java.awt.image;		   		
    public void toImage(){
        try {
            String sourceDir = "C:/Users/Xiaolu/Desktop/Java 810/Project/image";// Paste pdf files in PDFCopy folder to read
            String destinationDir = "C:/Users/Xiaolu/Desktop/Java 810/Project";
            File oldFile = new File(sourceDir);
            if (oldFile.exists()) {
            PDDocument document = PDDocument.load(oldFile);
            List<PDPage> list = document.getDocumentCatalog().getAllPages();
            String fileName = oldFile.getName().replace(".pdf", "_cover");
            int totalImages = 1;
            for (PDPage page : list) {
                PDResources pdResources = page.getResources();
                Map pageImages = pdResources.getXObjects();
                if (pageImages != null) {
                    Iterator imageIter = pageImages.keySet().iterator();
                    while (imageIter.hasNext()) {
                        String key = (String) imageIter.next();
                        PDXObjectImage pdxObjectImage = (PDXObjectImage) pageImages.get(key);
                        Image image = pdxObjectImage.getRGBImage();
                        totalImages++;
                    }
                }
            }
        } else {
            System.err.println("File not exists");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

