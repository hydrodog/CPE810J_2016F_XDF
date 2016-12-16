package edu.stevens;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Title {
	private String bx1,bx2,by1,by2,DocumentData,Orientation,Page,PageOrder,m1
					,m2,m3,DocumentProcessColor,PSx,PSy,MaxOpStack;
	public Title(String bx1,String bx2,String by1,String by2,String DocumentData,
				String Orientation,String Page,String PageOrder,String m1,String m2,String m3,
				String DocumentProcessColor,String PSx,String PSy,String MaxOpStack){
					this.bx1=bx1;
					this.bx2=bx2;
					this.by1=by1;
					this.by2=by2;
					this.DocumentData=DocumentData;
					this.Orientation=Orientation;
					this.Page=Page;
					this.PageOrder=PageOrder;
					this.m1=m1;
					this.m2=m2;
					this.m3=m3;
					this.DocumentProcessColor=DocumentProcessColor;
					this.PSx=PSx;
					this.PSy=PSy;
					this.MaxOpStack=MaxOpStack;
	}
					public void show() throws Exception {
						 try {
							 FileOutputStream f = new FileOutputStream("printfile.ps");
					         BufferedWriter out = new BufferedWriter(new FileWriter
					         ("printfile.ps",true));
					         out.write("%!PS-Adobe-3.0\n"+
									   "%%BoundingBox: " + bx1+ " " + bx2 + " "+ by1 + " " + by2 +"\n"+
									   "%%DocumentData: Clean" + DocumentData + "Bit\n"+
									   "%%Orientation: " + Orientation + "\n"+
									   "%%Pages: "+ Page + "\n"+
									   "%%PageOrder: "+ PageOrder + "\n"+
									   "%%DocumentMedia: Legal "+ m1 + " " + m2+ " " + m3 +" () ()\n"+
									   "%%DocumentNeededResources\n"+
									   "%%DocumentProcessColors: " + DocumentProcessColor +"\n"+
									   "%%EndComments\n"+

									   "%%BeginSetup\n"+
									   "%%EndSetup\n"+
									   "%%Page: (" + Page +")" + " " + Page + "\n"+
									   "%%BeginPageSetup\n"+
									   "<< /PageSize [" + PSx + " " + PSy + "] >> setpagedevice\n"+
									   "<< /MaxOpStack "+ MaxOpStack + " >> setuserparams\n"+
					        		   "%%EndPageSetup\n");
					         		   out.close();
						 	}
						 	catch (IOException e) {
					        System.out.println("exception occoured"+ e);
					      }
					}
				}
