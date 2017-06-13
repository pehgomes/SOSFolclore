package com.touch.game.com.touch.game.interfaces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public interface Ser {

    void update(float tempo);

    void impulso();

    void draw(SpriteBatch batch);

    void dispose();
}
