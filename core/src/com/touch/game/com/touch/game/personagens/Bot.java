package com.touch.game.com.touch.game.personagens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static com.touch.game.Constantes.personagem;

/**
 * Created by root on 18/06/17.
 */

public class Bot extends Personagem {

    private Circle corpo;

    Texture textura;

    Texture[] frames;


    public Bot(Texture personaParado ,int posx, int posy, int quantidadeDeTexturasInicial) {
        corpo = new Circle(posx, posy, personagem);
        textura = personaParado;
        velocidade = new Vector2(0,0);

        this.quantidadeDeTexturas = quantidadeDeTexturasInicial;
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
        // batch.draw(textura, corpo.x, corpo.y, corpo.radius * 2, corpo.radius * 2);
        batch.draw(frames[(int) auxiliarDeFrames % quantidadeDeTexturas], posx, posy,
                corpo.radius * 2, corpo.radius * 2);
    }

    @Override
    public void update(int quantidadeDeTexturas, float time, boolean movimentou, boolean atacou, boolean pulou) {
        auxiliarDeFrames += this.quantidadeDeTexturas*time;
        corpo.x += velocidade.x * time;
        corpo.y += velocidade.y * time;
        andar();
     }

    public void andar(){
        corpo = new Circle(posx, posy, personagem);
        frames = new Texture[quantidadeDeTexturas];

        for (int i =1; i <= quantidadeDeTexturas;i++) {
            frames[i-1] = getMovimentacaoPersonagem(i);
        }

    }

    public void dispose() {
        for (int i = 0;i<= quantidadeDeTexturas;i++) {
            frames[i].dispose();
        }
    }

    @Override
    public Circle getCorpoPersonagem() {
        return corpo;
    }
}
