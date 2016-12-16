package edu.stevens;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class PrintService {
   public static void main(String[] arg) throws Exception{
	   try {
		   printcode aa=new printcode();
		   FileOutputStream f = new FileOutputStream("printfile.ps");
		   BufferedWriter out = new BufferedWriter(new FileWriter
			         ("printfile.ps",true));
		   out.write("%!PS-Adobe-3.0\n"+
					  " %%BoundingBox: 50 50 950 550\n"+
					   "%%DocumentData: Clean7Bit\n"+
	"%%Orientation: Landscape\n"+
	"%%Pages: 1\n"+
	"%%PageOrder: Ascend\n"+
	"%%DocumentMedia: Legal 1008 612 0 () ()\n"+
	"%%DocumentNeededResources\n"+
	"%%DocumentProcessColors: Color\n"+
	"%%EndComments\n"+

	"%%BeginSetup\n"+
	"%%EndSetup\n"+
	"%%Page: (1) 1\n"+
	"%%BeginPageSetup\n"+
	"<< /PageSize [1224 792] >> setpagedevice\n"+
	"<< /MaxOpStack 255000 >> setuserparams\n"+
	"%%EndPageSetup\n");
		   out.close();
	   }
	   catch (IOException e) {
	       System.out.println("exception occoured"+ e);
	   }
	   Text t=new Text("hello world","Helvetica","288","720","12","1 0.1 0.1");
	   Line l= new Line("400","720","800","50","0.1","2");
	   Circle c = new Circle("400","720","30","0.1 1 0.1","4");
	   Ellipse e = new Ellipse("400","900","500","850","500","950","600","900","1 1 0.5","9");
	   Rect r = new Rect("200","200","250","300","0.5 0.2 0.2","0.5 0.1 0.2","2");
	   e.paint();
	   c.paint();
	   t.show();
	   l.paint();
	   r.paint();
	   
	   BufferedWriter out = new BufferedWriter(new FileWriter
		         ("printfile.ps",true));
	   out.write("%%EOF");
	   out.close();
	 
   }
}
