package com.rndspell.game.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.rndspell.game.components.CameraComponent;
import com.rndspell.game.components.MovementComponent;
import com.rndspell.game.components.PositionComponent;

public class CameraSystem extends IteratingSystem {

    private OrthographicCamera camera;
    private CameraComponent cameraComponent;

    public CameraSystem (OrthographicCamera camera){
        super(Family.getFamilyFor(CameraComponent.class));
        this.camera = camera;
    }

    @Override
    public void processEntity(Entity entity, float deltaTime) {
        cameraComponent = entity.getComponent(CameraComponent.class);
        if (cameraComponent.isLocked() && entity.hasComponent(PositionComponent.class)) {
            camera.position.set(entity.getComponent(PositionComponent.class).getPosition(), 0);
        }

    }
}
