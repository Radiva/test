package com.test.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import java.util.Random;
import java.util.Set;

/**
 * Created by radiva on 11/10/16.
 */
public class Gamenya extends GameScreen {

    Skin skin;
    Stage stage;

    public Gamenya(Game game) {
        super(game);
    }

    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

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
                drawCard();
            }
        });
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }


    public enum Cards{

        ACE_HEART("ACE_HEART.png"),
        HEART_2("2_HEART.png"),
        HEART_3("3_HEART.png");


        private final String name;
        Cards(String name) { this.name = name; }
        public int getValue() { return name; }
    }

    public class Card extends Actor{
        float width, height;
        Sprite cardSprite;

        public Card(Cards cardType){
            cardSprite = new Sprite(new Texture(Gdx.files.internal(cardType.getValue())));
            this.width = cardSprite.getWidth();
            this.height = cardSprite.getHeight();
        }
    }

    Set<Card> allCards = {Cards("HEART_2"),Cards("ACE_HEART")};

    //assign listeners
    for(Card card : allCards)
            card.addListener(new ClickListener(){
        @Override
        public void clicked(InputEvent event, float x, float y) {
            //Gdx.app.log("Clicked card at", x + "   " + y);
        }
    });

    // now create a list for the player
    Set<Card> playersHand = new SomeSet<>();

    void drawCard() {
        playersHand.add(allCards.get(new Random().nextInt(allCards.size() - 1));
    }
}
