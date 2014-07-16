package com.rndspell.game.screens;

public enum CustomScreen {

    LOAD_SCREEN {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
            return new LoadScreen();
        }
    },

    MAIN_MENU {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
            return new MenuScreen();
        }
    },

    GAME {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
            return new GameScreen();
        }
    },

    BATTLE {
        @Override
        protected com.badlogic.gdx.Screen getScreenInstance() {
            return new BattleScreen();
        }
    };

    protected abstract com.badlogic.gdx.Screen getScreenInstance();

}