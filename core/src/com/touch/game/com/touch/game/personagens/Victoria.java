package com.touch.game.com.touch.game.personagens;

import com.badlogic.gdx.graphics.Texture;



public class Victoria extends Personagem {


    public Victoria(int posx, int posy, int quantidadeDeTexturas) {
        super(posx, posy, 3);
    }

    @Override
    public Texture getMovimentacaoPersonagem(int i)  {
        return new Texture("personas/victoria/andar/walk"+i+".png");
    }
}
