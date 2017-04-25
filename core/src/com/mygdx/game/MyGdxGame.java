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
	static Bullet[] bullets;
	Texture textureBullet;

	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		hero = new Hero();
		asteroids = new Asteroid[25];
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i] = new Asteroid();
		}
		bullets = new Bullet[200];
		for (int i = 0; i < bullets.length; i++) {
			bullets[i] = new Bullet();
		}
		textureBullet = new Texture("bullet64x32.png");
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
		for (int i = 0; i < bullets.length; i++) {
			if (bullets[i].active) {
				batch.draw(textureBullet, bullets[i].position.x -32, bullets[i].position.y -16);
			}
		}
		batch.end();
	}

	public void update() {
		background.update();
		hero.update();
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i].update();
		}
		for (int i = 0; i < bullets.length; i++) {
			if (bullets[i].active) {
				bullets[i].update();
				for (int j = 0; j < asteroids.length; j++) {
					if (asteroids[j].rectangle.contains(bullets[i].position)) {
						asteroids[j].recreate();
						bullets[i].disable();
						break;
					}
					
				}
			}
		}
	}

	public void dispose () {
		batch.dispose();
	}
}
