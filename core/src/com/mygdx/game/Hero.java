package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by oi07 on 25.04.2017.
 */
public class Hero {
    Texture texture;
    Vector2 position;
    float speed;

    public Hero() {
        texture = new Texture("ship64.png");
        position = new Vector2(100, 328);
        speed = 8.0f;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            position.x -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            position.x += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            position.y += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            position.y -= speed;
        }

        if (Gdx.input.isTouched()) {
            if(Gdx.input.getX() < position.x + 32) position.x -= speed;
            if(Gdx.input.getX() > position.x + 32) position.x += speed;
            if(Gdx.graphics.getHeight() - Gdx.input.getY() < position.y + 32) position.y -= speed;
            if(Gdx.graphics.getHeight() - Gdx.input.getY() > position.y + 32) position.y += speed;
        }

        if (position.x < 0) position.x = 0;
        if (position.x > 1216) position.x = 1216;
        if (position.y > 720) position.y = -64;
        if (position.y < -64) position.y = 720;
    }
}
