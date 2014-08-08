package com.rndspell.game.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import com.badlogic.ashley.utils.ImmutableIntMap;
import com.rndspell.game.ListenerManager;
import com.rndspell.game.components.BoundsComponent;
import com.rndspell.game.components.MovementComponent;
import com.rndspell.game.components.PositionComponent;
import com.rndspell.game.events.CollisionEvent;

public class CollisionSystem extends EntitySystem {

    private ImmutableIntMap<Entity> movedEntities;
    private ImmutableIntMap<Entity> entities;

    BoundsComponent bounds;
    PositionComponent position;
    MovementComponent movement;
    BoundsComponent oBounds;

    Signal<CollisionEvent> signal = new Signal<CollisionEvent>();

    public CollisionSystem() {
        super();
        for (Listener listener: ListenerManager.getInstance().getListeners().get(CollisionEvent.class)) {
            signal.add(listener);
        }
    }

    public void addedToEngine(Engine engine) {
        movedEntities = engine.getEntitiesFor(Family.getFamilyFor(BoundsComponent.class, PositionComponent.class, MovementComponent.class));
        entities = engine.getEntitiesFor(Family.getFamilyFor(BoundsComponent.class));
    }

    @Override
    public void update(float deltaTime) {

        for(Entity entity: movedEntities.values()){
            bounds = entity.getComponent(BoundsComponent.class);
            position = entity.getComponent(PositionComponent.class);
            movement = entity.getComponent(MovementComponent.class);

            for (Entity otherEntity: entities.values()) {
                oBounds = otherEntity.getComponent(BoundsComponent.class);
                if (!otherEntity.equals(entity) && !oBounds.isPassable()) {
                    //Y COLLISION
                    if (movement.getVelocity().y < 0 && oBounds.getBounds().getY() + oBounds.getBounds().getHeight() < position.getPosition().y + bounds.getBoundsOffset().y + 1) {
                        if (bounds.getBounds().overlaps(oBounds.getBounds())) {
                            position.getPosition().y = oBounds.getBounds().getY() + oBounds.getBounds().getHeight() - bounds.getBoundsOffset().y;
                            movement.getVelocity().y = 0;
                            bounds.getBounds().setY(position.getPosition().y + bounds.getBoundsOffset().y);
                            signal.dispatch(new CollisionEvent(new Entity[] {entity, otherEntity}));
                        }
                    } else if (movement.getVelocity().y > 0 && oBounds.getBounds().getY() > bounds.getBounds().getHeight() + position.getPosition().y + bounds.getBoundsOffset().y - 1) {
                        if (bounds.getBounds().overlaps(oBounds.getBounds())) {
                            position.getPosition().y = oBounds.getBounds().getY() - bounds.getBounds().getHeight() - bounds.getBoundsOffset().y;
                            movement.getVelocity().y = 0;
                            bounds.getBounds().setY(position.getPosition().y + bounds.getBoundsOffset().y);
                            signal.dispatch(new CollisionEvent(new Entity[] {entity, otherEntity}));

                        }
                    }
                    //X COLLISION
                    if (movement.getVelocity().x < 0 && oBounds.getBounds().getX() + oBounds.getBounds().getWidth() < position.getPosition().x + bounds.getBoundsOffset().x + 1) {
                        if (bounds.getBounds().overlaps(oBounds.getBounds())) {
                            position.getPosition().x = oBounds.getBounds().getX() + oBounds.getBounds().getWidth() - bounds.getBoundsOffset().x;
                            movement.getVelocity().x = 0;
                            bounds.getBounds().setX(position.getPosition().x + bounds.getBoundsOffset().x);
                            signal.dispatch(new CollisionEvent(new Entity[] {entity, otherEntity}));

                        }
                    } else if (movement.getVelocity().x > 0 && oBounds.getBounds().getX() > position.getPosition().x + bounds.getBounds().getWidth() + bounds.getBoundsOffset().x - 1) {
                        if (bounds.getBounds().overlaps(oBounds.getBounds())) {
                            position.getPosition().x = oBounds.getBounds().getX() - bounds.getBounds().getWidth() - bounds.getBoundsOffset().x;
                            movement.getVelocity().x = 0;
                            bounds.getBounds().setX(position.getPosition().x + bounds.getBoundsOffset().x);
                            signal.dispatch(new CollisionEvent(new Entity[] {entity, otherEntity}));

                        }
                    }
                }
            }
        }
    }
}
