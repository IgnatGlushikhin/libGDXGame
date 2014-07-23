package com.rndspell.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.rndspell.game.EntityState;
import com.rndspell.game.GameAssetManager;

public class AnimationComponent extends Component implements Json.Serializable {

    private ArrayMap<EntityState, Animation> animations = new ArrayMap<EntityState, Animation>();
    private Animation currentAnimation;

    public AnimationComponent() {
        super();
    }

    public void addAnimation(EntityState entityState, Animation animation){
        animations.put(entityState, animation);
    }


    @Override
    public void write(Json json) {

    }

    @Override
    public void read(Json json, JsonValue jsonData) {

    }

    // GETTERS //

    public ArrayMap<EntityState, Animation> getAnimations() {
        return animations;
    }

    public Animation getCurrentAnimation() {
        return currentAnimation;
    }

    // END GETTERS //

    // SETTERS //

    public void setCurrentAnimation(Animation currentAnimation) {
        this.currentAnimation = currentAnimation;
    }

    // END SETTERS //
}
