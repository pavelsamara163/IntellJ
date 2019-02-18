package com.games.crat.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.games.crat.model.Ball;

public class GameScreen implements Screen {
	private Texture ballTexture;
	private SpriteBatch spriteBatch;
	private Ball ball;

	@Override
	public void show() {
		ballTexture = new Texture("ball.png");
		spriteBatch = new SpriteBatch();
		ball = new Ball(ballTexture,30,10,100,100);

	}

	@Override
	public void render(float delta) {//Метод показывающий время между кадрами
		Gdx.gl.glClearColor(0,0,0,1);//Цвет заднего фона
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		spriteBatch.begin();
		ball.draw(spriteBatch);
		spriteBatch.end();

	}

	@Override
	public void resize(int width, int height) {


	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {
//Вызывается переключением на другой экран
	}

	@Override
	public void dispose() {
//Уничтожение всех ресурсов
		spriteBatch.dispose();//Удаляет наш обьект/картинку
	}
}
