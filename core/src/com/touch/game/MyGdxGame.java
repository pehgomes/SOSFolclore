package com.touch.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.touch.game.Constantes.*;



public class MyGdxGame extends ApplicationAdapter {

	private PlanoDeFundo fundo;

	private SpriteBatch batch;

	private Personagem diego;

	@Override
	public void create () {
		fundo = new PlanoDeFundo();
		batch = new SpriteBatch();
		diego = new Personagem(persIni, (int) (SCREENY/2.25));

	}

	@Override
	public void render () {
		update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		draw(batch);

		batch.end();
	}

	private void draw(SpriteBatch batch) {

		fundo.draw(batch);

		diego.draw(batch);

	}

	private void update(float time) {
		fundo.update(time);

		diego.update(time);
	}
	
	@Override
	public void dispose () {
		fundo.dispose();
	}



}
