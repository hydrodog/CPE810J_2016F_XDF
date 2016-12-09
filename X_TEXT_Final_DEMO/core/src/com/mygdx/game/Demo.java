//package com.mygdx.game;

package com.mygdx.game;

import com.badlogic.gdx.*;
public class Demo extends Game{
	MyGdxGame splashScreen;
	
	@Override
	public void create(){
		splashScreen = new MyGdxGame();
		setScreen(splashScreen);
	}
	
	
}
