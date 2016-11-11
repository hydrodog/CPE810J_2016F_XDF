package com.mygdx.game;


//Author: Xiaotian Zhang, Zhiheng Xu, Qian Zhu
/**
 * We found that freetype in java is hard to implement directly,
 * So we applied the libgdx to use the freetype library
 * Qianzhu learned deeply into the freetype library and give us some introductions of the functions
 * in the freetype
 * Zhiheng Xu set up the whole project environment 
 * Xiaotian Zhang built a first small demo to test the fonts and let it show on screen*/
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeBitmapFontData;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;


public class MyGdxGame implements ApplicationListener{

    BitmapFont[] font;
    //FreeTypeBitmapFontData fontData;
    FreeTypeFontGenerator generator;    
    SpriteBatch batch;
    
    @Override
    public void create() {
        // TODO Auto-generated method stub
        batch = new SpriteBatch();
        font = new BitmapFont[4];
        FreeTypeFontParameter par = new FreeTypeFontParameter(); 
        par.size = 30;
        Color[] colors = { Color.RED, Color.BLUE, Color.GREEN };
        for( int i=0; i<3; ++i ){
            generator = new FreeTypeFontGenerator( Gdx.files.internal( "data" + (i+1) + ".ttf" ) );
            font[i] = generator.generateFont( par );
            font[i].setColor( colors[i] );
            //generator.dispose();
        }
        //HeiTi
        generator = new FreeTypeFontGenerator(Gdx.files.internal("SIMHEI.TTF"));
        FreeTypeBitmapFontData data = generator.generateData(25);
		font[3] = new BitmapFont(Gdx.files.internal("SIMHEI.TTF"),false) ;
        font[3].setColor(Color.BLACK);
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
        for( int i=0; i<3; ++i ){
            font[i].draw( batch, "It is Very Good! 20140521!!", 120, 100*(3-i) );
        }
        font[3].draw(batch, "你好啊hello", 120, 400);
        
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
