package com.rndspell.game.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableIntMap;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rndspell.game.components.PositionComponent;
import com.rndspell.game.components.RenderComponent;

public class RenderSystem extends EntitySystem {

    private ImmutableIntMap<Entity> entities;

    private OrthographicCamera camera;
    private SpriteBatch batch;

    private boolean debug = false;

    public RenderSystem(OrthographicCamera camera){
        this.camera = camera;
        this.batch = new SpriteBatch();
    }

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.getFamilyFor(PositionComponent.class, RenderComponent.class));
    }

    @Override
    public void removedFromEngine(Engine engine) {
        super.removedFromEngine(engine);
    }

    @Override
    public void update(float deltaTime) {

        PositionComponent position;
        RenderComponent render;

        Gdx.gl.glClearColor(0.7f, 0.7f, 0.7f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        camera.update();

        batch.begin();

        for(Entity entity: entities.values()){
            position = entity.getComponent(PositionComponent.class);
            render = entity.getComponent(RenderComponent.class);
            batch.draw(render.getFrame(),  position.getPosition().x + render.getFrameOffset().x, position.getPosition().y + render.getFrameOffset().y, render.getWidth(), render.getHeight());
        }

        batch.end();

    }

}
