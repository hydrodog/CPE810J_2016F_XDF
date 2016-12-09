package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.Game;


public class MyGdxGame implements Screen {
	private Texture texture = new Texture(Gdx.files.internal("START.png"));
	private Stage stage = new Stage();
	private Image splashImage = new Image(texture);
	
	public MyGdxGame(){}
	
	@Override
	public void dispose () {
		texture.dispose();
		stage.dispose();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		stage.addActor(splashImage);
		splashImage.addAction(Actions.sequence(Actions.alpha(0),
				Actions.fadeIn(4.0f),Actions.delay(1),Actions.run(new Runnable(){
			@Override
			public void run(){
				((Game)Gdx.app.getApplicationListener()).setScreen(new MenuScreen());
			}
				})));

		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
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
		dispose();
	}
}
