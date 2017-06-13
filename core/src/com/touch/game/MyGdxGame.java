package com.touch.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.touch.game.com.touch.game.interfaces.Ser;
import com.touch.game.com.touch.game.personagens.Victoria;


import static com.touch.game.Constantes.*;



public class MyGdxGame extends ApplicationAdapter {

	private PlanoDeFundo fundo;

	private SpriteBatch batch;

	private Ser personagemAEscolher;

	String personagemEscolhido;

	@Override
	public void create () {
		fundo = new PlanoDeFundo();
		batch = new SpriteBatch();

		personagemAEscolher = new Victoria(persIni, (int) (SCREENY/2.25), 3);

	}

	@Override
	public void render () {
		input();
		update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		draw(batch);

		batch.end();
	}

	private void draw(SpriteBatch batch) {
		fundo.draw(batch);
		personagemAEscolher.draw(batch);
	}

	private void update(float time) {
		fundo.update(time);
		personagemAEscolher.update(time);
	}

	private void input() {
		if(Gdx.input.justTouched()) {
			personagemAEscolher.impulso();
		}
	}
	
	@Override
	public void dispose () {
		fundo.dispose();
	}

	private boolean isDiego(){
		boolean isDiego = false;
		if (personagemEscolhido != null) {
			isDiego = true;
		}
		return isDiego;
	}

}
