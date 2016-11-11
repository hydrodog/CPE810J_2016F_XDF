package edu.stevens.XDF._2dGraphics;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
/*
 * Read in SVG file, compact xml and convert xml to JSON file. JSON file includes all information of SVG file 
 * such as lines, rectangles and paths.
 * //TODO: Create an analyze class, and analyze what kinds of shapes are in SVG.
 */
public class SVGReader {
	private String SVGxml;
    public SVGReader(String SVGxml){
    	this.SVGxml = SVGxml;
    }
	public void JSONConvert(){
		try {
	    	JSONObject SVGJsonObject = XML.toJSONObject(SVGxml);
	    	System.out.println(SVGJsonObject);
	    } catch (JSONException je) {
	        je.printStackTrace();
	    }
	}
	
}

