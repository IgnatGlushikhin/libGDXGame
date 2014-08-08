package com.rndspell.game.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import com.badlogic.ashley.utils.ImmutableIntMap;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import com.rndspell.game.ListenerManager;
import com.rndspell.game.components.FrictionComponent;
import com.rndspell.game.components.MovementComponent;
import com.rndspell.game.events.CollisionEvent;

public class FrictionSystem extends EntitySystem {

    private ImmutableIntMap<Entity> entities;
    private Listener<CollisionEvent> listener;

    private Array<Entity> collidedEntities = new Array<Entity>();
    private float frictionValue = 0;

    public FrictionSystem() {
        super();
        listener = new Listener<CollisionEvent>() {
            @Override
            public void receive(Signal<CollisionEvent> signal, CollisionEvent collisionEvent) {
                collidedEntities = collisionEvent.getEntities();
                for (Entity entity: collidedEntities) {
                    if (entity.hasComponent(FrictionComponent.class)) {
                        frictionValue = entity.getComponent(FrictionComponent.class).getFrictionValue();
                    }

                }

            }
        };
        ListenerManager.getInstance().getListeners().get(CollisionEvent.class).add(listener);
    }

    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.getFamilyFor(FrictionComponent.class));
    }

    @Override
    public void update(float deltaTime) {
        MovementComponent movement;
        for (Entity entity: collidedEntities) {
            if (entity.hasComponent(MovementComponent.class)) {
                movement = entity.getComponent(MovementComponent.class);
                movement.getVelocity().add(movement.getVelocity().cpy().nor().scl(-frictionValue * deltaTime));
//                if (movement.getAcceleration().epsilonEquals(0, 0, 1)) {
//                    movement.getVelocity().add(movement.getVelocity().cpy().nor().scl(-frictionValue * deltaTime));
//                }
            }
        }
        collidedEntities.clear();
    }
}
