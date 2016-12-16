package edu.stevens;
/*
 * @author: Bonan Chen
 * extract attribute of path with regex
 */
import java.util.regex.*;

public class parsePath extends parseSVG{
	private String d="none";
	public parsePath(String Line){
		super(Line);
	}
	public parsePath(String Line,String stroke,String fill,String strokeWidth,String opacity ,String fillOpacity,String strokeOpacity,String transform,String style){
		super(Line,stroke,fill,strokeWidth,opacity,fillOpacity,strokeOpacity,transform,style);	
	}
	public void parse(){
		//extract d, fill, stroke, stroke-width, opacity, fill-opacity, stroke-opacity, and style in SVG file
		Pattern p1 = Pattern.compile("\\sd *= *\"([^\"<>]*)\"");
		Pattern p2 = Pattern.compile("\\s[Ff][Ii][Ll][Ll] *= *\"([^\"<>]*)\"");
		Pattern p3 = Pattern.compile("\\s[Ss][Tt][Rr][Oo][Kk][Ee]-[Ww][Ii][Dd][Tt][Hh] *= *\"([^\"<>]*)\"");
		Pattern p4 = Pattern.compile("\\s[Ss][Tt][Rr][Oo][Kk][Ee] *= *\"([^\"<>]*)\"");
		Pattern p5 = Pattern.compile("\\s[Oo][Pp][Aa][Cc][Ii][Tt][Yy] *= *\"([^\"<>]*)\"");
		Pattern p6 = Pattern.compile("\\s[Ff][Ii][Ll][Ll]-[Oo][Pp][Aa][Cc][Ii][Tt][Yy] *= *\"([^\"<>]*)\"");
		Pattern p7 = Pattern.compile("\\s[Ss][Tt][Rr][Oo][Kk][Ee]-[Oo][Pp][Aa][Cc][Ii][Tt][Yy] *= *\"([^\"<>]*)\"");
		Pattern p8 = Pattern.compile("\\sstyle *= *\"([^\"<>]*)\"");
		Matcher m1 = p1.matcher(Line);
		Matcher m2 = p2.matcher(Line);
		Matcher m3 = p3.matcher(Line);
		Matcher m4 = p4.matcher(Line);
		Matcher m5 = p5.matcher(Line);
		Matcher m6 = p6.matcher(Line);
		Matcher m7 = p7.matcher(Line);
		Matcher m8 = p8.matcher(Line);
		//save information extracted into variable
		if(m1.find())
			d = m1.group(1);
		if(m2.find())
			fill = m2.group(1);
		if(m3.find())
			strokeWidth = m3.group(1);
		if(m4.find())
			stroke = m4.group(1);
		if(m5.find())
			opacity = m5.group(1);
		if(m6.find())
			fillOpacity = m6.group(1);
		if(m7.find())
			strokeOpacity = m7.group(1);
		if(m8.find())
			style = m8.group(1);
	}
	//create get method to get the variables
	public String getD(){
		return d;
	}
	public String getStroke(){
		return stroke;
	}
	public String getFill(){
		return fill;
	}
	public String getStrokeWidth(){
		return strokeWidth;
	}
	public String getFillOpacity(){
		return fillOpacity;
	}
	public String getOpacity(){
		return opacity;
	}
	public String getStrokeOpacity(){
		return strokeOpacity;
	}
	public String getStyle(){
		return style;
	}
	public String getTransform(){
		return transform;
	}
	public String toString(){
		return d+stroke+fill+strokeWidth+fillOpacity+strokeOpacity+opacity;
	}
}
