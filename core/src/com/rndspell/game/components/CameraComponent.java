package com.rndspell.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class CameraComponent extends Component implements Json.Serializable {

    private boolean locked;

    public CameraComponent(boolean locked){
        this.locked = locked;
    }

    @Override
    public void write(Json json) {

    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        json.readField(this, "locked", jsonData);
    }

    // GETTERS //

    public boolean isLocked() {
        return locked;
    }

    // END GETTERS //
}
