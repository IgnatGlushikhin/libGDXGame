package com.rndspell.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.rndspell.game.EntityState;

public class StateComponent extends Component implements Json.Serializable {

    private EntityState state = EntityState.IDLE;
    private Array<EntityState> availableStates = new Array<EntityState>();

    private void addAvailableState(EntityState state){
        availableStates.add(state);
    }

    @Override
    public void write(Json json) {

    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        for(JsonValue stateData = jsonData.get("availableStates").child; stateData != null; stateData = stateData.next){
            EntityState state = EntityState.valueOf(stateData.name);
            this.addAvailableState(state);
        }
    }
}
