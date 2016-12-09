package edu.stevens;
/*
 * @author:Bonan Chen
 * extract attribute of path with regex
 */
import java.util.regex.*;

public class parsePath extends parseSVG{
	private String d="none",stroke="none",fill="black",strokeWidth="0",fillOpacity="1",strokeOpacity="1",opacity="1";
	public parsePath(String Line){
		super(Line);
	}
	public void parse(){
		Pattern p1 = Pattern.compile("d *= *\"([-MLHVCSQTAZmlhvcsqtaz0-9\\.\\s,]*)\"");
		Pattern p2 = Pattern.compile("[Ff][Ii][Ll][Ll] *= *\"([Rr][Gg][Bb]\\( *[0-9]* *, *[0-9]* *, *[0-9]* *\\))|[Ff][Ii][Ll][Ll]: *([A-Za-z]+) *[;\"]");
		Pattern p3 = Pattern.compile("[Ss][Tt][Rr][Oo][Kk][Ee]-[Ww][Ii][Dd][Tt][Hh] *= *\"([0-9]*\\.?[0-9]*)");
		Pattern p4 = Pattern.compile("[Ss][Tt][Rr][Oo][Kk][Ee] *= *\"([A-Za-z]+) *[;\"]|[Ss][Tt][Rr][Oo][Kk][Ee]: *([Rr][Gg][Bb]\\( *[0-9]* *, *[0-9]* *, *[0-9]* *\\))");
		Pattern p5 = Pattern.compile("[^-][Oo][Pp][Aa][Cc][Ii][Tt][Yy] *= *\"([0-9]*\\.?[0-9]*)");
		Pattern p6 = Pattern.compile("[Ff][Ii][Ll][Ll]-[Oo][Pp][Aa][Cc][Ii][Tt][Yy] *= *\"([0-9]*\\.?[0-9]*)");
		Pattern p7 = Pattern.compile("[Ss][Tt][Rr][Oo][Kk][Ee]-[Oo][Pp][Aa][Cc][Ii][Tt][Yy] *= *\"([0-9]*\\.?[0-9]*)");
		Matcher m1 = p1.matcher(Line);
		Matcher m2 = p2.matcher(Line);
		Matcher m3 = p3.matcher(Line);
		Matcher m4 = p4.matcher(Line);
		Matcher m5 = p5.matcher(Line);
		Matcher m6 = p6.matcher(Line);
		Matcher m7 = p7.matcher(Line);
		if(m1.find())
			d = m1.group(1);
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
		if(m4.find()){
			if(m4.group(1)!=null&&m4.group(2)!=null)
				stroke = "black";
			else if(m4.group(1)!=null)
				stroke = m4.group(1);
			else if(m4.group(2)!=null)
				stroke = m4.group(2);
		}
		if(m5.find())
			opacity = m5.group(1);
		if(m6.find())
			fillOpacity = m6.group(1);
		if(m7.find())
			strokeOpacity = m7.group(1);
	}
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
	public String toString(){
		return d+stroke+fill+strokeWidth+fillOpacity+strokeOpacity+opacity;
	}
}
