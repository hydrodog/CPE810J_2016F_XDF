package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FontFactory {
	
	// Font names
	public static final String SPANISH_FONT_NAME = "fonts/goodfish rg.ttf";
	public static final String RUSSIAN_FONT_NAME = "fonts/Imperial Web.ttf";
	public static final String CHINESE_FONT_NAME = "fonts/data1.TTF";
	public static final String ENGLISH_FONT_NAME = "fonts/MAGNETOB.TTF";
	
	// Russian cyrillic characters
	public static final String RUSSIAN_CHARACTERS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
            + "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
            + "1234567890.,:;_¡!¿?\"'+-*/()[]={}";
	//some parts of Chinese characters
	public static final String CHINESE_CHARACTERS = "今天天气真好，建设新中国 ，让我们一起来斯蒂文斯理工学习"
			+ "团结就是力量，凝聚起来才有希望，大家一起努力开创新天地";
	
	// Singleton: unique instance
	private static FontFactory instance;
	
	private BitmapFont enFont;
	private BitmapFont esFont;
	private BitmapFont ruFont;
	private BitmapFont cnFont;
	
	/** Private constructor for singleton pattern */
	private FontFactory() { super(); }
	
	public static synchronized FontFactory getInstance() {
		if (instance == null) {
			instance = new FontFactory();
		}
		return instance;
	}
	
	//Spanish Fonts
	public BitmapFont initializeSP(int esType, Color col , boolean isKerning) {
		esFont = generateFont(esType,SPANISH_FONT_NAME, FreeTypeFontGenerator.DEFAULT_CHARS,col, isKerning);
		return esFont;
	}
	
	//Russian Fonts
	public BitmapFont initializeRU(int ruType, Color col, boolean isKerning){
		ruFont = generateFont(ruType,RUSSIAN_FONT_NAME, FreeTypeFontGenerator.DEFAULT_CHARS+RUSSIAN_CHARACTERS,col, isKerning);
		return ruFont;
	}
	
	//Chinese Fonts
	public BitmapFont initializeCN(int cnType, Color col, boolean isKerning){
		cnFont = generateFont(cnType,CHINESE_FONT_NAME, FreeTypeFontGenerator.DEFAULT_CHARS+CHINESE_CHARACTERS, col, isKerning);
		return cnFont;
	}
	
	//English Fonts
	public BitmapFont initializeEN(int enType, Color col, boolean isKerning){
		enFont = generateFont(enType,ENGLISH_FONT_NAME, FreeTypeFontGenerator.DEFAULT_CHARS, col, isKerning);
		return enFont;
	}
	
	public BitmapFont generateFont(int typeNum, String fontName, String characters, Color col,boolean isKerning) {
		// Configure font parameters
		MyParameter par = new MyParameter(typeNum, characters, isKerning);
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator( Gdx.files.internal(fontName) );
		BitmapFont font = generator.generateFont(par);
		font.setColor(col);
		
		// Dispose
		generator.dispose();
		return font;
	}
	
	public void dispose() {
		enFont.dispose();
		esFont.dispose();
		ruFont.dispose();
		cnFont.dispose();
	}
}