package com.touch.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.touch.game.com.touch.game.botao.Butao;
import com.touch.game.com.touch.game.interfaces.Ser;
import com.touch.game.com.touch.game.objetos.Municao;
import com.touch.game.com.touch.game.personagens.Bot;
import com.touch.game.com.touch.game.personagens.Diego;
import com.touch.game.com.touch.game.personagens.Victoria;


import static com.touch.game.Constantes.*;



public class MyGdxGame extends ApplicationAdapter {

	private Butao btnStart;

	private Butao btnAtack;

	private Butao btnPular;

	private Municao pedrinha;

	private PlanoDeFundo fundo;

	private SpriteBatch batch;

	private Ser personagemAEscolher;

    private Ser bot1;

	private boolean andando ;

	private boolean atacando;

	private boolean pulando;

	private int quantidadeDeTextura;

	String personagemEscolhido;

	@Override
	public void create () {
		this.quantidadeDeTextura = 3;
		batch = new SpriteBatch();
		btnStart = new Butao(new Texture("botoes/andar.png"), btnAndarx, btnAndary, btnTamanho);
		btnAtack = new Butao(new Texture("botoes/atirarE.png"), btnAtackx, btnAtacky, btnTamanho);
		btnPular = new Butao(new Texture("botoes/pular.png"), btnPularx, btnPulary, btnTamanho );
        fundo = new PlanoDeFundo();
        personagemAEscolher = new Diego(new Texture("personas/diego/andar/walk1.png") ,(int) 0.99f * SCREENY, (int) (SCREENY/2.45 ), quantidadeDeTextura);
        bot1 = new Bot(new Texture("personas/bot/bot1.png") ,(int) 0.99f * SCREENY, (int) (SCREENY/2.45 ), 3);
        pedrinha = new Municao((int) personagemAEscolher.getCorpoPersonagem().x ,(int) personagemAEscolher.getCorpoPersonagem().y);

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

        pedrinha.draw(batch);

        bot1.draw(batch);

		btnStart.draw(batch);
		btnAtack.draw(batch);
		btnPular.draw(batch);
	}

	private void update(float time) {
		fundo.update(time, isPersonaAndando());
		personagemAEscolher.update(quantidadeDeTextura , time, isPersonaAndando(), isPersonaAtacando(), isPersonaPulando());
        bot1.update(quantidadeDeTextura , time, isPersonaAndando(), isPersonaAtacando(), isPersonaPulando());
        pedrinha.update(time ,isPersonaAndando());
	}

	@Override
	public void dispose () {
		fundo.dispose();
		personagemAEscolher.dispose();
        pedrinha.dispose();
        bot1.dispose();
	}

	private boolean isPersonaAndando () {
		return andando;
	}

	private boolean isPersonaAtacando() {
		return atacando;
	}

	private boolean isPersonaPulando() {
		return pulando;
	}

	private void input() {
        int x = Gdx.input.getX();
		int y = SCREENY - Gdx.input.getY();
		if (Gdx.input.isTouched()){
			andando = btnStart.isClicado(x, y);

            atacando = btnAtack.isClicado(x, y);
            pulando = btnPular.isClicado(x, y);

            if (atacando) {
                pedrinha.atirar();
                bot1.caminhar();
            }
		}
	}

	private void limparTela() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}


}
