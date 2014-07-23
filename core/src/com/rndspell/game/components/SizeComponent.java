package com.rndspell.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class SizeComponent extends Component implements Json.Serializable {

    private float width;
    private float height;

    public SizeComponent(){}

    public SizeComponent(float width, float height){
        this.width = width;
        this.height = height;
    }

    @Override
    public void write(Json json) {

    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        json.readField(this, "width", jsonData);
        json.readField(this, "height", jsonData);
    }

    // GETTERS //

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    // END GETTERS //
}
