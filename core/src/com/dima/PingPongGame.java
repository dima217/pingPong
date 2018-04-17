package com.dima;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PingPongGame extends ApplicationAdapter {
	SpriteBatch batch;
	ShapeRenderer racket;

	@Override
	public void create () {
		batch = new SpriteBatch();
		racket = new ShapeRenderer();
	}

	@Override
	public void render () {
//		batch.begin();
//		batch.end();

		racket.begin(ShapeRenderer.ShapeType.Filled);
		racket.setColor(Color.BLUE);
		racket.rect(0, 0, 200, 5);
		racket.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
