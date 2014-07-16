package com.rndspell.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.rndspell.game.GameAssetManager;

public class LoadScreen implements Screen {

    public LoadScreen(){}

    private void loadAssets(){
        GameAssetManager.getInstance().load("badlogic.jpg", Texture.class);
    }

    @Override
    public void render(float delta) {
        if(GameAssetManager.getInstance().update()){
            ScreenManager.getInstance().show(CustomScreen.MAIN_MENU);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        GameAssetManager.getInstance().init();
        loadAssets();
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
