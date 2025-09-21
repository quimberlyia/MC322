package com.rpglab.game.game;

import com.rpglab.game.characters.Hero;
import com.rpglab.game.characters.Monster;
import com.rpglab.game.enums.SceneType;
import com.rpglab.game.interfaces.Combatente;
import com.rpglab.game.interfaces.Scene;

/**
 * Represents a combat encounter scene within the dungeon.
 * This class implements the Scene interface to create areas where
 * the hero must fight against one or more monsters before proceeding.
 * 
 * <p>Each combat scene has a specific type that determines its environmental
 * effects and contains an array of monsters that must be defeated. The scene
 * is considered completed when all monsters have been eliminated.</p>
 * 
 * <p>Combat scenes apply environmental effects when the hero enters,
 * such as lighting changes, atmospheric conditions, or terrain bonuses/penalties
 * depending on the scene type.</p>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 * @see Scene
 * @see SceneType
 * @see Monster
 */
public class CombatScene implements Scene {
    /** The type of scene, determining environmental effects and description */
    private SceneType type;
    /** Array of monsters that must be defeated to complete this scene */
    private Monster[] monsters;

    /**
     * Constructs a new combat scene with the specified type and monsters.
     * 
     * @param type     the scene type that determines environmental effects
     * @param monsters the array of monsters that inhabit this scene
     */
    public CombatScene(SceneType type, Monster[] monsters) {
        this.type = type;
        this.monsters = monsters;
    }

    /**
     * Returns the array of monsters in this combat scene.
     * This method provides access to the monsters that the hero
     * must face in this particular encounter.
     * 
     * @return the array of monsters inhabiting this scene
     */
    public Monster[] getMonsters() {
        return monsters;
    }

    /**
     * Returns the type of this scene.
     * The scene type determines environmental effects, descriptions,
     * and any special conditions that apply to this combat area.
     * 
     * @return the SceneType of this combat scene
     */
    @Override
    public SceneType getSceneType() {
        return type;
    }

    /**
     * Initiates the combat scene when the hero enters.
     * This method displays an atmospheric description of the scene
     * and applies any environmental effects based on the scene type.
     * 
     * @param hero the hero character entering this combat scene
     */
    @Override
    public void Start(Hero hero) {
        System.out.println("The hero enters the " + getSceneType().getDescription() + "!");
        getSceneType().applyEffect(hero);
    }

    /**
     * Checks if the combat scene has been completed.
     * A scene is considered completed when all monsters have been defeated
     * (i.e., none of the monsters are alive).
     * 
     * @return true if all monsters are defeated, false otherwise
     */
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
