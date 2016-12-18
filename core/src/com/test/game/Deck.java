package com.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by radiva on 20/10/16.
 */
public class Deck {

    private Kartu[] dek = new Kartu[76];
    private int KartuKeluar;

    public Deck() {
        int CKartu = 0;
        for(int w = 0; w<4; w++) {
            for(int a=1; a<20; a++) {
                //dek[CKartu] = new Kartu(a%10,w,new Sprite(new TextureRegion(new Texture(Gdx.files.internal("cards.png")),800-((a%10+1)*80),w*115,80,115)));
                dek[CKartu] = new Kartu(new TextureRegion(new Texture(Gdx.files.internal("cards.png")),800-((a%10+1)*80),w*115,80,115));
                dek[CKartu].setKartu(a%10,w);
                CKartu++;
            }
        }

        /*
        for(int w=4; w<7; w++) {
            for(int a=10; a<18; a++) {
                dek[CKartu] = new Kartu(a,w,null);
            }
        }

        for(int w=7; w<9; w++) {
            for(int a=18; a<22; a++) {
                dek[CKartu] = new Kartu(a,w,null);
            }
        }
        */
    }

    public void shuffle() {
        for ( int i = dek.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Kartu temp = dek[i];
            dek[i] = dek[rand];
            dek[rand] = temp;
        }

        for ( int i = 0; i < dek.length; i++ ) {
            int rand = (int)(Math.random()*(dek.length));
            Kartu temp = dek[i];
            dek[i] = dek[rand];
            dek[rand] = temp;
        }

        KartuKeluar = 0;
    }

    public Kartu draw() {
        if(KartuKeluar == dek.length)
            throw new IllegalStateException("Kartu Habis");
        KartuKeluar++;
        return dek[KartuKeluar - 1];
    }

    public int sisa() {
        return dek.length - KartuKeluar;
    }
}
