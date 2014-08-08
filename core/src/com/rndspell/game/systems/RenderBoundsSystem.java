package com.rndspell.game.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import com.badlogic.ashley.utils.ImmutableIntMap;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.rndspell.game.ListenerManager;
import com.rndspell.game.components.BoundsComponent;
import com.rndspell.game.events.CollisionEvent;

public class RenderBoundsSystem extends EntitySystem {

    private OrthographicCamera camera;
    private ShapeRenderer boundsRenderer;

    private ImmutableIntMap<Entity> boundsEntities;

    private Listener<CollisionEvent> listener;
    private Array<Entity> collidedEntities = new Array<Entity>();

    public RenderBoundsSystem(OrthographicCamera camera){
        this.camera = camera;
        this.boundsRenderer = new ShapeRenderer();
        init();
    }

    public void init() {
        listener = new Listener<CollisionEvent>() {
            @Override
            public void receive(Signal<CollisionEvent> signal, CollisionEvent collisionEvent) {
                collidedEntities = collisionEvent.getEntities();
            }
        };
        ListenerManager.getInstance().getListeners().get(CollisionEvent.class).add(listener);
    }


    @Override
    public void addedToEngine(Engine engine) {
        boundsEntities = engine.getEntitiesFor(Family.getFamilyFor(BoundsComponent.class));
    }

    @Override
    public void update(float deltaTime) {

        BoundsComponent bounds;

        boundsRenderer.setProjectionMatrix(camera.combined);
        camera.update();

        boundsRenderer.begin(ShapeRenderer.ShapeType.Line);
        boundsRenderer.setColor(Color.BLUE);

        for(Entity entity: boundsEntities.values()){
            if (collidedEntities.contains(entity, true)) {
//                boundsRenderer.setColor(Color.YELLOW);
            } else {
                boundsRenderer.setColor(Color.BLUE);
            }
            bounds = entity.getComponent(BoundsComponent.class);
            boundsRenderer.rect(bounds.getBounds().x, bounds.getBounds().y, bounds.getBounds().getWidth(), bounds.getBounds().getHeight());
        }

        boundsRenderer.end();
    }
}
