package com.rndspell.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class BoundsComponent extends Component implements Json.Serializable {

    private Rectangle bounds = new Rectangle();
    private Vector2 boundsOffset = new Vector2();
    private boolean passable = true;

    public BoundsComponent(float width, float height, Vector2 boundsOffset, boolean passable){
        this.bounds.setSize(width, height);
        this.boundsOffset = boundsOffset;
        this.passable = passable;
    }

    @Override
    public void write(Json json) {

    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        JsonValue boundsData = jsonData.get("bounds");
        float width = json.readValue("width", float.class, boundsData);
        float height = json.readValue("height", float.class, boundsData);
        this.bounds.setSize(width, height);
        json.readField(this, "boundsOffset", jsonData);
        json.readField(this, "passable", jsonData);
    }

    // GETTERS //

    public Rectangle getBounds() {
        return bounds;
    }

    public Vector2 getBoundsOffset() {
        return boundsOffset;
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
