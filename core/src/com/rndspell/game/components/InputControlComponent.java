package com.rndspell.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class InputControlComponent extends Component implements Json.Serializable {

    private boolean controllable;

    public InputControlComponent() {
        super();
    }

    public InputControlComponent(boolean controllable){
        this.controllable = controllable;
    }

    @Override
    public void write(Json json) {

    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        json.readField(this, "controllable", jsonData);
    }

    // GETTERS //

    public boolean isControllable() {
        return controllable;
    }

    // END GETTERS //

    // SETTERS //

    public void setControllable(boolean controllable) {
        this.controllable = controllable;
    }

    // END SETTERS //
}
