package com.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by radiva on 20/10/16.
 */
public class Kartu extends Image {
    public final static int BLUE = 0;
    public final static int RED = 1;
    public final static int YELLOW = 2;
    public final static int GREEN = 3;
    public final static int DRAW2 = 4;
    public final static int REVERSE = 5;
    public final static int SKIP = 6;
    public final static int WILD = 7;
    public final static int WILD4 = 8;


    private int warna;
    private int angka;

    public Kartu(TextureRegion textureRegion) {
        super(textureRegion);
    }

    //Sprite gbr;

//    public Kartu() {
//        warna = WILD;
//        angka = 1;
//        //gbr = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("cards.png")),0,0,0,0));
//    }

    public void setKartu(int angkanya, int warnanya) {
        angka = angkanya;
        warna = warnanya;
//        if(imagenya == null) {
//            gbr = new Sprite(new TextureRegion(new Texture(Gdx.files.internal("cards.png")),0,462,80,115));
//        } else {
//            gbr = imagenya;
//        }
    }

    public int getWarna() {
        return warna;
    }

    public int getAngka() {
        return angka;
    }

//    public Sprite getGbr() {
//        return gbr;
//    }
}
