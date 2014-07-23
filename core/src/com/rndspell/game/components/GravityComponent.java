package com.rndspell.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class GravityComponent extends Component implements Json.Serializable {

    private Vector2 gravity = new Vector2();

    public GravityComponent() {
        super();
    }

    public GravityComponent(Vector2 gravity){
        this.gravity = gravity;
    }

    @Override
    public void write(Json json) {

    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        json.readField(this, "gravity", jsonData);
    }
}
