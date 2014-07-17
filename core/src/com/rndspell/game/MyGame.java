package com.rndspell.game;

import com.badlogic.gdx.Game;
import com.rndspell.game.screens.CustomScreen;
import com.rndspell.game.screens.ScreenManager;

public class MyGame extends Game {

	@Override
	public void create () {
        ScreenManager.getInstance().init(this);
        ScreenManager.getInstance().show(CustomScreen.LOAD_SCREEN);
	}

}

