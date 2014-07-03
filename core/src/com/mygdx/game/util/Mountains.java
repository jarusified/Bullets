package com.mygdx.game.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.GameObject;

public class Mountains extends GameObject{
	private TextureRegion regionLeft;
	private TextureRegion regionRight;
	private int length=256;
	
	public Mountains(int length){
		this.length=length;
		init();
	}
	
	private void init(){
		dimension.set(10,2);
	
		regionLeft=Assets.instance.mountain2.mountain2;
		regionRight=Assets.instance.mountain1.mountain1;
		
		origin.x=-dimension.x*2;
		length +=dimension.x*2;
	}
	
	private void draw(SpriteBatch batch,float offsetX,float offsetY,float color){
		TextureRegion region=null;
		batch.setColor(color, color, color, 1);
		float x1= dimension.x*offsetX;
		float y1= dimension.y*offsetY;
		
		int length=0;
		length+=MathUtils.ceil(length/2*dimension.x);
		length+=MathUtils.ceil(0.5f + offsetX);
		for(int i=0;i<length;i++){
			region=regionLeft;
			batch.draw(region.getTexture(), origin.x+x1, origin.y+y1, origin.x, origin.y ,dimension.x, dimension.y, scale.x, scale.y, i, region.getRegionX(), region.getRegionY(), region.getRegionWidth(), region.getRegionHeight(), false, false);
			x1+=dimension.x;
			region=regionRight;
			batch.draw(region.getTexture(), origin.x+x1, origin.y+y1, origin.x, origin.y ,dimension.x, dimension.y, scale.x, scale.y, i, region.getRegionX(), region.getRegionY(), region.getRegionWidth(), region.getRegionHeight(), false, false);
			x1+=dimension.x;
		}
		batch.setColor(1,1,1,1);
	}
	@Override
	public void render(SpriteBatch batch) {
		draw(batch,0.5f,-0.5f,0.5f);
		draw(batch,0.5f,-0.75f,0.25f);
		draw(batch,0.5f,-1.0f,0.7f);
	}
}
