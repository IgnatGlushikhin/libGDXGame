package com.rndspell.game.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.rndspell.game.components.BoundsComponent;
import com.rndspell.game.components.MovementComponent;
import com.rndspell.game.components.PositionComponent;

public class BoundsSystem extends IteratingSystem {

    BoundsComponent bounds;
    PositionComponent position;
    MovementComponent movement;

    public BoundsSystem(){
        super(Family.getFamilyFor(BoundsComponent.class, PositionComponent.class));
    }

    @Override
    public void processEntity(Entity entity, float deltaTime) {
        bounds = entity.getComponent(BoundsComponent.class);
        position = entity.getComponent(PositionComponent.class);

        bounds.getBounds().setPosition(position.getPosition().cpy().add(bounds.getBoundsOffset()));

        if(entity.hasComponent(MovementComponent.class)){
            movement = entity.getComponent(MovementComponent.class);
            Vector2 boundsPosition = new Vector2();
            bounds.getBounds().getPosition(boundsPosition).add(movement.getVelocity().cpy().scl(deltaTime));
            bounds.getBounds().setPosition(boundsPosition);
        }
    }
}
