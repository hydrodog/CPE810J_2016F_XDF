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


public class ChineseScreen implements Screen{
	private Stage stage;
	private Skin skin;
	private Button backButton;
	BitmapFont ChineseFonts1, ChineseFonts2;
	public static  String CHINESE_MESSAGE1 = "来斯蒂文斯学建设新中国,go!";
	public static  String CHINESE_MESSAGE2 = "天气真好"+'\n'+"团结起来"+'\n'+"开创新天地"+'\n'+"We would win!";
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

		ChineseFonts1 = FontFactory.getInstance().initializeCN(3, Color.BLUE, true);
		ChineseFonts2 = FontFactory.getInstance().initializeCN(6, Color.RED, false);
		ChineseFonts2.setFixedWidthGlyphs(CHINESE_MESSAGE2);
		
		stage.addActor(backButton);
		Gdx.input.setInputProcessor(stage);
		
	}
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		ChineseFonts1.draw(batch, CHINESE_MESSAGE1, 120.f, 300.f);
		ChineseFonts1.draw(batch, CHINESE_MESSAGE1, 1000.f, 700.f, 0,14, 20, 2, true);
		ChineseFonts2.draw(batch, CHINESE_MESSAGE2,120f,600.f);
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
		ChineseFonts1.dispose();
		ChineseFonts2.dispose();
		skin.dispose();
		stage.dispose();
	}
	
}
