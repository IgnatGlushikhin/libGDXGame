package com.rndspell.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class FrictionComponent extends Component implements Json.Serializable {

    private float frictionValue;

    public FrictionComponent(float frictionValue){
        this.frictionValue = frictionValue;
    }

    @Override
    public void write(Json json) {

    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        json.readField(this, "frictionValue", jsonData);
    }

    // GETTERS //

    public float getFrictionValue() {
        return frictionValue;
    }

    // END GETTERS //

}
