package com.rpglab.dungeonadventure.interfaces;

import com.rpglab.dungeonadventure.characters.Hero;
import com.rpglab.dungeonadventure.enums.SceneType;

public interface Scene {
    public void Start(Hero hero);
    public boolean isCompleted();
    public SceneType getSceneType();
}