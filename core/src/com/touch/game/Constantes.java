package com.touch.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by pedro on 23/05/17.
 */

public class Constantes {

    public static int SCREENX = Gdx.graphics.getWidth();
    public static int SCREENY = Gdx.graphics.getHeight();

    public static float canovelx_= -0.1f*SCREENX;
    public static int personagem = (int) (0.08f*SCREENY);
    public static int pedrinha = (int) (0.09f*SCREENY);
    public static int persIni = (int) 0.99f * SCREENY;
    public static int persBotIni = (int) 4.2f * SCREENY;

    public static float gravidade = SCREENY/1.5f;

    public static float impulso = SCREENY/5;

    public static int btnTamanho = (int)(0.09f* SCREENX);

    public static int btnAndarx = (int) (0.09f*SCREENX);
    public static int btnAndary = (SCREENX - btnTamanho) /7;

    public static int btnAtackx = (int) (0.9f*SCREENX);
    public static int btnAtacky = (SCREENX - btnTamanho) /7;

    public static int btnPularx = (int) (0.8f*SCREENX);
    public static int btnPulary = (int) ((SCREENX - btnTamanho) /9.3f);

}
