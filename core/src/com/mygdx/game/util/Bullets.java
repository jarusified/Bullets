package com.mygdx.game.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameObject;

public class Bullets extends GameObject {
	public int length=256;
	
	public Bullets(int length){
		this.length=length;
		init();
	}

	private void init() {
		
	}

	@Override
	public void render(SpriteBatch batch) {
		
	}
	
}
