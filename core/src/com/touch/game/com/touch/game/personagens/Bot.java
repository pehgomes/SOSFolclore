package com.touch.game.com.touch.game.personagens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static com.touch.game.Constantes.SCREENX;
import static com.touch.game.Constantes.SCREENY;
import static com.touch.game.Constantes.gravidade;
import static com.touch.game.Constantes.impulso;
import static com.touch.game.Constantes.personagem;

/**
 * Created by root on 18/06/17.
 */

public class Bot extends Personagem {

    private Circle corpo;

    Texture textura;


    public Bot(Texture personaParado ,int posx, int posy, int quantidadeDeTexturasInicial) {
        this.posx = posx;
        this.posy = posy;
        this.quantidadeDeTexturas = quantidadeDeTexturasInicial;
        velocidade = new Vector2(0,0);
        velocidade.y = -impulso;
        textura = personaParado;
        corpo = new Circle(posx, posy, personagem);
    }

    @Override
    public Texture getMovimentacaoPersonagem(int i) throws NotImplementedException {
        return new Texture("personas/bot/bot"+i+".png");
    }

    @Override
    public Texture getAtackPersonagem(int i) throws NotImplementedException {
        return null;
    }

    @Override
    public Texture getPuloPersonagem(int i) throws NotImplementedException {
        return null;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(textura, corpo.x, corpo.y, corpo.radius * 2, corpo.radius * 2);
    }

    @Override
    public void update(int quantidadeDeTexturas, float time, boolean movimentou, boolean atacou, boolean pulou) {
        corpo.x += velocidade.x * time;
        corpo.y += velocidade.y * time;

        velocidade.y -= gravidade * time;

        if (corpo.y + corpo.radius > SCREENY) {
            corpo.y = SCREENY - corpo.radius;
            velocidade.y = -impulso;
        }

        if (corpo.y - corpo.radius <= SCREENY) {
            corpo.y = corpo.radius;
            velocidade.y = impulso;
        }


     }

     public void caminhar() {
         velocidade.y += impulso;
     }

    @Override
    public void dispose() {
        textura.dispose();
    }
}
