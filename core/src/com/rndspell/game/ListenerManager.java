package com.rndspell.game;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ArrayMap;
import com.rndspell.game.events.CollisionEvent;

public class ListenerManager {

    private static ListenerManager instance;

    public static ListenerManager getInstance(){
        if(null == instance){
            instance = new ListenerManager();
        }
        return instance;
    }

    private ArrayMap<Class<?>, Array<Listener>> listeners = new ArrayMap<Class<?>, Array<Listener>>();

    public ListenerManager(){
        listeners.put(CollisionEvent.class, new Array<Listener>());
    }

    // GETTERS //

    public ArrayMap<Class<?>, Array<Listener>> getListeners() {
        return listeners;
    }

    // END GETTERS //

}
