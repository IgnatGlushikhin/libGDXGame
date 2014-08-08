package com.rndspell.game.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.rndspell.game.components.AnimationComponent;
import com.rndspell.game.components.RenderComponent;

public class AnimationSystem extends IteratingSystem {

    private AnimationComponent animation;
    private RenderComponent render;
    private float stateTime = 0;


    public AnimationSystem(){
        super(Family.getFamilyFor(AnimationComponent.class, RenderComponent.class));
    }

    @Override
    public void processEntity(Entity entity, float deltaTime) {
        animation = entity.getComponent(AnimationComponent.class);
        render = entity.getComponent(RenderComponent.class);


    }
}
