package com.dima;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PingPongGame extends ApplicationAdapter {
	private static final int SCREEN_WIDTH = 800;

	private Stage stage;
	private ShapeRenderer wall;
	private Rocket rocket;

	@Override
	public void create () {
		int rocketWidth = 200;
		int rocketX = SCREEN_WIDTH / 2 - rocketWidth / 2;

		wall = new ShapeRenderer();
		rocket = new Rocket(rocketX, 0, rocketWidth, 5, Color.BLUE);
		stage = new Stage();

		Gdx.input.setInputProcessor(stage);
		Gdx.input.setInputProcessor(rocket);
		stage.addActor(rocket);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();

        int windowHeight = Gdx.graphics.getHeight();
        int windowWidth = Gdx.graphics.getWidth();
        int height = 5;


        wall.begin(ShapeRenderer.ShapeType.Filled);
		wall.setColor(Color.BLUE);
		wall.rect(0, windowHeight - height, windowWidth, height);
		wall.end();
	}
}
