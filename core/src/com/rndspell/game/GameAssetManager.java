package com.rndspell.game;

import com.badlogic.gdx.assets.AssetManager;

public class GameAssetManager extends AssetManager{

    private static GameAssetManager instance;

    public static GameAssetManager getInstance(){
        if(null == instance){
            instance = new GameAssetManager();
        }
        return instance;
    }

    public void init(){}
}
