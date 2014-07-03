package com.mygdx.game.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.GameObject;
import com.mygdx.game.util.Cloud;

public class Clouds extends GameObject {
	private float length;
	private Array<TextureRegion> regClouds;
	private Array<Cloud> clouds;
	
	public Clouds(float length){	
		this.length=length;
		init();
	}
	
	private void init(){
		dimension.set(3.0f,1.5f);
		regClouds=new Array<TextureRegion>();
		regClouds.add(Assets.instance.cloud.cloud);
		int distance=10;
		int numClouds=(int)(length/distance);
		clouds=new Array<Cloud>(2*numClouds);
		for(int i=0;i<numClouds;i++){
			Cloud cloud=spawnCloud();
			cloud.position.x=i*distance;
			clouds.add(cloud);
		}
	}
	private Cloud spawnCloud() {
		Cloud cloud = new Cloud();
		cloud.set(regClouds.random());
		Vector2 pos=new Vector2();
		pos.x=length+10;
		pos.y+=1.75;
		pos.y+=MathUtils.random(0.0f,0.2f)*(MathUtils.randomBoolean() ? 1: -1);
		cloud.position.set(pos);
		return cloud;
	}

 	@Override
	public void render(SpriteBatch batch) {
		for (Cloud cloud : clouds){
			cloud.render(batch);
		}
	}
}
