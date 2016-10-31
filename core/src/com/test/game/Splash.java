package com.test.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.test.game.MyTestGame;

/**
 * Created by radiva on 26/09/16.
 */
public class Splash extends GameScreen {
    TextureRegion splsh;
    SpriteBatch batch;
    float time = 0;

    public Splash(Game game) {
        super(game);
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        splsh = new TextureRegion(new Texture(Gdx.files.internal("ss.png")));
        batch.getProjectionMatrix().setToOrtho2D(0, 0, 480, 854);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(splsh,0,0);
        batch.end();

        time += v;
        if(time >= 5)
            game.setScreen(new MainGame(game));
    }

    @Override
    public void hide() {
        Gdx.app.debug("Test", "DisposeSplash");
        batch.dispose();
        splsh.getTexture().dispose();
    }

}
