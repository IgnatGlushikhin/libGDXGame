package com.rndspell.game.ECS;

import com.badlogic.gdx.utils.Array;

public class Entity {

    private int id;
    private String name;

    private Array<Component> components = new Array<Component>();

    public Entity(){}

    public void init(){}

    public void addComponent(Component component){
        components.add(component);
    }

    //GETTERS//

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Array<Component> getComponents() {
        return components;
    }
    //END GETTERS//

    //SETTERS//

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    //END SETTERS//

}
