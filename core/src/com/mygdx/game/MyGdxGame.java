package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.screens.Start;

public class MyGdxGame extends Game {
	
	@Override
	public void create(){
		setScreen(new Start());
	}

	@Override
	public void render() {
		super.render();
		
	}
	@Override
	public void dispose(){
		super.dispose();
	}
	@Override
	public void resize(int width,int height){
		super.resize(width, height);
	}
	
	@Override
	public void resume(){
		super.resume();
	}
	
	@Override
	public void pause(){
		super.pause();
	}
}

