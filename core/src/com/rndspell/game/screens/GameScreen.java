package com.rndspell.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rndspell.game.GameAssetManager;

public class GameScreen implements Screen {

    SpriteBatch batch;
    Texture texture;

    public void render(float delta) {

        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(
            texture,
            Gdx.graphics.getWidth()/2 - texture.getWidth()/2,
            Gdx.graphics.getHeight()/2 - texture.getHeight()/2
        );
        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        texture = GameAssetManager.getInstance().get("badlogic.jpg");
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
