package edu.stevens;
/*
 * @author: Bonan Chen
 * extract attribute of circle with regex
 */
import java.util.regex.*;

public class parseLine extends parseSVG{
	private String x1="0",x2="0",y1="0",y2 = "0";
	public parseLine(String Line){
		super(Line);
	}
	public parseLine(String Line,String stroke,String fill,String strokeWidth,String opacity ,String fillOpacity,String strokeOpacity,String transform,String style){
		super(Line,stroke,fill,strokeWidth,opacity,fillOpacity,strokeOpacity,transform,style);	
	}
	public void parse(){
		//extract stroke, stroke-width, x1, y1, x2, y2, and style in SVG file
		Pattern p1 = Pattern.compile("\\s[Ss][Tt][Rr][Oo][Kk][Ee] *= *\"([^\"<>]*)\"");
		Pattern p2 = Pattern.compile("\\s[Ss][Tt][Rr][Oo][Kk][Ee]-[Ww][Ii][Dd][Tt][Hh] *= *\"([^\"<>]*)\"");
		Pattern p3 = Pattern.compile("\\sx1 *= *\"([^\"<>]*)\"");
		Pattern p4 = Pattern.compile("\\sy1 *= *\"([^\"<>]*)\"");
		Pattern p5 = Pattern.compile("\\sx2 *= *\"([^\"<>]*)\"");
		Pattern p6 = Pattern.compile("\\sy2 *= *\"([^\"<>]*)\"");
		Pattern p7 = Pattern.compile("\\sstyle *= *\"([^\"<>]*)\"");
		Matcher m1 = p1.matcher(Line);
		Matcher m2 = p2.matcher(Line);
		Matcher m3 = p3.matcher(Line);
		Matcher m4 = p4.matcher(Line);
		Matcher m5 = p5.matcher(Line);
		Matcher m6 = p6.matcher(Line);
		Matcher m7 = p7.matcher(Line);
		//save information extracted into variable
		if(m1.find())
			stroke = m1.group(1);
		if(m2.find())
			strokeWidth = m2.group(1);
		if(m3.find())
			x1 = m3.group(1);
		if(m4.find())
			y1 = m4.group(1);
		if(m5.find())
			x2 = m5.group(1);
		if(m6.find())
			y2 = m6.group(1);
		if(m7.find())
			style = m7.group(1);
	}
	//create get method to get the variable
	public String getX1(){
		return x1;
	}
	public String getX2(){
		return x2;
	}
	public String getY1(){
		return y1;
	}
	public String getY2(){
		return y2;
	}
	public String getStroke(){
		return stroke;
	}
	public String getStrokeWidth(){
		return strokeWidth;
	}
	public String getStyle(){
		return style;
	}
    public String getTransform(){
    	return transform;
    }
	public String toString(){
		return x1+" "+y1+" "+x2+" "+y2+" "+stroke+" "+strokeWidth+" ";
	}
}
