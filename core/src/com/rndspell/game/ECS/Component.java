package com.rndspell.game.ECS;

import com.badlogic.gdx.utils.Array;

public abstract class Component {

    public static String typeName;

    private Entity parent;
    private Array<? extends Component> requiredComponents;

    public Component(){
        requiredComponents = new Array<Component>();
    }

    public void addRequiredComponent(Class<? extends Component> component){
    }

    // GETTERS //

    public Entity getParent() {
        return parent;
    }

    public Array<? extends Component> getRequiredComponents() {
        return requiredComponents;
    }

    // END GETTERS //

    // SETTERS //

    public void setParent(Entity parent) {
        this.parent = parent;
    }

    // END SETTERS //

}
