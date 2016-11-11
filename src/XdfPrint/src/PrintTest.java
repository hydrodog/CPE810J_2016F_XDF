//author:Zhe Wang


//make a print test to make sure that the file could be printed out and could choose printer

import java.io.*; 
import javax.print.*; 
import javax.print.attribute.*; 

public class PrintTest{ 
	public static void main(String args[]){ 
		FileInputStream psStream = null; 
		try { 
			psStream = new FileInputStream("test.pdf"); 
		} catch (FileNotFoundException ffne) { 
			ffne.printStackTrace(); 
		} 
		if (psStream == null) { 
			return; 
		} 
		DocFlavor psInFormat = DocFlavor.INPUT_STREAM.AUTOSENSE; 
		Doc myDoc = new SimpleDoc(psStream, psInFormat, null); 
		PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet(); 
		PrintService[] services = PrintServiceLookup.lookupPrintServices(psInFormat, aset); 
		//if there are several printers configured 
		PrintService myPrinter = null; 
		for (int i = 0; i < services.length; i++){ 
			String svcName = services[i].toString(); 
			System.out.println("service found: "+svcName); 
			if (svcName.contains("my local printer name")){ 
				myPrinter = services[i]; 
				System.out.println("my printer found: "+svcName); 
				break; 
			} 
		} 
		if (myPrinter != null) { 
			DocPrintJob job = myPrinter.createPrintJob(); 
			try { 
				job.print(myDoc, aset); 

			} catch (Exception pe) {pe.printStackTrace();} 
		} else { 
			System.out.println("no printer services found" ); 
		} 
	} 
	//to do: convert to postscript when printing

} 