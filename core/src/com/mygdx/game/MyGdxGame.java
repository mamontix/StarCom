package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background background;
	Hero hero;
	Asteroid[] asteroids;

	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		hero = new Hero();
		asteroids = new Asteroid[25];
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i] = new Asteroid();
		}
	}

	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		hero.render(batch);
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i].render(batch);
		}
		batch.end();
	}

	public void update() {
		background.update();
		hero.update();
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i].update();

		}
	}

	public void dispose () {
		batch.dispose();
	}
}
