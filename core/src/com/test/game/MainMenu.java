package com.test.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


/**
 * Created by radiva on 03/10/16.
 */
public class MainMenu extends GameScreen {
    Game game;
    public MainMenu(Game game) {
        super(game);
        create();
    }

    TextureRegion menu;
    SpriteBatch batch;
    Skin skin;
    Stage stage;
    //float time = 0;

    public void create() {
        menu = new TextureRegion(new Texture(Gdx.files.internal("menu.png")));
        batch = new SpriteBatch();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
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
        BtnStyle.checked = skin.newDrawable("White", Color.BLUE);
        BtnStyle.over = skin.newDrawable("White", Color.LIGHT_GRAY);

        BtnStyle.font = skin.getFont("Default");

        skin.add("default", BtnStyle);

        final TextButton Btn = new TextButton("MAIN",BtnStyle);
        Btn.setPosition(240,240);
        stage.addActor(Btn);

        Btn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //Btn.setText("Bisa");
                game.setScreen(new Gamenya(game));
            }
        });
    }

    @Override
    public void show () {
        //menu = new TextureRegion(new Texture(Gdx.files.internal("1.jpg")), 0, 0, 480, 854);
        //batch = new SpriteBatch();
        //batch.getProjectionMatrix().setToOrtho2D(0, 0, 480, 854);
    }

    @Override
    public void resize(int width, int height) {
//        super.resize(width,height);
//        final float buttonX = (width - BUTTON_WIDTH) / 2;
//        float currentY = 280f;
//
//        //Main
//        TextButton MainBtn = new TextButton("Main");
//        MainBtn.x = buttonX;
//        MainBtn.y = currentY;
//        MainBtn.width = BUTTON_WIDTH;
//        MainBtn.height = BUTTON_HEIGHT;
//        stage.addActor(MainBtn);
        stage.getViewport().update(width,height,false);

    }

    @Override
    public void render (float delta) {
        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //batch.begin();
        //batch.draw(intro, 0, 0);
        //batch.end();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(menu, 0, 0);
        batch.end();

       //Gdx.gl.glClear(0.2f,0.2f,0.2f,1);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(),1/30f));
        stage.draw();
        //Table.drawDebug(stage);
    }

    @Override
    public void hide () {
        //Gdx.app.debug("Cubocy", "dispose intro");
        //batch.dispose();
        //intro.getTexture().dispose();
        batch.dispose();
        stage.dispose();
        skin.dispose();
    }

}
