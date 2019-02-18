package com.games.crat.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.games.crat.control.BallController;

public class Ball extends GameObject {

    private BallController ballController;

    public Ball(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        ballController = new BallController(bound);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        ballController.handle();
    }
}
