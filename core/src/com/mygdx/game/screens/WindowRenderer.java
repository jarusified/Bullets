package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.util.Constants;

public class WindowRenderer implements Disposable {
	private OrthographicCamera camera;
	private OrthographicCamera cameraGUI;
	public static Texture background;
	public static Sprite backgroundSprite;
	private SpriteBatch batch;
	private WindowController controller;
	
	public WindowRenderer(WindowController controller) {
		this.controller=controller;
		init();
	}
	
	public void init(){

		batch=new SpriteBatch();
		camera=new OrthographicCamera(Constants.VIEWPORT_WIDTH,Constants.VIEWPORT_HEIGHT);
		camera.position.set(0,0,0);
		camera.update();
		cameraGUI=new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH,Constants.VIEWPORT_GUI_HEIGHT);
		cameraGUI.position.set(0,0,0);
		cameraGUI.setToOrtho(true);
		cameraGUI.update();
	}

	
	public void resize(int width, int height) {
		camera.viewportWidth=(Constants.VIEWPORT_HEIGHT/height)*width;
		camera.update();
		cameraGUI.viewportHeight=Constants.VIEWPORT_GUI_HEIGHT;
		cameraGUI.viewportWidth= Constants.VIEWPORT_GUI_WIDTH;
		cameraGUI.position.set(cameraGUI.viewportWidth/2,cameraGUI.viewportHeight/2,0);
		cameraGUI.update();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	public void render() {
		renderGame(batch);
	}

	private void renderGame(SpriteBatch batch) {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		controller.game.render(batch);
		batch.end();
	}
	/*private void renderGUI(SpriteBatch batch){
		batch.setProjectionMatrix(cameraGUI.combined);
		batch.begin();
		batch.end();
	}*/

	

}
