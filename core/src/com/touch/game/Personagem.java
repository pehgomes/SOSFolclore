package com.touch.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import static com.touch.game.Constantes.*;

/**
 * Created by pedro on 23/05/17.
 */

public class Personagem {

    public Circle corpo;

    private Texture[] frames;

    private float auxiliarDeFrames;

    private Vector2 velocidade;

    public Personagem( int posx, int posy) {
        corpo = new Circle(posx, posy, personagem);

        frames = new Texture[3];
        for (int i =1; i<=3;i++) {
            frames[i-1] = new Texture("personas/dwalk"+i+".png");
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(frames[(int)auxiliarDeFrames%3], corpo.x - corpo.radius, corpo.y - corpo.radius,
                corpo.radius * 2, corpo.radius*2);
    }

    public void update(float time) {
        auxiliarDeFrames += 3*time;

    }

    public void dispose() {
        for (int i = 0;i<= 2;i++) {
           frames[i].dispose();
        }
    }
}
