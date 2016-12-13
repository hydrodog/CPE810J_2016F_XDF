package edu.stevens.XDF._2dgraphics;
/*
 * extract attribute of path with regex
 */
import java.util.regex.*;

public class parsePoly extends parseSVG{
	private String points="none",fillRule = "nonzero";
	public parsePoly(String Line){
		super(Line);
	}
	public parsePoly(String Line,String stroke,String fill,String strokeWidth,String opacity ,String fillOpacity,String strokeOpacity,String transform,String style){
		super(Line,stroke,fill,strokeWidth,opacity,fillOpacity,strokeOpacity,transform,style);	
	}
	public void parse(){
		Pattern p1 = Pattern.compile("\\spoints *= *\"([^\"<>]*)\"");
		Pattern p2 = Pattern.compile("\\s[Ff][Ii][Ll][Ll] *= *\"([^\"<>]*)\"");
		Pattern p3 = Pattern.compile("\\s[Ss][Tt][Rr][Oo][Kk][Ee]-[Ww][Ii][Dd][Tt][Hh] *= *\"([^\"<>]*)\"");
		Pattern p5 = Pattern.compile("\\s[^-][Oo][Pp][Aa][Cc][Ii][Tt][Yy] *= *\"([^\"<>]*)\"");
		Pattern p6 = Pattern.compile("\\s[Ff][Ii][Ll][Ll]-[Oo][Pp][Aa][Cc][Ii][Tt][Yy] *= *\"([^\"<>]*)\"");
		Pattern p7 = Pattern.compile("\\s[Ss][Tt][Rr][Oo][Kk][Ee]-[Oo][Pp][Aa][Cc][Ii][Tt][Yy] *= *\"([^\"<>]*)\"");
		Pattern p4 = Pattern.compile("\\s[Ss][Tt][Rr][Oo][Kk][Ee] *= *\"([^\"<>]*)\"");
		Pattern p8 = Pattern.compile("\\s[Ff][Ii][Ll][Ll]-[Rr][Uu][Ll][Ee] *= *\"([^\"<>]*)\"");
		Pattern p9 = Pattern.compile("\\sstyle *= *\"([^\"<>]*)\"");
		Matcher m1 = p1.matcher(Line);
		Matcher m2 = p2.matcher(Line);
		Matcher m3 = p3.matcher(Line);
		Matcher m4 = p4.matcher(Line);
		Matcher m5 = p5.matcher(Line);
		Matcher m6 = p6.matcher(Line);
		Matcher m7 = p7.matcher(Line);
		Matcher m8 = p8.matcher(Line);
		Matcher m9 = p9.matcher(Line);
		if(m1.find())
			points = m1.group(1);
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
			fillRule = m8.group(1);
		if(m9.find())
			style = m9.group(1);
	}
	public String getPoints(){
		return points;
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
	public String getFillRule(){
		return fillRule;
	}
	public String getStyle(){
		return style;
	}
	public String getTransform(){
		return transform;
	}
	public String toString(){ 
		return "impoly"+" "+style+" "+points+" "+stroke+" "+fill+" "+strokeWidth+" "+fillOpacity+" "+strokeOpacity+" "+opacity+" "+fillRule;
	}
}
