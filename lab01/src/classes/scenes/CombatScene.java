package classes.scenes;

import interfaces.Combatente;
import interfaces.Scene;

import classes.Hero;
import classes.Monster;

import enums.SceneType;

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
        System.out.println("====================================================================================");
        System.out.println("=============== The hero has entered the " + getSceneType().getDescription() + "!");
        System.out.println("====================================================================================\n");
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
