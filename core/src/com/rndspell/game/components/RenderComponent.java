package com.rndspell.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.rndspell.game.GameAssetManager;

public class RenderComponent extends Component implements Json.Serializable {

    private TextureRegion frame = GameAssetManager.getInstance().get("textures/textures.atlas", TextureAtlas.class).findRegion("null");
    private Vector2 frameOffset = new Vector2();

    public RenderComponent(){}

    public RenderComponent(Vector2 offset){
        this.frameOffset = offset;
    }
    public RenderComponent(TextureRegion texture, Vector2 offset){
        this.frame = texture;
        this.frameOffset = offset;
    }

    @Override
    public void write(Json json) {

    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        json.readField(this, "frameOffset", jsonData);
    }

    // GETTERS //

    public Vector2 getFrameOffset() {
        return frameOffset;
    }

    public TextureRegion getFrame() {
        return frame;
    }

    // END GETTERS //
}
