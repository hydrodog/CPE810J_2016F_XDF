package edu.stevens.XDF._2dgraphics;
/*
 * extract attributes of rectangle with regex
 */
import java.util.regex.*;

public class parseRect extends parseSVG{
	private String x="0",y="0",width="0",height="0",rx="0",ry="0";
	public parseRect(String Line){
		super(Line);
	}
	public parseRect(String Line,String stroke,String fill,String strokeWidth,String opacity ,String fillOpacity,String strokeOpacity,String transform,String style){
		super(Line,stroke,fill,strokeWidth,opacity,fillOpacity,strokeOpacity,transform,style);	
	}
	public String getX(){
		return x;
	}
	public String getY(){
		return y;
	}
	public String getOpacity(){
		return opacity;
	}
	public String getWidth(){
		return width;
	}
	public String getHeight(){
		return height;
	}
	public String getFillOpacity(){
		return fillOpacity;
	}
	public String getStrokeOpacity(){
		return strokeOpacity;
	}
	public String getRx(){
		return rx;
	}
	public String getRy(){
		return ry;
	}
	public String getStroke(){
		return stroke;
	}
	public String getFill(){
		return fill;
	}
	public String getStrokewidth(){
		return strokeWidth;
	}
	public String getStyle(){
		return style;
	}
	public String getTransform(){
		return transform;
	}
	public void parse(){
		Pattern p1 = Pattern.compile("\\swidth *= *\"([^\"<>]*)\"");
		Pattern p2 = Pattern.compile("\\s[Ff][Ii][Ll][Ll] *= *\"([^\"<>]*)\"");
		Pattern p3 = Pattern.compile("\\s[Ss][Tt][Rr][Oo][Kk][Ee]-[Ww][Ii][Dd][Tt][Hh] *= *\"([^\"<>]*)\"");
		Pattern p4 = Pattern.compile("\\sx *= *\"([^\"<>]*)\"");
		Pattern p5 = Pattern.compile("\\sy *= *\"([^\"<>]*)\"");
		Pattern p6 = Pattern.compile("\\s[^\\-][Oo][Pp][Aa][Cc][Ii][Tt][Yy] *= *\"([^\"<>]*)\"");
		Pattern p7 = Pattern.compile("\\s[Ff][Ii][Ll][Ll]-[Oo][Pp][Aa][Cc][Ii][Tt][Yy] *= *\"([^\"<>]*)\"");
		Pattern p8 = Pattern.compile("\\s[Ss][Tt][Rr][Oo][Kk][Ee]-[Oo][Pp][Aa][Cc][Ii][Tt][Yy] *= *\"([^\"<>]*)\"");
		Pattern p9 = Pattern.compile("\\srx *= *\"([^\"<>]*)\"");
		Pattern p10 = Pattern.compile("\\sry *= *\"([^\"<>]*)\"");
		Pattern p11 = Pattern.compile("\\s[Ss][Tt][Rr][Oo][Kk][Ee] *= *\"([^\"<>]*)\"");
		Pattern p12 = Pattern.compile("\\sheight *= *\"([^\"<>]*)\"");
		Pattern p13 = Pattern.compile("\\sstyle *= *\"([^\"<>]*)\"");
		Matcher m1 = p1.matcher(Line);
		Matcher m2 = p2.matcher(Line);
		Matcher m3 = p3.matcher(Line);
		Matcher m4 = p4.matcher(Line);
		Matcher m5 = p5.matcher(Line);
		Matcher m6 = p6.matcher(Line);
		Matcher m7 = p7.matcher(Line);
		Matcher m8 = p8.matcher(Line);
		Matcher m9 = p9.matcher(Line);
		Matcher m10 = p10.matcher(Line);
		Matcher m11 = p11.matcher(Line);
		Matcher m12 = p12.matcher(Line);
		Matcher m13 = p13.matcher(Line);
		if(m1.find())
			width = m1.group(1);
		if(m2.find()){
			fill = m2.group(1);
		}
		if(m3.find())
			strokeWidth = m3.group(1);
		if(m4.find())
			x = m4.group(1);
		if(m5.find())
			y = m5.group(1);
		if(m6.find())
			opacity = m6.group(1);
		if(m7.find())
			fillOpacity = m7.group(1);
		if(m8.find())
			strokeOpacity = m8.group(1);
		if(m9.find())
			rx = m9.group(1);
		if(m10.find())
			ry = m10.group(1);
		if(m11.find())
		    stroke = m11.group(1);
		if(m12.find())
			height = m12.group(1);
		if(m13.find())
			style = m13.group(1);
	}
	public String toString(){
		return style+" "+x+" "+y+" "+opacity+" "+width+" "+height+" "+fillOpacity+" "+strokeOpacity+" "+rx+" "+ry+" "+fill+" "+stroke+" "+strokeWidth+" ";
	}
}
