package edu.stevens;
/*
 * @author: Bonan Chen
 * extract attributes of SVG root with regex
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class parseRoot extends parseSVG{
	private String width="0",height="0",viewbox="0 0 0 0";
	public parseRoot(String Line){
		super(Line);
	}
	public void parse() {
		//extract width, height, and viewbox in SVG file
		Pattern p1 = Pattern.compile("\\s[Ww][Ii][Dd][Tt][Hh] *= *\"([^\"<>]*)\"");
		Pattern p2 = Pattern.compile("\\s[Hh][Ee][Ii][Gg][Hh][Tt] *= *\"([^\"<>]*)\"");
		Pattern p3 = Pattern.compile("\\s[Vv][Ii][Ee][Ww][Bb][Oo][Xx] *= *\"([^\"<>]*)\"");
		Matcher m1 = p1.matcher(Line);
		Matcher m2 = p2.matcher(Line);
		Matcher m3 = p3.matcher(Line);
		//save information extracted into variable
		if(m1.find())
			width = m1.group(1);
		if(m2.find())
			height = m2.group(1);
		if(m3.find())
			viewbox = m3.group(1);
	}
	//create get method to get the variables
	public String getWidth(){
		return width;
	}
	public String getHeight(){
		return height;
	}
	public String getViewbox(){
		return viewbox;
	}
	public String toString(){
		return width+" "+height+" "+viewbox+" ";
	}
}
