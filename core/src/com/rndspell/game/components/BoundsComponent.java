package com.rndspell.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class BoundsComponent extends Component implements Json.Serializable {

    private Rectangle bounds;
    private boolean passable = true;

    public BoundsComponent() {
        super();
    }

    public BoundsComponent(Rectangle bounds){
        this.bounds = bounds;
    }

    @Override
    public void write(Json json) {

    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        json.readField(this, "bounds", jsonData);
        json.readField(this, "passable", jsonData);
    }

    // GETTERS //

    public Rectangle getBounds() {
        return bounds;
    }

    public boolean isPassable() {
        return passable;
    }

    // END GETTERS //

    // SETTERS //

    public void setPassable(boolean passable) {
        this.passable = passable;
    }

    // END SETTERS //
}
