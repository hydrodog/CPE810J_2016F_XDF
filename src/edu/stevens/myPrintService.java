package edu.stevens;

import java.awt.*;
import java.io.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import javax.print.event.*;
import javax.print.*;
import javax.swing.*;

public class myPrintService {
	/*the constructor of the service*/
	//TODO: may be we should add a method which is used to communicate with GUI and service 
	public myPrintService(){
		
	}
	//use the ghost4j
	public void convertTxt2Ps(){
		
	}
	
	public void convertImg2ps(){
		
	}
	
	public void getService(){
		
	}
	
	
	public void getPrint(){
	    /* This is a test for printer, some setting are not load
         * The print data is Postscript which will be supplied as a stream
         * Setting is A4, and 2 copies are to be printed
         */
        DocFlavor flavor = DocFlavor.INPUT_STREAM.POSTSCRIPT;
        PrintRequestAttributeSet aset = 
                new HashPrintRequestAttributeSet();
        aset.add(MediaSizeName.ISO_A4);
        aset.add(new Copies(2));
        aset.add(Sides.TWO_SIDED_LONG_EDGE);
        aset.add(Finishings.STAPLE);

        /* locate a print service that can handle it */
        PrintService[] pservices =
                PrintServiceLookup.lookupPrintServices(flavor, aset);
        if (pservices.length > 0) {
                System.out.println("selected printer " + pservices[0].getName());

                /* create a print job for the chosen service */
                DocPrintJob pj = pservices[0].createPrintJob();
                try {
                        /* 
                        * Create a Doc object to hold the print data.
                        * Since the data is postscript located in a disk file,
                        * an input stream needs to be obtained
                        * BasicDoc is a useful implementation that will if requested
                        * close the stream when printing is completed.
                        */
                        FileInputStream fis = new FileInputStream("example.ps");
                        Doc doc = new SimpleDoc(fis, flavor, null);

                        /* print the doc as specified */
                        pj.print(doc, aset);

                        /*
                        * Do not explicitly call System.exit() when print returns.
                        * Printing can be asynchronous so may be executing in a
                        * separate thread.
                        * If you want to explicitly exit the VM, use a print job 
                        * listener to be notified when it is safe to do so.
                        */

                } catch (IOException ie) { 
                        System.err.println(ie);
                } catch (PrintException e) { 
                        System.err.println(e);
                }
        }
	}
}
