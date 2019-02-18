package com.games.crat.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.games.crat.view.GameScreen;

public class BallController {
    private Polygon ballBounds;


    public BallController(Polygon ballBounds) {
        this.ballBounds = ballBounds;
    }

    float speed ;
    float velocity = 10f;
    float speedMax = 25f;
    private float rotationSpeed = 20f;

    public void handle() {

        //Все что связано со скорость мяча
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            speed += velocity * GameScreen.deltaCff;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            speed -= velocity * GameScreen.deltaCff;
        } else {
            downSpeed();
        }

        speed = sliceSpeed();

        // Все что связано с поворотом мяча

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            ballBounds.rotate(rotationSpeed * speed * GameScreen.deltaCff);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            ballBounds.rotate(-rotationSpeed * speed * GameScreen.deltaCff);
        }


        //ballBounds.rotate(-2f);
        ballBounds.setPosition(ballBounds.getX() + MathUtils.cosDeg(ballBounds.getRotation() + 90) * speed * GameScreen.deltaCff
                , ballBounds.getY() + MathUtils.sinDeg(ballBounds.getRotation() + 90) * speed * GameScreen.deltaCff);
                                        

    }

    private void downSpeed() {
        if (speed > velocity * GameScreen.deltaCff) {
            speed -= velocity * GameScreen.deltaCff;
        } else if (speed < velocity * GameScreen.deltaCff) {
            speed += velocity * GameScreen.deltaCff;
        } else {
            speed = 0f;
        }
    }

    private float sliceSpeed() {
        if (speed > speedMax) {
            return speedMax;

        } else if (speed < -speedMax) {
            return -speedMax;

        }
        return speed;
    }
}
