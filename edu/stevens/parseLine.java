package edu.stevens;
/*
 * extract attribute of circle with regex
 */
import java.util.regex.*;

public class parseLine extends parseSVG{
	private String x1="0",x2="0",y1="0",y2 = "0",stroke="none",strokeWidth = "0";
	public parseLine(String Line){
		super(Line);
	}
	public void parse(){
		Pattern p1 = Pattern.compile("[Ss][Tt][Rr][Oo][Kk][Ee] *: *([A-Za-z]+) *[;\"]|[Ss][Tt][Rr][Oo][Kk][Ee] *: *([Rr][Gg][Bb]\\( *[0-9]* *, *[0-9]* *, *[0-9]* *\\))");
		Pattern p2 = Pattern.compile("[Ss][Tt][Rr][Oo][Kk][Ee]-[Ww][Ii][Dd][Tt][Hh] *: *([0-9]*\\.?[0-9]*) *[;\"]");
		Pattern p3 = Pattern.compile("x1 *= *\"([0-9]*\\.?[0-9]*)\"");
		Pattern p4 = Pattern.compile("y1 *= *\"([0-9]*\\.?[0-9]*)\"");
		Pattern p5 = Pattern.compile("x2 *= *\"([0-9]*\\.?[0-9]*)\"");
		Pattern p6 = Pattern.compile("y2 *= *\"([0-9]*\\.?[0-9]*)\"");
		Matcher m1 = p1.matcher(Line);
		Matcher m2 = p2.matcher(Line);
		Matcher m3 = p3.matcher(Line);
		Matcher m4 = p4.matcher(Line);
		Matcher m5 = p5.matcher(Line);
		Matcher m6 = p6.matcher(Line);
		if(m1.find()){
			if(m1.group(1)!=null&&m1.group(2)!=null){
				stroke = "black";	
			}
			else if(m1.group(1)!=null){
				stroke = m1.group(1);
			}
			else if(m1.group(2)!=null)
				stroke = m1.group(2);
		}
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
	}
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

	public String toString(){
		return x1+" "+y1+" "+x2+" "+y2+" "+stroke+" "+strokeWidth+" ";
	}
}
