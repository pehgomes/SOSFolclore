package com.touch.game.com.touch.game.interfaces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public interface Ser {

    void update(int quantidadeDeTexturas,float tempo, boolean movimentando, boolean atacando, boolean pulando);

    void impulso();

    void draw(SpriteBatch batch);

    void dispose();
}
