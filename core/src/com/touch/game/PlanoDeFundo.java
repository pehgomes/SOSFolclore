package com.touch.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.touch.game.Constantes.*;

/**
 * Created by root on 22/05/17.
 */

public class PlanoDeFundo {
    private Texture frames;

    private float positionx;
    private float positiony;

    public PlanoDeFundo () {
        frames = new Texture("fundo/fundop3.png");

        positionx = 0;
        positiony = SCREENX;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(frames, positionx, 0, SCREENX, SCREENY);
        batch.draw(frames, positiony, 0, SCREENX, SCREENY);
    }

    public void update(float time, boolean andando) {
        if (andando) {
            positionx += time * canovelx_;
            positiony += time * canovelx_;

            if (positionx + SCREENX <= 0) {
                positionx = SCREENX;
                positiony = 0;
            }

            if (positiony + SCREENX <= 0) {
                positiony = SCREENX;
                positionx = 0;
            }

        }
    }


    public void dispose() {
        frames.dispose();
    }
}
