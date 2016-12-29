package com.kilobolt.gameobjects;

import com.kilobolt.gameobjects.Scrollable;

public class Grass extends Scrollable {
    public Grass(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
    }

    public void onRestart(float x, float scrollSpeed) {
        this.position.x = x;
        this.velocity.x = scrollSpeed;
    }
}
