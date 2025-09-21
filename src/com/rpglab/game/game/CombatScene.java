package com.rpglab.game.game;

import com.rpglab.game.characters.Hero;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.enums.SceneType;
import com.rpglab.game.interfaces.Combatente;
import com.rpglab.game.interfaces.Scene;

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
