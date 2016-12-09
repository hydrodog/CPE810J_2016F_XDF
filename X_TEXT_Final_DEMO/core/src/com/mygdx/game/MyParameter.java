package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class MyParameter extends FreeTypeFontParameter {
	int parNum;
	boolean isKerning;
	MyParameter(int parNum, String chars, boolean isKer){
		
		this.parNum = parNum;
		this.characters = chars;
		this.isKerning = isKer;
		ChooseParameter(parNum,chars,isKer);
	}
	
	MyParameter(String chars){
		this.characters = chars;
	}
	
	public void setParameter(int size, Color borCol, int borNum, int sx, int sy, Color shadowCol, boolean isKerning, String chars){
		this.borderColor = borCol;
		this.borderWidth = borNum;
		this.shadowOffsetX = sx;
		this.shadowOffsetY = sy;
		this.size = size;
		this.shadowColor = shadowCol;
		this.kerning = isKerning;
		this.characters = chars;
	}
	
	public void setParameter(int size, boolean iskerning, int spaceX, int spaceY){
		this.size = size;
		this.spaceX = spaceX;
		this.spaceY = spaceY;
		this.kerning = iskerning;
	}
	
	
	public void ChooseParameter(int parNum, String chars,boolean isKer){
		// it can use system delay to print out different
		if(parNum == 1) {setParameter(40, Color.BLACK,3,3,3,Color.BLACK,isKer, chars);}
		else if (parNum == 2) {setParameter(40, Color.BLACK, 0, 3,3,Color.BLACK,isKer, chars);}
		else if (parNum == 3) {setParameter(40, Color.BLACK, 3, 0,0,Color.BLACK,isKer, chars);}
		else if (parNum == 4) {setParameter(40, Color.BLACK, 3, 3,3,Color.BLACK,isKer, chars);}
		else if (parNum == 5) {setParameter(40, Color.BLACK, 0, 0,0,Color.BLACK,isKer, chars);}
		else {setParameter(40, Color.BLACK,0, 0,0,Color.BLACK,isKer, chars);}
	}
	
	public void setKerning(boolean isKerning){
		this.kerning = isKerning;
	}	

	public MyParameter getParameter(){
		return this;
	}
	
}