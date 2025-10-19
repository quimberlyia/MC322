package com.rpglab.game.characters.monsters;

import com.rpglab.game.characters.Monster;
import com.rpglab.game.interfaces.CombatAction;
import com.rpglab.game.enums.WeaponType;

/**
 * Represents a Lizardman monster in the Dungeon Adventure RPG.
 * Lizardmen are reptilian warriors that serve as mid-tier enemies in the
 * dungeon entrance. They are more dangerous than slimes and skeletons,
 * utilizing multiple natural weapons including claws, fangs, and tail.
 * 
 * <p>Lizardmen are equipped with three combat actions:</p>
 * <ul>
 *   <li>Poisonous Bite - A venomous bite attack with toxic damage</li>
 *   <li>Claw Swipe - A swift slashing attack with natural claws</li>
 *   <li>Tail Whip - A quick lashing attack using their flexible tail</li>
 * </ul>
 * 
 * @author quimberlyia and gaamelu
 * @version 1.0
 * @since 1.0
 */
public class Lizardman extends Monster {

    /**
     * Constructs a new Lizardman monster with the specified attributes.
     * Automatically equips the lizardman with Poisonous Bite, Claw Swipe,
     * and Tail Whip combat actions.
     * 
     * @param healthPoints The lizardman's initial health points
     * @param strength The lizardman's strength value
     * @param experience The experience points awarded when this lizardman is defeated
     * @param lootTable Array of weapon types this lizardman can drop as loot (shared via aggregation)
     * @param moves List of shared instances of combat action
     */
    public Lizardman(int healthPoints, int strength, int experience, WeaponType[] lootTable, CombatAction[] moves) {
        super("Lizardman", healthPoints, strength, experience, lootTable, moves);
    }
}
