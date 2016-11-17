package edu.stevens.XDF._2dGraphics;

import java.awt.*;
import java.util.*;
/*
  @Author Yujie Ren
 * According to shape information of JSON file, compound and save all shapes into array list. Draw the compound shapes..
 * TODO: create more shape class
 */
public class CompoundShape {
	private ArrayList<Shape> Compound;
	public CompoundShape(){
		Compound = new ArrayList<Shape>();
		//add all SVG shapes into the array list 
	        //Compound.add();	
	}
	public void paint(Graphics g){
		for(Shape s: Compound){
			s.paint(g);
		}
	}

}
