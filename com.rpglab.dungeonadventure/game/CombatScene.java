package com.rpglab.dungeonadventure.game;

import com.rpglab.dungeonadventure.characters.Hero;
import com.rpglab.dungeonadventure.characters.Monster;
import com.rpglab.dungeonadventure.enums.SceneType;
import com.rpglab.dungeonadventure.interfaces.Combatente;
import com.rpglab.dungeonadventure.interfaces.Scene;

public class CombatScene implements Scene {
    private SceneType type;
    private Monster[] monsters;

    public CombatScene(SceneType type, Monster[] monsters) {
        this.type = type;
        this.monsters = monsters;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    @Override
    public SceneType getSceneType() {
        return type;
    }

    @Override
    public void Start(Hero hero) {
        System.out.println("The hero enters the " + getSceneType().getDescription() + "!");
        getSceneType().applyEffect(hero);
    }

    @Override
    public boolean isCompleted() {
        for (Combatente monster : monsters) {
            if (monster.isAlive()) {
                return false;
            }
        }
        return true;
    }
}
