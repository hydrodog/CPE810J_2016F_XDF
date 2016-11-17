package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeBitmapFontData;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;


public class XTextFreetype implements ApplicationListener{

    BitmapFont[] font;
    FreeTypeBitmapFontData fontData;
    FreeTypeFontGenerator generator;    
    SpriteBatch batch;
    
    @Override
    public void create() {
        // TODO Auto-generated method stub
        batch = new SpriteBatch();
        font = new BitmapFont[4];
        FreeTypeFontParameter par = new FreeTypeFontParameter(); 
        par.size = 30;
        //par.characters = "今天天气很好";
        par.characters = FreeTypeFontGenerator.DEFAULT_CHARS+"今天天气很好";
        Color[] colors = { Color.RED, Color.BLUE, Color.GREEN, Color.GOLD};
        for( int i=0; i<4; ++i ){
            generator = new FreeTypeFontGenerator( Gdx.files.internal( "data" + (i+1) + ".TTF" ) );
            font[i] = generator.generateFont( par );
            font[i].setColor( colors[i] );
            //generator.dispose();
        }
        
        generator.dispose();
	
        //fontData = generator.generateData( 25, FreeTypeFontGenerator.DEFAULT_CHARS+"�����Ǹ������ӣ�������鶼��", false );
    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void render() {
        // TODO Auto-generated method stub
        
        Gdx.gl.glClearColor( 1, 1, 1, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
        
        batch.begin();
        for( int i=0; i<4; ++i ){
            font[i].draw( batch, "今天天气很好 It is Very Good! 1224!!", 120, 100*(4-i) );
        }
        
        batch.end();
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        batch.dispose();
    }
    
}