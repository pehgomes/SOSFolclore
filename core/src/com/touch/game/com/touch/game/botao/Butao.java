package com.touch.game.com.touch.game.botao;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by root on 15/06/17.
 */

public class Butao {

    private Rectangle but;

    public boolean high = false;

    private float highf = 1.1f;

    private Texture textura;

    public Butao(Texture textura, int posx, int posy, int tamanho) {
        this.textura = textura;
        but = new Rectangle(posx, posy, tamanho, tamanho);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(textura, but.x - (but.getWidth() * (highf - 1)) / 2,
                but.y - (but.getHeight() * (highf - 1))/2,
                but.getWidth()* highf, but.getHeight()*highf);
    }

    public boolean isClicado(int x, int y) {
        if(but.x <= x && but.x + but.width >= x &&
                but.y <= y && but.y + but.height >= y) {
            high = true;
        } else {
            high = false;
        }

        return high;
    }

}
