package com.touch.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.touch.game.com.touch.game.botao.Butao;
import com.touch.game.com.touch.game.interfaces.Ser;
import com.touch.game.com.touch.game.personagens.Diego;
import com.touch.game.com.touch.game.personagens.Victoria;


import static com.touch.game.Constantes.*;



public class MyGdxGame extends ApplicationAdapter {

	private Butao btnStart;

	private Butao btnAtack;

	private Butao btnPular;

	private PlanoDeFundo fundo;

	private SpriteBatch batch;

	private Ser personagemAEscolher;

	private boolean andando ;

	private boolean atacando;

	private boolean pulando;

	private int quantidadeDeTextura;

	String personagemEscolhido;

	@Override
	public void create () {
		this.quantidadeDeTextura = 3;
		btnStart = new Butao(new Texture("botoes/andar.png"), btnAndarx, btnAndary, btnTamanho);
		btnAtack = new Butao(new Texture("botoes/atirarE.png"), btnAtackx, btnAtacky, btnTamanho);
		btnPular = new Butao(new Texture("botoes/pular.png"), btnPularx, btnPulary, btnTamanho );
		fundo = new PlanoDeFundo();
		batch = new SpriteBatch();
		personagemAEscolher = new Diego(persIni, (int) (SCREENY/2.25), quantidadeDeTextura);

	}

	@Override
	public void render () {
		this.andando = false;
		this.atacando = false;
		this.pulando = false;

		input();
		update(Gdx.graphics.getDeltaTime());
		limparTela();
		batch.begin();

		draw(batch);

		batch.end();
	}

	private void draw(SpriteBatch batch) {
		fundo.draw(batch);
		personagemAEscolher.draw(batch);

		btnStart.draw(batch);
		btnAtack.draw(batch);
		btnPular.draw(batch);
	}

	private void update(float time) {
		fundo.update(time, isAndando());
		personagemAEscolher.update(quantidadeDeTextura ,time, isAndando(), isAtacando(), isPulando());
	}

	@Override
	public void dispose () {
		fundo.dispose();
	}

	private boolean isAndando () {
		return andando;
	}

	private boolean isAtacando() {
		return atacando;
	}

	private boolean isPulando() {
		return pulando;
	}

	private void input() {
		if (Gdx.input.isTouched()){
			int x = Gdx.input.getX();
			int y = SCREENY - Gdx.input.getY();

			andando = btnStart.isClicado(x, y);
			atacando = btnAtack.isClicado(x, y);
			pulando = btnPular.isClicado(x , y);

		}
	}

	private void limparTela() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}


}
