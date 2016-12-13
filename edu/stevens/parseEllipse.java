package edu.stevens.XDF._2dgraphics;
/*
 * @author:Bonan Chen
 * extract attribute of ellipse with regex
 */
import java.util.regex.*;

public class parseEllipse extends parseSVG {
	private String cx="0",cy="0",rx="0",ry="0";
	public parseEllipse(String Line){
		super(Line);
	}
	public parseEllipse(String Line,String stroke,String fill,String strokeWidth,String opacity ,String fillOpacity,String strokeOpacity,String transform,String style){
		super(Line,stroke,fill,strokeWidth,opacity,fillOpacity,strokeOpacity,transform,style);
	}
	public void parse(){
		Pattern p1 = Pattern.compile("\\s[Ss][Tt][Rr][Oo][Kk][Ee] *= *\"([^\"<>]*)\"");
		Pattern p2 = Pattern.compile("\\s[Ff][Ii][Ll][Ll] *= *\"([^\"<>]*)\"");
		Pattern p3 = Pattern.compile("\\s[Ss][Tt][Rr][Oo][Kk][Ee]-[Ww][Ii][Dd][Tt][Hh] *= *\"([^\"<>]*)\"");
		Pattern p4 = Pattern.compile("\\scx *= *\"([^\"<>]*)\"");
		Pattern p5 = Pattern.compile("\\scy *= *\"([^\"<>]*)\"");
		Pattern p6 = Pattern.compile("\\s[^\\-][Oo][Pp][Aa][Cc][Ii][Tt][Yy] *= *\"([^\"<>]*)\"");
		Pattern p7 = Pattern.compile("\\s[Ff][Ii][Ll][Ll]-[Oo][Pp][Aa][Cc][Ii][Tt][Yy] *= *\"([^\"<>]*)\"");
		Pattern p8 = Pattern.compile("\\s[Ss][Tt][Rr][Oo][Kk][Ee]-[Oo][Pp][Aa][Cc][Ii][Tt][Yy] *= *\"([^\"<>]*)\"");
		Pattern p9 = Pattern.compile("\\srx *= *\"([^\"<>]*)\"");
		Pattern p10 = Pattern.compile("\\sry *= *\"([^\"<>]*)\"");
		Pattern p11 = Pattern.compile("\\sstyle *= *\"([^\"<>]*)\"");
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
		if(m1.find())
			stroke = m1.group(1);
		if(m2.find())
			fill = m2.group(1);
		if(m3.find())
			strokeWidth = m3.group(1);
		if(m4.find())
			cx = m4.group(1);
		if(m5.find())
			cy = m5.group(1);
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
			style = m11.group(1);
	}
	public String getCx(){
		return cx;
	}
	public String getCy(){
		return cy;
	}
	public String getOpacity(){
		return opacity;
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
	public String getFill(){
		return fill;
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
		return style+" "+cx+" "+cy+" "+opacity+" "+fillOpacity+" "+strokeOpacity+" "+rx+" "+ry+" "+fill+" "+stroke+" "+strokeWidth+" ";
	}
}
