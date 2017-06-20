package com.touch.game.com.touch.game.objetos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import static com.touch.game.Constantes.*;

/**
 * Created by root on 17/06/17.
 */

public class Municao {

    private Circle objeto;

    private Texture textura;

    Vector2 velocidade;

    private float posXOponente;

    private float posYOponente;

    private boolean atirou;

    public Municao (int posx, int posy) {
        objeto = new Circle(posx, posy, personagem);
        textura = new Texture("personas/diego/objetos/pedra1.png");
        velocidade = new Vector2(0,0);
    }

    public void draw(SpriteBatch batch){
        batch.draw(textura, objeto.x, objeto.y, objeto.radius * 2, objeto.radius * 2);
    }

    public void update(float time ,boolean isAtirando) {
        objeto.x += velocidade.x * time;
        objeto.y += velocidade.y * time;
        // velocidade.y = gravidade * time; //objeto caindo

        if (objeto.y + objeto.radius >= SCREENX) {
            objeto.y = SCREENY - objeto.radius;
           // velocidade.y -= impulso; //voltar objeto
        }

        if (objeto.y - objeto.radius <= 0) {
            objeto.y = objeto.radius;
            //velocidade.y = impulso;
        }

        if (atirou) {
            if (objeto.x <= posXOponente) {
                objeto.x += velocidade.x * time;
            } else {
                velocidade.y -= SCREENY/8;
                // velocidade.y = gravidade * time;
            }
        }
    }

    public void atirar(Circle corpoOponente) {
        posXOponente = corpoOponente.x;
        posYOponente = corpoOponente.y - SCREENY;
        atirou = true;
        velocidade.x += impulso;
    }

    public void dispose() {
        textura.dispose();
    }
}
