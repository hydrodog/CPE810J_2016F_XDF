package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.Game;


public class RussianScreen implements Screen{
	private Stage stage;
	private Skin skin;
	private Button backButton;
	BitmapFont RussianFonts1, RussianFonts2;
	public static  String RUSSIAN_MESSAGE1 = "Добрый день!// good afternoon";
	public static  String RUSSIAN_MESSAGE2 = "Очень приятно "+"(Očen' prijatno)"+'\n'+
	" Приятно "+'\n'+"познакомиться" +'\n'
	+"(Prijatno poznakomit'sja)"+'\n'+"// nice to meet you!";
	private SpriteBatch batch;
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		stage = new Stage();
		batch = new SpriteBatch();
		skin = new Skin(Gdx.files.internal("ui/mainmenu.json"),new TextureAtlas("ui/mainmenu.pack"));
		final MenuScreen MenuScreen = new MenuScreen();
		backButton = new Button(skin,"button5");
		backButton.setPosition(10.f,600.f);
		backButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y){
				((Game)Gdx.app.getApplicationListener()).setScreen(MenuScreen);	
			}
		});

		RussianFonts1 = FontFactory.getInstance().initializeRU(4, Color.ORANGE, true);
		RussianFonts2 = FontFactory.getInstance().initializeRU(6, Color.NAVY, false);
		
		stage.addActor(backButton);
		Gdx.input.setInputProcessor(stage);
		
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		RussianFonts1.draw(batch, RUSSIAN_MESSAGE1, 120.f, 300.f);
		RussianFonts1.draw(batch, RUSSIAN_MESSAGE1, 1100.f, 700.f, 0,14, 20, 2, true);
		RussianFonts2.draw(batch, RUSSIAN_MESSAGE2,120f,600.f);
		batch.end();
		stage.act();
		stage.draw();
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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
	public void hide() {
		// TODO Auto-generated method stub
		dispose();
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		batch.dispose();
		RussianFonts1.dispose();
		RussianFonts2.dispose();
		skin.dispose();
		stage.dispose();
	}
	
}
