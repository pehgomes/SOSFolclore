package com.touch.game.com.touch.game.personagens;

import com.badlogic.gdx.graphics.Texture;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Diego extends Personagem {


    public Diego(Texture personaParado ,int posx, int posy, int quantidadeDeTexturas) {
        super(personaParado ,posx, posy, quantidadeDeTexturas);
    }

    @Override
    public Texture getMovimentacaoPersonagem(int i) {
        return  new Texture("personas/diego/andar/walk"+i+".png");
    }

    @Override
    public Texture getAtackPersonagem(int i) throws NotImplementedException {
        return new Texture("personas/diego/atacar/datack"+i+".png");
    }

    @Override
    public Texture getPuloPersonagem(int i) throws NotImplementedException {
        return null;
    }
}
