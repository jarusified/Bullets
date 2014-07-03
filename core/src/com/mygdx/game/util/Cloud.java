package com.mygdx.game.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.GameObject;

public class Cloud extends GameObject{
	private TextureRegion regCloud;
	public Cloud(){
		
	}
	public void set(TextureRegion region){
		regCloud=region;
	}
		
	@Override
	public void render(SpriteBatch batch) {
		TextureRegion reg = regCloud;
		batch.draw(reg.getTexture(), origin.x, origin.y, origin.x, origin.y ,dimension.x, dimension.y, scale.x, scale.y, 0, reg.getRegionX(), reg.getRegionY(), reg.getRegionWidth(), reg.getRegionHeight(), false, false);
	}
		
}
