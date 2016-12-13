package edu.stevens.XDF._2dgraphics;

public abstract class parseSVG {
	protected String Line,transform="",stroke="none",fill="black",strokeWidth="0",opacity="1",fillOpacity="1",strokeOpacity="1",style = "none";
	public parseSVG(String Line){
		this.Line = Line;
	}
	public parseSVG(String Line,String stroke,String fill,String strokeWidth,String opacity ,String fillOpacity,String strokeOpacity,String transform,String style){
		this.Line = Line;
		this.transform = transform;
		this.stroke = stroke;
		this.fill = fill;
		this.strokeWidth = strokeWidth;
		this.opacity = opacity;
		this.fillOpacity = fillOpacity;
		this.strokeOpacity = strokeOpacity;
		this.style = style;
	}
	public abstract void parse();

}
