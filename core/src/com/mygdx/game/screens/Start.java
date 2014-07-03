package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;


public class Start implements Screen{
	
	
	
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		stage.draw();
	}

	@Override	
	public void resize(int width, int height) {
	
	}

	@Override
	public void show() {
		stage=new Stage();
		Gdx.input.setInputProcessor(stage);


		atlas=new TextureAtlas("ui/atlas.pack");
		skin=new Skin(Gdx.files.internal("ui/menuSkin.json"),atlas);
	
		table=new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		
		Label heading=new Label(">Bullets<",skin,"big");
		heading.setFontScale(1);
		
		TextButton buttonPlay = new TextButton("PLAY",skin);
		buttonPlay.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event,float x,float y){
				((Game) Gdx.app.getApplicationListener()).setScreen((Screen) new Window());
			}
		});
		buttonPlay.pad(10);
		
		TextButton buttonExit = new TextButton("EXIT", skin);
		buttonExit.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event,float x,float y){
				Gdx.app.exit();
			}
		});	
		
		table.add(heading);
		table.getCell(heading).spaceBottom(100);
		table.row();
		table.add(buttonPlay);
		table.getCell(buttonPlay).spaceBottom(25);
		table.row();
		table.add(buttonExit);
		
		stage.addActor(table);
	}

	@Override
	public void dispose() {
		stage.dispose();
		skin.dispose();
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}
	

}
