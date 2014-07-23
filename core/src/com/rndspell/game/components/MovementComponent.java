package com.rndspell.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class MovementComponent extends Component implements Json.Serializable {

    private Vector2 velocity = new Vector2();
    private Vector2 acceleration = new Vector2();
    private float accelerationValue;
    private float maxVelocity;

    public MovementComponent(float accelerationValue, float maxVelocity){
        this.accelerationValue = accelerationValue;
        this.maxVelocity= maxVelocity;
    }

    @Override
    public void write(Json json) {}

    @Override
    public void read(Json json, JsonValue jsonData) {
        json.readField(this, "accelerationValue", jsonData);
        json.readField(this, "maxVelocity", jsonData);
    }

    // GETTERS //

    public Vector2 getVelocity() {
        return velocity;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public float getAccelerationValue() {
        return accelerationValue;
    }

    public float getMaxVelocity() {
        return maxVelocity;
    }

    // END GETTERS //
}
