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
	/** Text to PS */
	public class PSFormatter {
	  /** The current input source */
	  protected BufferedReader br;
	  /** The current page number */
	  protected int pageNum;
	  /** The current X and Y on the page */
	  protected int curX, curY;
	  /** The current line number on page */
	  protected int lineNum;
	  /** The current tab setting */
	  protected int tabPos = 0;
	  public static final int INCH = 72;  // PS constant: 72 pts/inch

	  // Page parameters
	  /** The left margin indent */
	  protected int leftMargin = 50;
	  /** The top of page indent */
	  protected int topMargin = 750;
	  /** The bottom of page indent */
	  protected int botMargin = 50;

	  // FORMATTING PARAMETERS
	  protected int points = 12;
	  protected int leading = 14;

	/*  public static void main(String[] av) throws IOException {
	    if (av.length == 0) 
	      new PSFormatter(
	        new InputStreamReader(System.in)).process();
	    else for (int i = 0; i < av.length; i++) {
	      new PSFormatter(av[i]).process();
	    }
	  } */

	  public PSFormatter(String fileName) throws IOException {
	    br = new BufferedReader(new FileReader(fileName));
	  }

	  public PSFormatter(Reader in) throws IOException {
	    if (in instanceof BufferedReader)
	      br = (BufferedReader)in;
	    else
	      br = new BufferedReader(in);
	  }

	  /** Main processing of the current input source. */
	  protected void process() throws IOException {

	    String line;

	    prologue();      // emit PostScript prologue, once.

	    startPage();    // emit top-of-page (ending previous)

	    while ((line = br.readLine()) != null) {
	      if (line.startsWith("\f") || line.trim().equals(".bp")) {
	        startPage();
	        continue;
	      }
	      doLine(line);
	    }

	    // finish last page, if not already done.
	    if (lineNum != 0)
	      println("showpage");
	  }

	  /** Handle start of page details. */
	  protected void startPage() {
	    if (pageNum++ > 0)
	      println("showpage");
	    lineNum = 0;
	    moveTo(leftMargin, topMargin);
	  }

	  /** Process one line from the current input */
	  protected void doLine(String line) {
	    tabPos = 0;
	    // count leading (not imbedded) tabs.
	    for (int i=0; i<line.length(); i++) {
	      if (line.charAt(i)=='\t')
	        tabPos++;
	      else
	        break;
	    }
	    String l = line.trim(); // removes spaces AND tabs
	    if (l.length() == 0) {
	      ++lineNum;
	      return;
	    }
	    moveTo(leftMargin + (tabPos * INCH),
	      topMargin-(lineNum++ * leading));
	    println('(' + toPSString(l)+ ") show");

	    // If we just hit the bottom, start a new page
	    if (curY <= botMargin)
	      startPage();
	  }

	  /** Overly-simplistic conversion to PS, e.g., breaks on "foo\)bar" */
	  protected String toPSString(String o) {
	    StringBuffer sb = new StringBuffer();
	    for (int i=0; i<o.length(); i++) {
	      char c = o.charAt(i);
	      switch(c) {
	        case '(':  sb.append("\\("); break;
	        case ')':  sb.append("\\)"); break;
	        default:  sb.append(c); break;
	      }
	    }
	    return sb.toString();
	  }

	  protected void println(String s) {
	    System.out.println(s);
	  }

	  protected void moveTo(int x, int y) {
	    curX = x;
	    curY = y;
	    println(x + " " + y + " " + "moveto");
	  }

	  void prologue() {
	    println("%!PS-Adobe");
	    println("/Courier findfont " + points + " scalefont setfont ");
	  }
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
