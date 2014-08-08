package com.rndspell.game.events;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;

public class CollisionEvent {
    private Array<Entity> entities = new Array<Entity>();

    public CollisionEvent(Entity[] entities){
        this.entities.addAll(entities);
    }

    // GETTERS //

    public Array<Entity> getEntities() {
        return entities;
    }

    // END GETTERS //
}
