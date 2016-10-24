package com.test.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.Random;
import java.util.Set;

/**
 * Created by radiva on 11/10/16.
 */
public class Gamenya extends GameScreen {

    Skin skin;
    Stage stage;
    SpriteBatch batch;
    Deck dek;
    Hand tangan,discard;
    int last = 0;

    public Gamenya(Game game) {
        super(game);
    }

    public void create() {

        dek = new Deck();
        dek.shuffle();
        tangan = new Hand();
        tangan.clear();

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        batch.getProjectionMatrix().setToOrtho2D(0, 0, 480, 854);

        skin = new Skin();

        Pixmap pixmap = new Pixmap(100,100, Pixmap.Format.RGB888);
        pixmap.setColor(Color.GREEN);
        pixmap.fill();

        skin.add("White", new Texture(pixmap));

        BitmapFont bfont = new BitmapFont();
        bfont.getData().setScale(1);
        skin.add("Default",bfont);

        TextButton.TextButtonStyle BtnStyle = new TextButton.TextButtonStyle();
        BtnStyle.up = skin.newDrawable("White", Color.DARK_GRAY);
        BtnStyle.down = skin.newDrawable("White", Color.DARK_GRAY);

        BtnStyle.font = skin.getFont("Default");

        skin.add("default", BtnStyle);

        final TextButton Btn = new TextButton("DRAW",BtnStyle);
        Btn.setPosition(240,420);
        stage.addActor(Btn);

        Btn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //dek.draw();
                tangan.tbhKartu(dek.draw());
            }
        });

        for(int i=0; i<7; i++) {
            tangan.tbhKartu(dek.draw());
        }

        discard.tbhKartu(dek.draw());
        discard.getKartu(last).setPosition(200,425);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        int j = tangan.jmlHand();
        int t = 480/j;
        for (int i = 0; i < tangan.jmlHand(); i++) {
            tangan.getKartu(i).getGbr().setPosition(100,t*(i+1));
            final int index = i;
            tangan.getKartu(i).addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x,float y) {
                    if(tangan.getKartu(index).getAngka() == discard.getKartu(last).getAngka() || tangan.getKartu(index).getWarna() == discard.getKartu(last).getWarna()) {
                        discard.tbhKartu(tangan.getKartu(index));
                        discard.getKartu(last).setPosition(200,425);
                        tangan.keluarKartu(index);
                        last++;
                    }
                }
            });
        }

        batch.begin();
        //batch.draw();
        batch.end();
    }

}
