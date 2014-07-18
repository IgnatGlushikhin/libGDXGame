package com.rndspell.game.ECS;

import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.JsonValue;

public class ComponentManager<T extends Component> {

    private Class<T> componentType;
    private IntMap<T> componentMap = new IntMap<T>();

    public ComponentManager(Class<T> componentType){
        this.componentType = componentType;
    }

    public T getComponent(int entityId){
        return componentMap.get(entityId);
    }

    public void addComponent(int entityId, T component){
        componentMap.put(entityId, component);
    }
}
