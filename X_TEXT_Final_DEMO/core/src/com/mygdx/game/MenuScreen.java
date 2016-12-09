package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.Game;

public class MenuScreen implements Screen {

	private Skin skin;
	private Stage stage;
	private Image bg;
	private SpanishScreen SpanishScreen = new SpanishScreen();
	private EnglishScreen EnglishScreen = new EnglishScreen();
	private ChineseScreen ChineseScreen = new ChineseScreen();
	private RussianScreen RussianScreen = new RussianScreen();
	
	private Button SpanishButton;
	private Button EnglishButton;
	private Button RussianButton;
	private Button ChineseButton;
	
	public MenuScreen(){}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		stage = new Stage();
		skin = new Skin(Gdx.files.internal("ui/mainmenu.json"),new TextureAtlas("ui/mainmenu.pack"));
		
		bg = new Image(skin,"bg");
		SpanishButton = new Button(skin,"button1");
		EnglishButton = new Button(skin,"button2");
		RussianButton = new Button(skin,"button3");
		ChineseButton = new Button(skin,"button4");
		
		bg.setPosition(Gdx.graphics.getWidth()/2 - 480/2f, Gdx.graphics.getHeight()/2 - 480/2f);
		SpanishButton.setPosition(Gdx.graphics.getWidth() /2 - 210/2f, Gdx.graphics.getHeight()/2 + 70f);
		EnglishButton.setPosition(Gdx.graphics.getWidth() /2 - 210/2f, Gdx.graphics.getHeight()/2-10f );
		RussianButton.setPosition(Gdx.graphics.getWidth() /2 - 210/2f, Gdx.graphics.getHeight()/2-90f);
		ChineseButton.setPosition(Gdx.graphics.getWidth() /2 - 210/2f, Gdx.graphics.getHeight()/2 - 170f);
			        
		SpanishButton.addListener(new ClickListener(){
	        @Override 
	        public void clicked(InputEvent event, float x, float y){	                
	        	((Game)Gdx.app.getApplicationListener()).setScreen(SpanishScreen);	            	
	            }
	        });
	    EnglishButton.addListener(new ClickListener(){
	        @Override 
	        public void clicked(InputEvent event, float x, float y){	                
	        	((Game)Gdx.app.getApplicationListener()).setScreen(EnglishScreen);	            	
	            }
	        });
	    RussianButton.addListener(new ClickListener(){
	        @Override 
	        public void clicked(InputEvent event, float x, float y){	                
	        	((Game)Gdx.app.getApplicationListener()).setScreen(RussianScreen);	            	
	            }
	        });
	    ChineseButton.addListener(new ClickListener(){
	        @Override 
	        public void clicked(InputEvent event, float x, float y){
	        	((Game)Gdx.app.getApplicationListener()).setScreen(ChineseScreen);
	            }
	        });
	        
	        stage.addActor(bg);
	        stage.addActor(SpanishButton);
	        stage.addActor(EnglishButton);
	        stage.addActor(RussianButton);
	        stage.addActor(ChineseButton);
	        
	        Gdx.input.setInputProcessor(stage);

		
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0x64/255.0f,0x95/255.0f,0xed/255.0f,0xff/255.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
		
	}

	@Override
	public void dispose() {
		skin.dispose();
		stage.dispose();

	}

}
