package com.rndspell.game.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ArrayMap;
import com.rndspell.game.components.InputControlComponent;
import com.rndspell.game.components.MovementComponent;
import com.rndspell.game.components.PositionComponent;
import com.rndspell.game.components.StateComponent;

import java.util.HashMap;
import java.util.Map;

public class InputSystem extends IteratingSystem implements InputProcessor {

    private InputControlComponent inputControl;
    private MovementComponent movement;

    private enum Keys{ LEFT, RIGHT, UP, DOWN }
    private Map<Keys, Boolean> keys = new HashMap<Keys, Boolean>();

    public InputSystem(){
        super(Family.getFamilyFor(InputControlComponent.class, MovementComponent.class));
        keys.put(Keys.LEFT, false);
        keys.put(Keys.RIGHT, false);
        keys.put(Keys.UP, false);
        keys.put(Keys.DOWN, false);
    }

    @Override
    public void processEntity(Entity entity, float deltaTime) {
        inputControl = entity.getComponent(InputControlComponent.class);
        movement = entity.getComponent(MovementComponent.class);
        if(inputControl.isControllable()) {
            if (keys.get(Keys.LEFT)){
                movement.getAcceleration().x = -1;
            }
            if (keys.get(Keys.RIGHT)){
                movement.getAcceleration().x = 1;
            }
            if (keys.get(Keys.UP)){
                movement.getAcceleration().y = 1;
            }
            if (keys.get(Keys.DOWN)){
                movement.getAcceleration().y = -1;
            }
            if((!keys.get(Keys.LEFT) && !keys.get(Keys.RIGHT)) || (keys.get(Keys.LEFT) && keys.get(Keys.RIGHT))){
                movement.getAcceleration().x = 0;
            }
            if((!keys.get(Keys.UP) && !keys.get(Keys.DOWN)) || (keys.get(Keys.UP) && keys.get(Keys.DOWN))){
                movement.getAcceleration().y = 0;
            }
            movement.getAcceleration().nor().scl(movement.getAccelerationValue());

        }
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Input.Keys.LEFT:
                keys.put(Keys.LEFT, true);
                break;
            case Input.Keys.RIGHT:
                keys.put(Keys.RIGHT, true);
                break;
            case Input.Keys.UP:
                keys.put(Keys.UP, true);
                break;
            case Input.Keys.DOWN:
                keys.put(Keys.DOWN, true);
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case Input.Keys.LEFT:
                keys.put(Keys.LEFT, false);
                break;
            case Input.Keys.RIGHT:
                keys.put(Keys.RIGHT, false);
                break;
            case Input.Keys.UP:
                keys.put(Keys.UP, false);
                break;
            case Input.Keys.DOWN:
                keys.put(Keys.DOWN, false);
                break;
        }
        return false;

    }

    @Override
    public boolean keyTyped(char character) {
        return false;

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;

    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;

    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;

    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;

    }

    @Override
    public boolean scrolled(int amount) {
        return false;

    }
}
