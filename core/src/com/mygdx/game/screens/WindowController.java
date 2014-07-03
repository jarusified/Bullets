package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.Game;
import com.mygdx.game.util.Constants;

public class WindowController {

	public Game game;
	public int lives;
	public int score;
	
	public WindowController(){
		init();
	}
	
	public void init(){
		//Gdx.input.setInputProcessor((InputProcessor) this);
		lives=Constants.LIVES;
		initLevel();
	}
	private void initLevel(){
		score=0;
		game=new Game();
	}	
	
	public boolean keyUp(int keycode){
		if(keycode==Keys.R){
			init();
		}
		return false;
	}

	public void update(float deltaTime){
	}
	

}
