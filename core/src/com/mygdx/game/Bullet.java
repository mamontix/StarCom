package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Daemonix on 25.04.2017.
 */
public class Bullet {
    Vector2 position; // position.x, position.y
    float speed; //2.5f 3.2f 4.0f 5f 12.75f
    boolean active;

    public Bullet() {
        position = new Vector2(0,0);
        speed = 10.0f; // Скорость полета пули
        active = false;
    }

    public void disable() {
        active = false;
    }

    public void enable(float x, float y) {
        position.x = x;
        position.y = y;
        active = true;
    }

    public void update() {
        position.x += speed;
        if (position.x > 1280) {
            disable();
        }
    }
}
