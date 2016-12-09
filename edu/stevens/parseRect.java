package edu.stevens;
/*
 * @author:Bonan Chen
 * extract attributes of rectangle with regex
 */
import java.util.regex.*;

public class parseRect extends parseSVG{
	private String x="0",y="0",opacity="1",width="0",height="0",fillOpacity="1",strokeOpacity="1",rx="0",ry="0",fill="black",stroke="none",strokeWidth = "0";
	public parseRect(String Line){
		super(Line);
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
	public void parse(){
		Pattern p1 = Pattern.compile("width *= *\"([0-9]*\\.?[0-9]*)\"");
		Pattern p2 = Pattern.compile("[Ff][Ii][Ll][Ll] *: *([Rr][Gg][Bb]\\( *[0-9]* *, *[0-9]* *, *[0-9]* *\\))|[Ff][Ii][Ll][Ll]: *([A-Za-z]+) *[;\"]");
		Pattern p3 = Pattern.compile("[Ss][Tt][Rr][Oo][Kk][Ee]-[Ww][Ii][Dd][Tt][Hh]: *([0-9]*\\.?[0-9]*)");
		Pattern p4 = Pattern.compile("x *= *\"([0-9]*\\.?[0-9]*)\"");
		Pattern p5 = Pattern.compile("y *= *\"([0-9]*\\.?[0-9]*)\"");
		Pattern p6 = Pattern.compile("[^-][Oo][Pp][Aa][Cc][Ii][Tt][Yy] *: *([0-9]*\\.?[0-9]*)");
		Pattern p7 = Pattern.compile("[Ff][Ii][Ll][Ll]-[Oo][Pp][Aa][Cc][Ii][Tt][Yy]: *([0-9]*\\.?[0-9]*)");
		Pattern p8 = Pattern.compile("[Ss][Tt][Rr][Oo][Kk][Ee]-[Oo][Pp][Aa][Cc][Ii][Tt][Yy]: *([0-9]*\\.?[0-9]*)");
		Pattern p9 = Pattern.compile("rx *= *\"([0-9]*\\.?[0-9]*)\"");
		Pattern p10 = Pattern.compile("ry *= *\"([0-9]*\\.?[0-9]*)\"");
		Pattern p11 = Pattern.compile("[Ss][Tt][Rr][Oo][Kk][Ee]: *([A-Za-z]+) *[;\"]|[Ss][Tt][Rr][Oo][Kk][Ee]: *([Rr][Gg][Bb]\\( *[0-9]* *, *[0-9]* *, *[0-9]* *\\))");
		Pattern p12 = Pattern.compile("height *= *\"([0-9]*\\.?[0-9]*)\"");
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
		if(m1.find())
			width = m1.group(1);
		if(m2.find()){
			if(m2.group(1)!=null&&m2.group(2)!=null)
				fill = "black";
			else if(m2.group(1)!=null)
				fill = m2.group(1);
			else if(m2.group(2)!=null)
				fill = m2.group(2);
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
		if(m11.find()){
			if(m11.group(1)!=null&&m11.group(2)!=null)
				stroke = "black";
			else if(m11.group(1)!=null)
				stroke = m11.group(1);
			else if(m11.group(2)!=null)
				stroke = m11.group(2);
		}
		if(m12.find())
			height = m12.group(1);
	}
	public String toString(){
		return x+" "+y+" "+opacity+" "+width+" "+height+" "+fillOpacity+" "+strokeOpacity+" "+rx+" "+ry+" "+fill+" "+stroke+" "+strokeWidth+" ";
	}
}
