package edu.stevens;
/*
 * @author:Bonan Chen
 */
public abstract class parseSVG {
	protected String Line;
	public parseSVG(String Line){
		this.Line = Line;
	}
	public abstract void parse();

}
