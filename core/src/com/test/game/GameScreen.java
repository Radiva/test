package com.test.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

/**
 * Created by radiva on 03/10/16.
 */
public abstract class GameScreen implements Screen {
    Game game;

    public GameScreen(Game game) {
        this.game = game;
    }

    @Override
    public void resize (int width, int height) {
    }

    @Override
    public void show () {
    }

    @Override
    public void hide () {
    }

    @Override
    public void pause () {
    }

    @Override
    public void resume () {
    }

    @Override
    public void dispose () {
    }
}
