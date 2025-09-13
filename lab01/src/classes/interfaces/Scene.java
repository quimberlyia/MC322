package classes.interfaces;

import classes.Hero;

public interface Scene {
    public void Start(Hero hero);
    public boolean isCompleted();
    public String getSceneType();
}