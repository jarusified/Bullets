package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
	public Vector2 position;
	public Vector2 dimension;
	public Vector2 origin;
	public Vector2 scale;
	public float rotation;
	public Vector2 velocity;
	public GameObject(){
		position=new Vector2();
		dimension=new Vector2(1,1);
		origin=new Vector2();
		scale=new Vector2(1,1);
		velocity=new Vector2();
		rotation=0;
	}
	
	public void update(float deltaTime){
		position.x+=velocity.x * deltaTime;
		position.y+=velocity.y * deltaTime;
	}
	public abstract void render(SpriteBatch batch);

	public void create() {
		
	}
}
