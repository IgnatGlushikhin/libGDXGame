package com.rndspell.game.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.rndspell.game.components.GravityComponent;
import com.rndspell.game.components.MovementComponent;
import com.rndspell.game.components.PositionComponent;

public class GravitySystem extends IteratingSystem {

    GravityComponent gravity;
    MovementComponent movement;

    public GravitySystem(){
        super(Family.getFamilyFor(GravityComponent.class, MovementComponent.class));
    }

    @Override
    public void processEntity(Entity entity, float deltaTime) {
        gravity = entity.getComponent(GravityComponent.class);
        movement = entity.getComponent(MovementComponent.class);
        movement.getVelocity().add(gravity.getGravity().cpy().scl(deltaTime));
    }
}
