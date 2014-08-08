package com.rndspell.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.rndspell.game.GameAssetManager;

public class RenderComponent extends Component implements Json.Serializable {

    private String assetsId;
    private TextureRegion frame = GameAssetManager.getInstance().get("textures/textures.atlas", TextureAtlas.class).findRegion("null");
    private float width;
    private float height;
    private Vector2 frameOffset = new Vector2();

    public RenderComponent(String assetsId, float width, float height, Vector2 offset){
        this.assetsId = assetsId;
        this.width = width;
        this.height = height;
        this.frameOffset = offset;
    }

    public RenderComponent(TextureRegion texture, float width, float height, Vector2 offset){
        this.frame = texture;
        this.width = width;
        this.height = height;
        this.frameOffset = offset;
    }

    @Override
    public void write(Json json) {

    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        json.readField(this, "assetsId", jsonData);
        json.readField(this, "width", jsonData);
        json.readField(this, "height", jsonData);
        json.readField(this, "frameOffset", jsonData);
    }

    // GETTERS //


    public String getAssetsId() {
        return assetsId;
    }

    public Vector2 getFrameOffset() {
        return frameOffset;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public TextureRegion getFrame() {
        return frame;
    }

    // END GETTERS //
}
