//author:Zhe Wang
//make image formats to eps format in order to make it print.
import java.util.*;  
import java.io.*;  
import java.awt.image.BufferedImage;  
import javax.imageio.*;  

public class Img2eps { 
     
	    /*************************************************************************** 
	     * Variables 
	     */  
	    private File input;  
	    private File output;  
	    private boolean verbose;  
	    private boolean indexed;  
	    private BufferedImage img;  
	    private Vector sortedColors = new Vector();  
	    private int repeatMark;  
	    private int lastPixel = -1;  
	    private int sequenceLen = 1;  
	    private HexWriter hw;  
	    private int resolution;  
	    private double scale = 1.0;  
	    private BufferedWriter fw;  
	      
	    /*************************************************************************** 
	     * Creates a new instance of Bmp2eps 
	     */  
	    public Img2eps(String input, String output, int res, boolean verbose) throws Exception {  
	        this.input = new File(input);  
	        this.output = new File(output);  
	        this.resolution = res;  
	        this.scale = res / 72.0;  
	        this.verbose = verbose;  
	    }  
	      
	    /**************************************************************************/  
	    public boolean doConversion() throws Exception {  
	        // read image  
	        if (verbose)  
	            System.out.println("Reading file '"+input.getName()+"'...");  
	        img = ImageIO.read(input);  
	        if (img == null) return false;  
	        // set parameters  
	        int colors = countUniqueColors();  
	        indexed = (colors <= 255);  
	        if (indexed) {  
	            repeatMark = 255;  
	            if (verbose)  
	                System.out.println("Generating indexed image with palette...");  
	        }  
	        else {  
	            repeatMark = 0x000001;  
	            if (verbose)  
	                System.out.println("Generating non-indexed image...");  
	        }  
	        // compress content  
	        compressContent();  
	        // write eps file  
	        if (verbose)  
	            System.out.println("Writing into file '"+output.getName()+"'...");  
	        FileWriter sfw = new FileWriter(output);  
	        fw = new BufferedWriter(sfw);  
	        writeProlog();  
	        if (indexed)  
	            hw.writeAll(fw, 1);  
	        else  
	            hw.writeAll(fw, 3);  
	        writeEpilog();  
	        fw.close();  
	        sfw.close();  
	        return true;  
	    }  
	      
	    /**************************************************************************/  
	    private int countUniqueColors() {  
	        Hashtable colors = new Hashtable();  
	          
	        // examine pixels  
	        for (int y=0,maxy=img.getHeight(); y<maxy ; y++) {  
	            for (int x=0,maxx=img.getWidth(); x<maxx ; x++) {  
	                // add color to table  
	                Integer clr = new Integer(img.getRGB(x, y) & 0xFFFFFF);  
	                Integer num = (Integer)colors.get(clr);  
	                if (num == null)  
	                    colors.put(clr, new Integer(1));  
	                else  
	                    colors.put(clr, new Integer(num.intValue() + 1));  
	            }  
	            if (colors.size() > 1024) break;  
	        }  
	        int colorsCount = colors.size();  
	          
	        // print statistics  
	        if (verbose) {  
	            if (colorsCount > 1024)  
	                System.out.println("More than 1024 unique colors.");  
	            else  
	                System.out.println("Unique colors = "+colorsCount);  
	        }  
	  
	        if (colorsCount <= 255) {  
	            Set elems = colors.entrySet();  
	            Iterator iter = elems.iterator();  
	            while (iter.hasNext()) {  
	                Map.Entry elem = (Map.Entry)iter.next();  
	                Integer col = (Integer)elem.getKey();  
	                //Integer count = (Integer)elem.getValue();  
	                //System.out.println("  "+Integer.toHexString(col.intValue())+": "+count);  
	                sortedColors.add(col);  
	            }  
	        }  
	          
	        colors.clear();  
	        return colorsCount;  
	    }  
	  
	    /**************************************************************************/  
	    private void compressContent() throws Exception {  
	        hw = new HexWriter(4096);  
	          
	        // examine pixels  
	        for (int y=0,maxy=img.getHeight(); y<maxy; y++) {  
	            for (int x=0,maxx=img.getWidth(); x<maxx; x++) {  
	                // add color to table  
	                int px = img.getRGB(x, y) & 0xFFFFFF;  
	                int out;  
	                if (indexed) {  
	                    out = sortedColors.indexOf(new Integer(px));  
	                    if (out < 0) throw new Exception("Internal error!");  
	                }  
	                else {  
	                    out = px;  
	                    if (out == 0x000001) out = 0;  
	                }  
	                putToCache(out);  
	            }  
	            endCaching();  
	        }  
	    }  
	      
	    /**************************************************************************/  
	    private void putToCache(int pixel) throws Exception {  
	        if (lastPixel == -1) {  
	            lastPixel = pixel;  
	            return;  
	        }  
	        if (pixel != lastPixel) {  
	            // different pixel than the previous  
	            if (sequenceLen <= 1) {  
	                // no sequence captured  
	                hw.putValue(lastPixel);  
	            }  
	            else {  
	                // some sequence captured  
	                if (sequenceLen >= 4) {  
	                    // the sequence is long enough  
	                    hw.putValue(repeatMark);  
	                    if (indexed) {  
	                        hw.putValue((sequenceLen >> 8) & 0xFF);  
	                        hw.putValue(sequenceLen & 0xFF);  
	                    }  
	                    else {  
	                        hw.putValue(sequenceLen);  
	                    }  
	                    hw.putValue(lastPixel);  
	                }  
	                else {  
	                    // the sequence is too short  
	                    for (int i=0; i<sequenceLen; i++) hw.putValue(lastPixel);  
	                }  
	                sequenceLen = 1;  
	            }  
	            lastPixel = pixel;  
	        }  
	        else {  
	            // the same pixel as the previous  
	            sequenceLen++;  
	        }  
	    }  
	  
	    /**************************************************************************/  
	    private void endCaching() throws Exception {  
	        if (sequenceLen <= 1) {  
	            // no sequence is pending  
	            hw.putValue(lastPixel);  
	        }  
	        else {  
	            // some pending sequence  
	            if (sequenceLen >= 4) {  
	                // the sequence is long enough  
	                hw.putValue(repeatMark);  
	                if (indexed) {  
	                    hw.putValue((sequenceLen >> 8) & 0xFF);  
	                    hw.putValue(sequenceLen & 0xFF);  
	                }  
	                else {  
	                    hw.putValue(sequenceLen);  
	                }  
	                hw.putValue(lastPixel);  
	            }  
	            else {  
	                // the sequence is too short  
	                for (int i=0; i<sequenceLen; i++) hw.putValue(lastPixel);  
	            }  
	        }  
	        sequenceLen = 1;  
	        lastPixel = -1;  
	  
	        hw.newLine();  
	    }  
	      
	    /**************************************************************************/  
	    private void wr(String str) throws Exception {  
	        fw.write(str);  
	        fw.newLine();  
	    }  
	      
	    /**************************************************************************/  
	    private void wrSkip() throws Exception {  
	        fw.newLine();  
	        fw.write("%------------------------------------------------------------------------------");  
	        fw.newLine();  
	    }  
	      
	    /**************************************************************************/  
	    private String twoDig(int val) {  
	        String res = Integer.toString(val);  
	        if (res.length() < 2) res = "0"+res;  
	        return res;  
	    }  
	      
	    private String today() {  
	        Calendar now = Calendar.getInstance();  
	        return "" +   
	            now.get(Calendar.YEAR) + "-" +  
	            twoDig(now.get(Calendar.MONTH)+1) + "-" +  
	            twoDig(now.get(Calendar.DAY_OF_MONTH)) + " " +  
	            twoDig(now.get(Calendar.HOUR_OF_DAY)) + ":" +  
	            twoDig(now.get(Calendar.MINUTE)) + ":" +  
	            twoDig(now.get(Calendar.SECOND));  
	    }  
	      
	    /**************************************************************************/  
	    private void writeProlog() throws Exception {  
	        // header  
	        int bbw = (int)(img.getWidth() / scale);  
	        int bbh = (int)(img.getHeight() / scale);  
	        wr("%!PS-Adobe-2.0");  
	        wr("%%Creator: (Img2eps "+")");  
	        wr("%%Title: (Image)");  
	        wr("%%CreationDate: ("+today()+")");  
	        wr("%%BoundingBox: 0 0 "+bbw+" "+bbh);  
	        wr("%%HiResBoundingBox: 0 0 "+bbw+" "+bbh);  
	        wr("%%DocumentData: Clean7Bit");  
	        wr("%%LanguageLevel: 2");  
	        wrSkip();  
	  
	        if (indexed) {  
	            // store palette  
	            wr("/pall [");  
	            for (int i=0,maxi=sortedColors.size(); i<maxi; i++) {  
	                if ((i > 0) && (i % 8 == 0)) fw.newLine();  
	                Integer col = (Integer)sortedColors.get(i);  
	                String item = Integer.toHexString(col.intValue());  
	                while (item.length() < 6) item = "0" + item;  
	                fw.write("<"+item+">");  
	            }  
	            fw.newLine();  
	            wr("] def");  
	            wrSkip();  
	        }  
	          
	        // prolog for image  
	        wr("/img [");  
	    }  
	      
	    /**************************************************************************/  
	    private void writeEpilog() throws Exception {  
	        int width = img.getWidth();  
	        int height = img.getHeight();  
	          
	        // epilog for image  
	        wr("] def");  
	        wrSkip();  
	          
	        wr("/lineLen "+width+" 3 mul def");  
	        wr("/lineNo 0 def");  
	        wrSkip();  
	  
	        wr("/coded 0 def");  
	        wr("/codedPos 0 def");  
	        wr("/codedMaxPos 0 def");  
	        wr("/rd {");  
	        if (indexed) {  
	            wr("  coded codedPos get");  
	            wr("  /codedPos codedPos 1 add def");  
	        }  
	        else {  
	            wr("  coded codedPos 3 getinterval");  
	            wr("  /codedPos codedPos 3 add def");  
	        }  
	        wr("} bind def");  
	        wrSkip();  
	  
	        wr("/pixels 0 def");  
	        wr("/pixelsPos 0 def");  
	        wr("/wr {");  
	        if (indexed) {  
	            wr("  pall exch get /rgbColor exch def");  
	            wr("  pixels pixelsPos rgbColor putinterval");  
	        }  
	        else {  
	            wr("  pixels exch pixelsPos exch putinterval");  
	        }  
	        wr("  /pixelsPos pixelsPos 3 add def");  
	        wr("} bind def");  
	        wrSkip();  
	  
	        if (!indexed) {  
	            wr("/bin2int {");  
	            wr("  /origStr exch def");  
	            wr("  origStr 0 get 65536 mul");  
	            wr("  origStr 1 get 256 mul");  
	            wr("  origStr 2 get");  
	            wr("  add");  
	            wr("  add");  
	            wr("} bind def");  
	            wrSkip();  
	        }  
	          
	        wr("/pixels lineLen string def");  
	        wr("");  
	        wr("/decodeLine {");  
	        wr("  /pixelsPos 0 def");  
	        wr("  /coded img lineNo get def");  
	        wr("  /codedPos 0 def");  
	        wr("  /codedMaxPos coded length def");  
	        wr("  {");  
	        wr("    codedPos codedMaxPos eq {");  
	        wr("      /lineNo lineNo 1 add def");  
	        wr("      pixels exit");  
	        wr("    } if");  
	        wr("    /what rd def");  
	        if (indexed) {  
	            wr("    what 255 eq");  
	        }  
	        else {  
	            wr("    what 0 get 0 eq");  
	            wr("    what 1 get 0 eq");  
	            wr("    what 2 get 1 eq");  
	            wr("    and");  
	            wr("    and");  
	        }  
	        wr("    {");  
	        if (indexed) {  
	            wr("      1 1 rd 256 mul rd add");  
	        }  
	        else {  
	            wr("      1 1 rd bin2int");  
	        }  
	        wr("      /what rd def");  
	        wr("      {");  
	        wr("        pop");  
	        wr("        what wr");  
	        wr("      } bind for");  
	        wr("    }");  
	        wr("    {");  
	        wr("      what wr");  
	        wr("    } ifelse");  
	        wr("  } bind loop");  
	        wr("} bind def");  
	        wrSkip();  
	  
	        int bbw = (int)(width / scale);  
	        int bbh = (int)(height / scale);  
	  
	        wr("/drawImage {");  
	        wr("  /Times-Roman findfont 14 scalefont setfont");  
	        wr("  gsave");  
	        wr("  "+bbw+" "+bbh+" scale");  
	        wr("  "+width+" "+height+" 8 ["+width+" 0 0 -"+height+" 0 "+height+"] { decodeLine } false 3 colorimage");  
	        wr("  grestore");  
	        wr("} bind def");  
	        wrSkip();  
	  
	        wr("drawImage");  
	        wr("showpage");  
	        wr("%%Trailer");  
	    }  
	      
	    /**************************************************************************/  
	    private static void usage() {  
	        System.out.println("Usage:");  
	        System.out.println("  [-rRRR] filename.xxx filename.eps");  
	        System.out.println();  
	        System.out.println("-rRRR (optional) specifies resolution of output image in pixels/inch");  
	        System.out.println("Default value is 90 pixels/inch.");  
	        System.out.println();  
	        System.out.println("Example:");  
	        System.out.println("  -r150 pic.png pic.eps");  
	        System.out.println();  
	        fileFormats();  
	    }  
	      
	    /**************************************************************************/  
	    private static void fileFormats() {  
	        System.out.println("Supported file formats:");  
	        String[] formats = ImageIO.getReaderFormatNames();  
	        for (int i=0,maxi=formats.length; i<maxi; i++)  
	            System.out.println("  "+formats[i]);  
	        System.out.println();  
	    }  
	      
	    /**************************************************************************/  
	    public static void main(String[] args) throws Exception {  
	        // intro  
	        System.out.println();  
	        System.out.println("Img2Eps converter");  
	        System.out.println();  
	        // arguments  
	        if (args.length < 2 || args.length > 3) {  
	            usage();  
	            System.exit(-1);  
	        }  
	        String input;  
	        String output;  
	        int res = 90;  
	        // options  
	        if (args.length > 2) {  
	            if (!args[0].startsWith("-r")) {  
	                System.out.println("Unrecognized option: "+args[0]);  
	                usage();  
	                System.exit(-2);  
	            }  
	            try {  
	                res = Integer.parseInt(args[0].substring(2));  
	                if (res <= 0) throw new Exception();  
	            }  
	            catch (Exception e) {  
	                System.out.println("Bad argument value! Resolution must be positive integer!");  
	                System.exit(-2);  
	            }  
	            input = args[1];  
	            output = args[2];  
	        }  
	        else {  
	            input = args[0];  
	            output = args[1];  
	        }  
	        // run conversion  
	        Img2eps me = new Img2eps(input, output, res, true);
	        if (!me.doConversion()) {  
	            System.out.println("Input file format not supported!");  
	            System.out.println();  
	            fileFormats();  
	            System.exit(-2);  
	        }  
	        System.out.println("Done!");  
	    }  
	      
}
