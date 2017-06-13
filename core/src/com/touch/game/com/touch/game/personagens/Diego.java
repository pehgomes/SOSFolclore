package com.touch.game.com.touch.game.personagens;

import com.badlogic.gdx.graphics.Texture;

public class Diego extends Personagem {


    public Diego(int posx, int posy, int quantidadeDeTexturas) {
        super(posx, posy, quantidadeDeTexturas);
    }

    @Override
    public Texture getMovimentacaoPersonagem(int i) {
        return  new Texture("personas/diego/andar/walk"+i+".png");
    }
}
