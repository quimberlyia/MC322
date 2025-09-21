package com.rpglab.game.enums;
import com.rpglab.game.characters.Hero;

/**
 * Represents different types of scenes in the Dungeon Adventure RPG with unique effects.
 * Each scene type has a description and applies specific effects to heroes who enter them.
 * These scenes represent different locations within the Demon King's castle.
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public enum SceneType {
    /**
     * The entrance to the Demon King's castle.
     * Creates an atmospheric introduction with no damage.
     */
    DUNGEON_ENTRANCE("Castle of the Demon King") {
        /**
         * Applies the entrance effect to the hero.
         * Provides atmospheric text without causing damage.
         * 
         * @param hero The hero entering the castle
         */
        @Override
        public void applyEffect(Hero hero) {
            System.out.println("You feel a chill as you enter the castle.");
        }
    },
    
    /**
     * A dark hallway leading to the Demon King.
     * Damages the hero due to the eerie atmosphere.
     */
    DARK_HALLWAY("Dark Hallway to the Demon King") {
        /**
         * Applies the dark hallway effect to the hero.
         * Causes 10 points of atmospheric damage.
         * 
         * @param hero The hero traversing the hallway
         */
        @Override
        public void applyEffect(Hero hero) {
            System.out.println("You hear eerie sounds echoing through the hallway.");
            hero.takeDamage(10);
            System.out.println("The Hero has taken 10 damage from the eerie atmosphere.");
            
        }
    },
    
    /**
     * The Demon King's throne room where the final battle takes place.
     * Inflicts significant damage as the hero faces the final boss.
     */
    MONSTER_LAIR("Demon King's Room") {
        /**
         * Applies the monster lair effect to the hero.
         * Announces the final battle and causes 30 points of damage.
         * 
         * @param hero The hero entering the final battle
         */
        @Override
        public void applyEffect(Hero hero) {
            // Example effect: Final battle with the Demon King
            System.out.println("The Demon King appears! Prepare for the final battle!");
            hero.takeDamage(30); 
            System.out.println("The Hero has taken 30 damage from the Demon King.");
        }
    };

    /** The descriptive name of this scene type */
    private String description;

    /**
     * Constructs a SceneType with the specified description.
     * 
     * @param description The descriptive name for this scene type
     */
    SceneType(String description) {
        this.description = description;
    }

    /**
     * Returns the description of this scene type.
     * 
     * @return The descriptive name of the scene
     */
    public String getDescription() {
        return description;
    }

    /**
     * Applies the specific effect of this scene type to the given hero.
     * Each scene type implements this method differently to provide unique experiences.
     * 
     * @param hero The hero who will be affected by this scene
     */
    public abstract void applyEffect(Hero hero);
}
