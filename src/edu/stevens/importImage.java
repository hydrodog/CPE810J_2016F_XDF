package edu.stevens;
/*
 * @ Explanation:  
 *   1. Install PDFbox library
 *   2. Read the file
 */
import java.io.File;     
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.Observer;

import org.apache.pdfbox.PDFToImage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;

public class importImage {
   public static int extract( List< File > files, File FileName, Observer observer ) {
	 FileName.mkdirs();
	 int done = 0;
     for( final File file : files ) {
		 try {
		      final File   target   = new File( FileName, file.getName());// create an object target of pdf files
		      final String trgtPath = target.getPath();// read the path
		      final String prefix   = trgtPath.substring( 0, trgtPath.lastIndexOf( '.' ));
		      PDImage.main( new String[]{ "-outputPrefix", prefix, file.getPath() });
		      final double percent  = (100.0 * ++done ) / files.size();
		      System.out.printf( "%6.2f %%: %s\n", percent, file.getName());
		          if( observer != null ) {
		               observer.update( null, file );
		            }
		         }
		         catch( final Throwable t ) {
		            System.err.println( file.getPath());
		            t.printStackTrace();
		         }
		      }
		      return done;
		   }
   public static void main( String[] args ) {
		if( args.length != 2 ) {
		    System.err.println( "usage: java -jar pdf2img.jar <PDF directory> <JPEG directory>" );
		         System.exit(1);
		   }
		final File   pdfDir  = new File( args[0] );
		final File   jpegDir = new File( args[1] );
		final File[] files   = pdfDir.listFiles( new FilenameFilter() {
		public boolean accept( File dir, String name ) {
		return name.toLowerCase().endsWith( ".pdf" );
   }});
		 if( files != null ) {
		    final int done = extract( Arrays.asList( files ), jpegDir, null );
		    System.out.printf("\n%d file%s processed.", done, ( done > 1 ) ? "s" : "" );
		      }
		   }
		}

