package com.mygdx.game.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.WindowRenderer;
import com.mygdx.game.screens.WindowController;
import com.mygdx.game.util.Assets;

public class Window implements Screen {
	
	private WindowController controller;
	private WindowRenderer renderer;
	
	public static Texture background;
	public static Sprite backgroundSprite;
	private SpriteBatch batch;
	private boolean paused;
	
	@Override
	public void render(float delta) {
		if(!paused){
			controller.update(Gdx.graphics.getDeltaTime());
		}
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0, 0, 0, 0);
		batch.end();
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		renderer.resize(width, height);
	}

	@Override
	public void show() {
		batch=new SpriteBatch();
		background=new Texture("img/screen.png");
		backgroundSprite=new Sprite(background);
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		Assets.instance.init(new AssetManager());
		controller=new WindowController();
		renderer=new WindowRenderer(controller);
		paused=false;
	}


	@Override
	public void pause() {
		paused=true;
	}

	@Override
	public void resume() {
		Assets.instance.init(new AssetManager());
		paused=false;
	}

	@Override
	public void dispose() {
		renderer.dispose();
		Assets.instance.dispose();
	}

	@Override
	public void hide() {
		
	}

}
