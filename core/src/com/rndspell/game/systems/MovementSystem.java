package com.rndspell.game.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.rndspell.game.components.MovementComponent;
import com.rndspell.game.components.PositionComponent;

public class MovementSystem extends IteratingSystem {

    public MovementSystem() {
        super(Family.getFamilyFor(PositionComponent.class, MovementComponent.class));
    }

    @Override
    public void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = entity.getComponent(PositionComponent.class);
        MovementComponent movement = entity.getComponent(MovementComponent.class);

        movement.getVelocity().add(movement.getAcceleration().cpy().scl(deltaTime));
        if(movement.getVelocity().len() > movement.getMaxVelocity()){
            movement.getVelocity().limit(movement.getMaxVelocity());
        }
        position.getPosition().add(movement.getVelocity().cpy().scl(deltaTime));
    }
}
