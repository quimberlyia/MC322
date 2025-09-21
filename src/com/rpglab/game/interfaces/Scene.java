package com.rpglab.game.interfaces;

import com.rpglab.game.characters.Hero;
import com.rpglab.game.enums.SceneType;

public interface Scene {
    public void Start(Hero hero);
    public boolean isCompleted();
    public SceneType getSceneType();
}