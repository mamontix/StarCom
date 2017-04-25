package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Daemonix on 25.04.2017.
 */
public class Asteroid {
    static Texture texture;
    Vector2 position; // position.x, position.y
    float speed; //2.5f 3.2f 4.0f 5f 12.75f
    float angle;
    float scale;
    Rectangle rectangle;

    public Asteroid() {
        position = new Vector2(1280 + (float) Math.random() * 1280, (float) Math.random() * 720);
        speed = 4.0f + (float) Math.random() * 4.0f;
        angle = (float) Math.random() * 360;
        scale = 0.8f + (float) Math.random() * 0.4f;
        if (texture == null) {
            texture = new Texture("asteroid64.png");
        }
        rectangle = new Rectangle(position.x, position.y, 64, 64);
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, 32, 32, 64, 64, scale, scale, angle, 0, 0, 64, 64, false, false);
    }

    public void recreate() {
        position.x = 1280 + (float) Math.random() * 1280;
        position.y = (float) Math.random() * 720;
        speed = 4.0f + (float) Math.random() * 4.0f;
    }

    public void update() {
        position.x -= speed;
        angle += speed / 2;
        if (position.x < -64) {
            position.x = 1280 + (float) Math.random() * 1280;
            position.y = (float) Math.random() * 720;
            speed = 4.0f + (float) Math.random() * 4.0f;
        }
        rectangle.x = position.x;
        rectangle.y = position.y;
    }
}
