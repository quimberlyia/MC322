package classes.interfaces;

import classes.Hero;
import classes.enums.SceneType;

public interface Scene {
    public void Start(Hero hero);
    public boolean isCompleted();
    public SceneType getSceneType();
}