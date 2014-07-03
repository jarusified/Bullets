package com.mygdx.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Disposable;
	
public class Assets implements Disposable,AssetErrorListener {
	public static final String TAG=Assets.class.getName();
	public static final Assets instance= new Assets();
	public AssetManager assetManager;
	
	public AssetsFonts fonts;
	public Mountain1 mountain1;
	public Mountain2 mountain2;
	public Bullet bullet;
	public Airplane airplane;
	public Cloud cloud;
	
	public class Cloud{
		public final AtlasRegion cloud;
		public Cloud(TextureAtlas atlas) {
			cloud=atlas.findRegion("cloud");
		}
	}
	public class Mountain1{
		public final AtlasRegion mountain1;
		public Mountain1(TextureAtlas atlas) {
			mountain1=atlas.findRegion("mountain1");
		}
	}
	public class Mountain2{
		public final AtlasRegion mountain2;
		public Mountain2(TextureAtlas atlas) {
			mountain2=atlas.findRegion("mountain2");
		}
	}
	public class Airplane{
		public final AtlasRegion airplane;
		public Airplane(TextureAtlas atlas) {
			airplane=atlas.findRegion("airplane");

		}
	}
	public class Bullet{
		public final AtlasRegion bullet;
		public Bullet(TextureAtlas atlas) {
			bullet=atlas.findRegion("bullet");

		}
	}
	
	public void init(AssetManager assetManager){
	
		this.assetManager=assetManager;
		assetManager.setErrorListener(this);
		assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS,TextureAtlas.class);
		assetManager.finishLoading();
		TextureAtlas atlas=assetManager.get(Constants.TEXTURE_ATLAS_OBJECTS);
		
		for (Texture t: atlas.getTextures())
			t.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		fonts = new AssetsFonts();
		mountain1=new Mountain1(atlas);
		mountain2=new Mountain2(atlas);
		cloud=new Cloud(atlas);
		bullet=new Bullet(atlas);
		airplane=new Airplane(atlas);
		
	}

	@Override
	public void dispose() {
		assetManager.dispose();
		fonts.small.dispose();
		fonts.normal.dispose();
		fonts.big.dispose();
	}

	
	public class AssetsFonts{
		public final BitmapFont small;
		public final BitmapFont normal;
		public final BitmapFont big;
		
		public AssetsFonts(){
			small=new BitmapFont(Gdx.files.internal("font/black16.fnt"),true);
			normal=new BitmapFont(Gdx.files.internal("font/black32.fnt"),true);
			big=new BitmapFont(Gdx.files.internal("font/black64.fnt"),true);
			small.getRegion().getTexture().setFilter(TextureFilter.Linear,TextureFilter.Linear);
			normal.getRegion().getTexture().setFilter(TextureFilter.Linear,TextureFilter.Linear);
			big.getRegion().getTexture().setFilter(TextureFilter.Linear,TextureFilter.Linear);
		}	
	}

	@Override
	public void error(AssetDescriptor asset, Throwable throwable) {
		
	}
	
	
	
}
