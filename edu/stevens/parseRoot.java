package edu.stevens.XDF._2dgraphics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class parseRoot extends parseSVG{
	private String width="0",height="0",viewbox="none",enablebackground="none";
	public parseRoot(String Line){
		super(Line);
	}
	public void parse() {
		Pattern p1 = Pattern.compile("\\s[Ww][Ii][dD][tT][hH] *= *\"([^\"<>]*)\"");
		Pattern p2 = Pattern.compile("\\s[Hh][Ee][Ii][Gg][Hh][Tt] *= *\"([^\"<>]*)\"");
		Pattern p3 = Pattern.compile("\\s[Vv][Ii][Ee][Ww][Bb][Oo][Xx] *= *\"([^\"<>]*)\"");
		Pattern p4 = Pattern.compile("\\s[Ee][Nn][Aa][Bb][Ll][Ee]-[Bb][Aa][Cc][Kk][Gg][Rr][Oo][Uu][Nn][Dd] *= *\"([^\"<>]*)\"");
		Matcher m1 = p1.matcher(Line);
		Matcher m2 = p2.matcher(Line);
		Matcher m3 = p3.matcher(Line);
		Matcher m4 = p4.matcher(Line);
		if(m1.find())
			width = m1.group(1);
		if(m2.find())
			height = m2.group(1);
		if(m3.find())
			viewbox = m3.group(1);
		if(m4.find())
			enablebackground = m4.group(1);
	}
	public String getWidth(){
		return width;
	}
	public String getHeight(){
		return height;
	}
	public String getViewbox(){
		return viewbox;
	}
	public String getEnablebackground(){
		return enablebackground;
	}
	
}
