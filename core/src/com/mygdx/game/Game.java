package com.mygdx.game;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.util.Bullets;
import com.mygdx.game.util.Clouds;
import com.mygdx.game.util.Mountains;

public class Game {
	
	//public Array<Bullets> bullets;
	public Clouds clouds;
	public Mountains mountains;
	public Bullets bullets;
	private int width=256;
	private int height=256;
	
	public Game(){
		init();
	}
	public void init(){
		Pixmap pixmap=new Pixmap(width,height,Format.RGBA8888);
		clouds=new Clouds(pixmap.getWidth());
		clouds.position.set(0,2);
		mountains=new Mountains(pixmap.getWidth());
		bullets=new Bullets(pixmap.getWidth());
		pixmap.dispose();
	}
	public void render(SpriteBatch batch){
		mountains.render(batch);
		bullets.render(batch);
		//clouds.render(batch);
		
	}
}
