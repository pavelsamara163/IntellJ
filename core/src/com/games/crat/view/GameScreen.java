package com.games.crat.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.games.crat.model.Ball;

public class GameScreen implements Screen {
	private Texture ballTexture;
	private SpriteBatch spriteBatch;
	private Ball ball;
	private OrthographicCamera camera;

	public static float deltaCff;

	@Override
	public void show() {
        spriteBatch = new SpriteBatch();
	    ballTexture = new Texture("ball.png");
	    ballTexture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear); // Сглаживание текстуры
		ball = new Ball(ballTexture,0,0,1f,1f * 0.95f); //f - это метры - типо 4 метра

	}

	@Override
	public void render(float delta) {//Метод показывающий время между кадрами
		Gdx.gl.glClearColor(0,0,0,1);//Цвет заднего фона
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		deltaCff = delta;

		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.begin();
		ball.draw(spriteBatch);
		spriteBatch.end();

	}

	@Override
	public void resize(int width, int height) {
        float aspectRatio = (float) height / width; //Соотношение сторон
        camera = new OrthographicCamera(20f,20f * aspectRatio); // Ширина экрана 20м , а высота 20м * на соотношения сторон экрана
       // camera.zoom =  -0.9f;
       // camera.update();


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
