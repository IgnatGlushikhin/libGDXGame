package com.rndspell.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class PositionComponent extends Component implements Json.Serializable {

    private Vector2 position;

    public PositionComponent(){
        position = new Vector2();
    }

    public PositionComponent(Vector2 position){
        this.position = position;
    }

    @Override
    public void write(Json json) {}

    @Override
    public void read(Json json, JsonValue jsonData) {
        json.readField(this, "position", jsonData);
    }

    // GETTERS //

    public Vector2 getPosition() {
        return position;
    }

    // END GETTERS //
}
