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

public class SpanishScreen implements Screen{
	private Stage stage;
	private Skin skin;
	private Button backButton;
	BitmapFont SpanishFonts1, SpanishFonts2;
	public static  String SPANISH_MESSAGE1 = "Quiero tener una vida mejor";
	public static  String SPANISH_MESSAGE2 = "Quiero tener una vida mejor"+'\n'+"means:"+'\n'+
	"I want to have a better life";
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

		SpanishFonts1 = FontFactory.getInstance().initializeSP(1, Color.MAGENTA, true);
		SpanishFonts2 = FontFactory.getInstance().initializeSP(6, Color.FOREST, false);
		SpanishFonts2.setFixedWidthGlyphs(SPANISH_MESSAGE2);
		
		stage.addActor(backButton);
		Gdx.input.setInputProcessor(stage);
		
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		SpanishFonts1.draw(batch, SPANISH_MESSAGE1,120f,300.f);
		SpanishFonts1.draw(batch, SPANISH_MESSAGE1, 1000.f, 700.f, 0,20,10f,1, true);
		SpanishFonts2.draw(batch, SPANISH_MESSAGE2,120f,600.f);
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
		SpanishFonts1.dispose();
		SpanishFonts2.dispose();
		skin.dispose();
		stage.dispose();
		
	}
	
}