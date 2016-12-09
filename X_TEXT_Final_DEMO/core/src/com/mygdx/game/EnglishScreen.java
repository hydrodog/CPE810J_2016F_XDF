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

public class EnglishScreen implements Screen{
	private Stage stage;
	private Skin skin;
	private Button backButton;
	BitmapFont EnglishFonts1, EnglishFonts2;
	public static  String ENGLISH_MESSAGE1 = "Today is really such a good day";
	public static  String ENGLISH_MESSAGE2 = "Climb mountains not so"+'\n'+" the world can see you"+'\n'
	+ "But so you can see the world";
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

		EnglishFonts1 = FontFactory.getInstance().initializeEN(2, Color.GREEN, true);
		EnglishFonts2 = FontFactory.getInstance().initializeEN(6, Color.RED, false);
		
		stage.addActor(backButton);
		Gdx.input.setInputProcessor(stage);
		
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		EnglishFonts1.draw(batch, ENGLISH_MESSAGE1, 120.f, 300.f);
		EnglishFonts1.draw(batch, ENGLISH_MESSAGE1, 1000.f, 700.f, 0,14, 20, 2, true);
		EnglishFonts2.draw(batch, ENGLISH_MESSAGE2,120f,600.f);
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
		EnglishFonts1.dispose();
		EnglishFonts2.dispose();
		skin.dispose();
		stage.dispose();
		
	}
	
}