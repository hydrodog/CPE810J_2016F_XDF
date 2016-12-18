package edu.stevens;

import javax.print.*;

import javax.print.PrintService;
import javax.print.attribute.*;
import javax.swing.JFileChooser;

import java.io.*;

public class printcode {
	        JFileChooser fileChooser = new JFileChooser(); // create print job  
	        int state = fileChooser.showOpenDialog(null);  
	        {
	        if (state == JFileChooser.APPROVE_OPTION) {  
	            File file = fileChooser.getSelectedFile(); // choose file 
	            //Builds a set of print request properties  
	            HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();  
	            //Set the print format, because the type is not determined, so select autosense  
	            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;  
	            // Find all the available print services 
	            PrintService[] printService = PrintServiceLookup.lookupPrintServices(flavor, pras);  
	            // Locates the default print service  
	            PrintService defaultService = PrintServiceLookup  
	                    .lookupDefaultPrintService();  
	            //The Print dialog box is displayed
	            PrintService service = ServiceUI.printDialog(null, 800, 800,  
	                    printService, defaultService, flavor, pras);  
	           // System.out.print(service.getSupportedAttributeCategories());
	            if (service != null) {  
	                try {  
	                    DocPrintJob job = service.createPrintJob(); //Create a print job 
	                    FileInputStream fis = new FileInputStream(file); // Constructs a stream of files to be printed 
	                    DocAttributeSet das = new HashDocAttributeSet();  
	                    Doc doc = new SimpleDoc(fis, flavor, das);  
	                    job.print(doc, pras);  
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }  
   }
}
