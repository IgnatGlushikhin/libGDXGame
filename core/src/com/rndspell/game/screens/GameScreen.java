package com.rndspell.game.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.rndspell.game.GameAssetManager;
import com.rndspell.game.components.MovementComponent;
import com.rndspell.game.components.PositionComponent;
import com.rndspell.game.components.RenderComponent;
import com.rndspell.game.systems.MovementSystem;
import com.rndspell.game.systems.RenderSystem;

public class GameScreen implements Screen {

    Engine engine;
    OrthographicCamera camera;

    public void render(float delta) {

        engine.update(delta);

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

        camera = new OrthographicCamera(640, 480);

        engine = new Engine();

        engine.addSystem(new MovementSystem());
        engine.addSystem(new RenderSystem(camera));

        Entity player = new Entity();
        player.add(new PositionComponent());
        player.add(new MovementComponent(8f, 32f));
        player.add(new RenderComponent(new Vector2()));

        engine.addEntity(player);
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
