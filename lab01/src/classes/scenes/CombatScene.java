package classes.scenes;

import interfaces.Combatente;
import interfaces.Scene;
import classes.Hero;
import enums.SceneType;

public class CombatScene implements Scene {
    private SceneType type;
    private Combatente[] monsters; //TODO: Change to monster array

    public CombatScene(SceneType type) {
        this.type = type;
    }

    @Override
    public SceneType getSceneType() {
        return type;
    }

    @Override
    public void Start(Hero hero) {
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
