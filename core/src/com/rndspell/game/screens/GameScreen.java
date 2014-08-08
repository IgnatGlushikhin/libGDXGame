package com.rndspell.game.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.rndspell.game.GameAssetManager;
import com.rndspell.game.components.*;
import com.rndspell.game.systems.*;

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
        camera.position.set(-64, 64, 0);
        engine = new Engine();

        FrictionSystem frictionSystem = new FrictionSystem();
        RenderBoundsSystem renderBoundsSystem = new RenderBoundsSystem(camera);
        CollisionSystem collisionSystem = new CollisionSystem();

        engine.addSystem(new GravitySystem());
        engine.addSystem(new MovementSystem());
        engine.addSystem(new BoundsSystem());
        engine.addSystem(frictionSystem);
        engine.addSystem(collisionSystem);
        engine.addSystem(new CameraSystem(camera));
        engine.addSystem(new RenderSystem(camera));
//        engine.addSystem(renderBoundsSystem);

        InputSystem inputSystem = new InputSystem();
        engine.addSystem(inputSystem);

        Entity player = new Entity();
        player.add(new PositionComponent(new Vector2(-32, 128)));
        player.add(new MovementComponent(256f, 256f));
        player.add(new BoundsComponent(64f, 64f, new Vector2(-32f, -32f), true));
        player.add(new RenderComponent(GameAssetManager.getInstance().get("textures/textures.atlas", TextureAtlas.class).findRegion("smile"), 64, 64, new Vector2(-32, -32)));
        player.add(new InputControlComponent(true));
        player.add(new GravityComponent(new Vector2(0, -128f)));
        player.add(new CameraComponent(true));

        Entity player1 = new Entity();
        player1.add(new PositionComponent(new Vector2(64, 128)));
        player1.add(new MovementComponent(256f, 128f));
        player1.add(new BoundsComponent(64f, 64f, new Vector2(-32f, -32f), true));
        player1.add(new RenderComponent(GameAssetManager.getInstance().get("textures/textures.atlas", TextureAtlas.class).findRegion("smile"), 64, 64, new Vector2(-32, -32)));
        player1.add(new InputControlComponent(true));
        player1.add(new GravityComponent(new Vector2(0, -128f)));
        player1.add(new CameraComponent(true));

        engine.addEntity(player);
        engine.addEntity(player1);

        for(int i=0; i< 20; i++){
            Entity entity = new Entity();
            entity.add(new PositionComponent(new Vector2(-192 + i * 64, 0)));
            entity.add(new BoundsComponent(64f, 64f, new Vector2(-32f, -32f), false));
            entity.add(new FrictionComponent(128));
            entity.add(new RenderComponent(GameAssetManager.getInstance().get("textures/textures.atlas", TextureAtlas.class).findRegion("null"), 64, 64, new Vector2(-32, -32)));
            engine.addEntity(entity);
        }

        Gdx.input.setInputProcessor(inputSystem);
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
