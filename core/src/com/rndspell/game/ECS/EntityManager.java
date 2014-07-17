package com.rndspell.game.ECS;

import com.badlogic.gdx.utils.IntMap;

public class EntityManager {

    private static EntityManager instance;

    public static EntityManager getInstance(){
        if(null == instance){
            instance = new EntityManager();
        }
        return instance;
    }

    private IntMap<Entity> entityMap;

    public EntityManager(){}

    public void init(){
        entityMap = new IntMap<Entity>();
    }

    public Entity getEntity(int id){
        if(entityMap.containsKey(id)) return entityMap.get(id);
        return null;
    }

    public void registerEntity(Entity entity){
        int new_id = 0;
        while (entityMap.containsKey(new_id)){
            new_id++;
        }
        entity.setId(new_id);
        entityMap.put(new_id, entity);
    }

}
