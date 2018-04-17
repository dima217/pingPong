package com.dima;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PingPongGame extends ApplicationAdapter {
	SpriteBatch batch;
	ShapeRenderer wall;

	@Override
	public void create () {
		batch = new SpriteBatch();
		wall = new ShapeRenderer();
	}

	@Override
	public void render () {
//		batch.begin();
//		batch.end();

        int windowHeight = Gdx.graphics.getHeight();
        int windowWidth = Gdx.graphics.getWidth();
        int height = 5;

        wall.begin(ShapeRenderer.ShapeType.Filled);
		wall.setColor(Color.BLUE);
		wall.rect(0, windowHeight - height, windowWidth, height);
		wall.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
