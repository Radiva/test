package com.test.game;

import com.badlogic.gdx.Game;

/**
 * Created by radiva on 03/10/16.
 */

public class Mulai extends Game{
    @Override
    public void create() {
        setScreen(new Splash(this));
    }
}
