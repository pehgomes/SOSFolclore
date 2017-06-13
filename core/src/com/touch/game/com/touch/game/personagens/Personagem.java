package com.touch.game.com.touch.game.personagens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.touch.game.com.touch.game.interfaces.Ser;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static com.touch.game.Constantes.*;


public abstract class Personagem implements Ser {

    Circle corpo;

    Texture[] frames;

    float auxiliarDeFrames;

    Vector2 velocidade;


    public Personagem(int posx, int posy, int quantidadeDeTexturas) {
        corpo = new Circle(posx, posy, personagem);
        frames = new Texture[quantidadeDeTexturas];

        for (int i =1; i <= quantidadeDeTexturas;i++) {
            frames[i-1] = getMovimentacaoPersonagem(i);
        }

        velocidade = new Vector2(0,0);
        velocidade.y = -impulso;
    }

    public abstract Texture getMovimentacaoPersonagem(int i) throws NotImplementedException;

    public void draw(SpriteBatch batch) {
        batch.draw(frames[(int)auxiliarDeFrames%3], corpo.x - corpo.radius, corpo.y - corpo.radius,
                corpo.radius * 2, corpo.radius*2);
    }

    public void update(float time) {
        auxiliarDeFrames += 3*time;
        corpo.x += velocidade.x * time;
        corpo.y += velocidade.y * time;

        velocidade.y -= decVeloy * time;

        if (corpo.y + corpo.radius > SCREENY) {
            corpo.y = SCREENY - corpo.radius;
            velocidade.y = -impulso;
        }

        if (corpo.y - corpo.radius <= SCREENY) {
            corpo.y = corpo.radius;
            velocidade.y = impulso;
        }
    }

    public void impulso() {
        velocidade.y += impulso;
    }

    public void dispose() {
        for (int i = 0;i<= 2;i++) {
           frames[i].dispose();
        }
    }
}
